package camunda_go.config;

import org.camunda.bpm.engine.RepositoryService;


import javax.annotation.PostConstruct;

import org.camunda.bpm.engine.repository.Deployment;
import org.camunda.bpm.engine.repository.DeploymentBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

@Component
public class ProcessDeployer {

    @Autowired
    private RepositoryService repositoryService;


        @PostConstruct
        public void deployAllProcesses() {
            try (Stream<Path> paths = Files.walk(Paths.get("bpmn/simple-s.bpmn"))) {
                DeploymentBuilder deployment = repositoryService.createDeployment();



                InputStream is = getClass().getResourceAsStream("bpmn");
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(is.readAllBytes());

                paths.filter(Files::isRegularFile) // Фильтруем только файлы
                        .filter(path -> path.toString().endsWith(".bpmn")) // Оставляем только .bpmn файлы
                        .forEach(path -> {
                            try {
                                // Читаем содержимое файла
                                String content = Files.readString(path, StandardCharsets.UTF_8);

                                // Добавляем пробел в конец содержимого (в памяти, без сохранения)
                                if (!content.endsWith(" ")) {
                                    content += " ";
                                }

                                // Создаем поток с модифицированным содержимым
                                ByteArrayInputStream inputStream = new ByteArrayInputStream(content.getBytes(StandardCharsets.UTF_8));

                                // Добавляем этот файл как поток (в памяти) в развертывание
                                String resourceName = "processes/" + path.getFileName().toString();
                                deployment.addInputStream(resourceName, inputStream);

                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        });

                deployment.deploy();
                System.out.println("All BPMN processes have been deployed with a trailing space (in-memory).");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

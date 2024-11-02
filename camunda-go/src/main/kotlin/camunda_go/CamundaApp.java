package camunda_go;

//import camunda_go.config.DataBaseInitializer;
import camunda_go.config.DataBaseInitializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;

@SpringBootApplication
class CamundaApp {
//    static {
//        String filePath = "C:\\Users\\rmanasipov\\IdeaProjects\\education_shelf\\camunda-go\\target\\classes\\bpmn\\simple-s.bpmn";
//
//        try {
////            Files.walkFileTree(Paths.get(filePath), new SimpleFileVisitor<Path>());
//
//            // Чтение текущего содержимого файла
//            String content = new String(Files.readAllBytes(Paths.get(filePath)));
//
//            content += System.lineSeparator();
//            // Запись этого же содержимого обратно в файл (перезапись)
//            Files.write(Paths.get(filePath), content.getBytes(), StandardOpenOption.TRUNCATE_EXISTING);
//
//            System.out.println("Файл успешно перезаписан без изменения содержимого.");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    static {
        DataBaseInitializer dataBaseInitializer = new DataBaseInitializer();
        try {
            dataBaseInitializer.run("dfsf", "ds");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(CamundaApp.class, args);
    }
}

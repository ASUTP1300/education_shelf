package edu.spring_upload_file;

import edu.spring_upload_file.client.UploadClient;
import edu.spring_wf.client.PersonClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
@SpringBootApplication
@EnableFeignClients(
        clients = { PersonClient.class}
)
public class SpringUploadFileApp {
    public static void main(String[] args) {
        SpringApplication.run(SpringUploadFileApp.class, args);
    }
}

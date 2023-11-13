package edu.spring_upload_file;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
@SpringBootApplication
@EnableFeignClients
public class SpringUploadFileApp {
    public static void main(String[] args) {
        SpringApplication.run(SpringUploadFileApp.class, args);
    }
}

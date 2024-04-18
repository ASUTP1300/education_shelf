package edu.load.config;

import edu.load.client.UploadFile;
import feign.Feign;
import feign.Response;
import feign.form.spring.SpringFormEncoder;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class Test {

    String HTTP_FILE_UPLOAD_URL = "http://localhost:8086/api/v0/bankstatements";

    @EventListener(ApplicationReadyEvent.class)
    void test() throws IOException {
        byte[] statement1 =
                Test.class.getClassLoader().getResourceAsStream("044525555/psb-sample-1.txt").readAllBytes();
        byte[] statement2 =
                Test.class.getClassLoader().getResourceAsStream("044525555/psb-sample-2.txt").readAllBytes();

        List<MultipartFile> files = new ArrayList<>();
        files.add(new MockMultipartFile("s1", statement1));
        files.add(new MockMultipartFile("s2", statement2));

        uploadBankStatement(files, "042202603", "SECTIONAL_PSB");


    }


    public boolean uploadBankStatement(List<MultipartFile> files, String bank, String pattern) {
        UploadFile uploadFile =
                Feign.builder()
                        .encoder(new SpringFormEncoder())
                        .target(UploadFile.class, HTTP_FILE_UPLOAD_URL);
        Response response = uploadFile.uploadBankStatement(bank, pattern, files);
        return response.status() == 200;
    }
}

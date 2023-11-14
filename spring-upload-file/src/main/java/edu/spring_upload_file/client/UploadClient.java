package edu.spring_upload_file.client;

import edu.spring_upload_file.config.FeignSupportConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


@FeignClient(
        name = "file",
        url = "http://localhost:9066",
        configuration = FeignSupportConfig.class
)
public interface UploadClient {

    @PostMapping(value = "/upload")
    public ResponseEntity<String> fileUpload(
            @RequestParam(name = "files") MultipartFile[] files,
            @RequestParam(name = "bank") String bank,
            @RequestParam(name = "pattern")  String pattern
    );
}

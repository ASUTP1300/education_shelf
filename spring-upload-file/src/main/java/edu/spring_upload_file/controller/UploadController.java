package edu.spring_upload_file.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class UploadController {

    @PostMapping(value = "/upload")
    public ResponseEntity<String> fileUpload(
            @RequestParam(name = "files") MultipartFile[] files,
            @RequestParam(name = "bank") String bank,
            @RequestParam(name = "pattern")  String pattern
    ) throws IOException {

        return ResponseEntity.ok("200" + "  " + bank);
    }

}

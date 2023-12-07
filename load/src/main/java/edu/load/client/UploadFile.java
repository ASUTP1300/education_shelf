package edu.load.client;

import feign.Headers;
import feign.Param;
import feign.RequestLine;
import feign.Response;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


public interface UploadFile {

    @RequestLine("POST")
    @Headers("Content-Type: multipart/form-data")
    Response uploadBankStatement(
            @Param(value = "bank") String bank,
            @Param(value = "pattern") String pattern,
            @Param(value = "files") List<MultipartFile> files
    );
}

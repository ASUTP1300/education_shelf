//package edu.spring_upload_file.client;
//
//import edu.spring_upload_file.config.FeignSupportConfig;
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.http.MediaType;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestPart;
//import org.springframework.web.multipart.MultipartFile;
//
//
//@FeignClient(
//        name = "file",
//        url = "http://localhost:9066",
//        configuration = FeignSupportConfig.class
//)
//public interface UploadClient {
//
//    @PostMapping(value = "/upload-file", consumes = MediaType.APPLICATION_OCTET_STREAM_VALUE)
//    void fileUpload(@RequestPart(value = "file") MultipartFile file);
//}

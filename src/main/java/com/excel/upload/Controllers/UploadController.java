package com.excel.upload.Controllers;

import com.excel.upload.Services.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@RestController
public class UploadController {

    @Autowired
    private UploadService service;


    @ApiIgnore
    @RequestMapping(value = "/")
    public void redirect (HttpServletResponse response) throws IOException {
        response.sendRedirect("swagger-ui.html");
    }


    @PostMapping("/import")
    public String importData(@RequestParam("file") MultipartFile file) {
        try {
            service.importData(file);
            return "Data imported successfully!";
        } catch (IOException e) {
            return "Failed to import data: " + e.getMessage();
        }
    }
}

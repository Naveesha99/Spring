package com.excel.upload.Controllers;

import com.excel.upload.DTO.EmailRequest;
import com.excel.upload.Services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class EmailController {

    @Autowired
    private EmailService emailService;

    @ApiIgnore
    @RequestMapping(value = "/")
    public void redirect (HttpServletResponse response) throws IOException {
        response.sendRedirect("swagger-ui.html");
    }

    @PostMapping("/send-email")
    public String sendEmail(@RequestBody EmailRequest emailRequest) {
        emailService.sendEmail(emailRequest.getTo(), emailRequest.getSubject(), emailRequest.getText());
        return "Email sent successfully!";
    }
}

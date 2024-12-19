package com.nex_sdcb_admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class NexSdcbAdminApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        // Spring Boot에서 프로파일 설정을 자동으로 읽음
        return application.sources(NexSdcbAdminApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(NexSdcbAdminApplication.class);

        app.run(args);
    }
}

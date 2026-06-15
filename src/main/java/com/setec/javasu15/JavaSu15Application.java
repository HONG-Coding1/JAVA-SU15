package com.setec.javasu15;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class JavaSu15Application {

    public static void main(String[] args) {
        SpringApplication.run(JavaSu15Application.class, args);
    }

    @Component
    static class ApiStartupInfo implements ApplicationRunner {

        private final Environment environment;

        ApiStartupInfo(Environment environment) {
            this.environment = environment;
        }

        @Override
        public void run(ApplicationArguments args) {
            String port = environment.getProperty("server.port", "8080");
            String contextPath = environment.getProperty("server.servlet.context-path", "");
            String baseUrl = "http://localhost:" + port + contextPath + "/api/v2/students";

            System.out.println();
            System.out.println("========================================");
            System.out.println("API is ready to test:");
            System.out.println("List students:   GET    " + baseUrl);
            System.out.println("Get student:     GET    " + baseUrl + "/1");
            System.out.println("Create student:  POST   " + baseUrl);
            System.out.println("Update student:  PUT    " + baseUrl + "/1");
            System.out.println("Delete student:  DELETE " + baseUrl + "/1");
            System.out.println();
            System.out.println("Example create request:");
            System.out.println("curl -X POST " + baseUrl + " -H \"Content-Type: application/json\" -d \"{\\\"first_name\\\":\\\"Dara\\\",\\\"last_name\\\":\\\"Sok\\\",\\\"email\\\":\\\"dara@example.com\\\",\\\"phone_number\\\":\\\"012345678\\\",\\\"address\\\":\\\"Phnom Penh\\\",\\\"password\\\":\\\"123456\\\"}\"");
            System.out.println("========================================");
            System.out.println();
        }
    }

}

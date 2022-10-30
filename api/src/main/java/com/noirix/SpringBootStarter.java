package com.noirix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = "com.noirix")
@EnableAspectJAutoProxy(proxyTargetClass = true)
@EnableTransactionManagement
public class SpringBootStarter {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootStarter.class, args);
        System.out.println("Springboot starts");

    }

}

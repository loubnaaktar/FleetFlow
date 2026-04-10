package org.example.fleetflow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class FleetFlowApplication {

    public static void main(String[] args) {
        SpringApplication.run(FleetFlowApplication.class, args);
//
//        // ✅ FORCE LES PROPRIÉTÉS AVANT LE DÉMARRAGE
//        app.setDefaultProperties(
//                java.util.Map.of(
//                        "spring.datasource.url", "jdbc:mysql://localhost:3306/fleetflow?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true",
//                        "spring.datasource.username", "root",
//                        "spring.datasource.password", "nouha23",
//                        "spring.datasource.driver-class-name", "com.mysql.cj.jdbc.Driver",
//                        "spring.jpa.hibernate.ddl-auto", "update",
//                        "spring.jpa.show-sql", "true"
//                )
//        );
//
//        System.out.println(" Starting FleetFlow with FORCED DB config...");
//        app.run(args);
    }
}
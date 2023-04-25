package com.beyonder.carservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;

@SpringBootApplication
@RestController
@RequestMapping("/api/v1/test")
public class CarServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarServiceApplication.class, args);
    }

    @GetMapping
    public String test() {
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5435/userdb";
            String username = "uroot";
            String password = "qwertyui";
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM accounts";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                // process each row
                long userId = rs.getLong("user_id");
                String userName = rs.getString("username");
                // retrieve other columns
                System.out.println(userId + "\t" + userName);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }


        return "Allo";
    }



}

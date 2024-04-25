package com.database;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * @author chenjy
 * @date 2024-04-25
 */
@SpringBootApplication()
@MapperScan("com.database.mysql.**.mapper")
public class DatabaseImportExportApplication {

    public static void main(String[] args) {
        SpringApplication.run(DatabaseImportExportApplication.class, args);
    }

}

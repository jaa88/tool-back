package cn.connext.toolback;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.connext.toolback.dao")
public class ToolbackApplication {

    public static void main(String[] args) {
        SpringApplication.run(ToolbackApplication.class, args);
    }

}


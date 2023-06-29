package cn.connext.toolback;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
/*@MapperScan("cn.connext.toolback.dao")*/
public class ToolbackApplication extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder applicationBuilder) {
        return applicationBuilder.sources(ToolbackApplication.class);
    }


    public static void main(String[] args) {
        SpringApplication.run(ToolbackApplication.class, args);
    }

}


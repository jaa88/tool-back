package cn.connext.toolback.util;

import cn.connext.toolback.service.ArrangeClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class Scheduling {

    @Autowired
    ArrangeClassService arrangeClassService;

    // 初始时延迟120秒，每隔3600秒
    @Scheduled(fixedRateString = "3600000",initialDelay = 120000)
    /*@Scheduled(fixedRateString = "30000",initialDelay = 5000)*/
    public void fixedRate(){
        arrangeClassService.checkAndInsertArrangeClass();
        //System.out.println("==>初始延迟5秒，每隔30秒");
    }
}


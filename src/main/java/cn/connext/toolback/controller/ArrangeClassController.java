package cn.connext.toolback.controller;

import cn.connext.toolback.entity.ResultResponse;
import cn.connext.toolback.entity.manage.ArrangeClass;
import cn.connext.toolback.service.ArrangeClassService;
import cn.connext.toolback.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

@CrossOrigin
@Controller
@RequestMapping("/arrangeClass")
public class ArrangeClassController {

    @Autowired
    ArrangeClassService arrangeClassService;

    //查询最新的排班信息
    @RequestMapping("/queryTargetDateArrangeClass")
    @ResponseBody
    public ResultResponse queryLatestClassInfo(@RequestParam(value = "targetDate",required = false)Long targetDateMills, HttpServletRequest request){
        ResultResponse response=new ResultResponse();
        //比如传入的是8：30以后，就是当天的班次，不然就是前一个班次的
        Date trueDutyDate=CommonUtil.getTrueDutyClassDate(targetDateMills!=null?new Date(targetDateMills):new Date());
        //看看有没有这个排班
        ArrangeClass arrangeClass =arrangeClassService.selectTargetDateArrangeClass(new SimpleDateFormat("yyyy-MM-dd").format(trueDutyDate));
        response.setResult(arrangeClass);

        System.out.println(arrangeClass.getChengxiangDayTimePolice());
        return response;
    }
}

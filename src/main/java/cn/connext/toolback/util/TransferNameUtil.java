package cn.connext.toolback.util;

public class TransferNameUtil {
    public static String transferUserCategoryName(int category){
        if(category==101){
            return "领导";
        }else if(category==102){
            return "民警(事故)";
        }else if(category==103){
            return "民警(铁骑)";
        }else if(category==104){
            return "民警(外围)";
        }else if(category==105){
            return "民警(其他)";
        }else if(category==201){
            return "辅警(铁骑)";
        }else if(category==202){
            return "辅警(重骑)";
        }else if(category==203){
            return "辅警(外围)";
        }else if(category==204){
            return "辅警(机动)";
        }else if(category==205){
            return "辅警(城警)";
        }else if(category==206){
            return "辅警(事故)";
        }else if(category==207){
            return "辅警(勤务)";
        }else if(category==208){
            return "辅警(源头)";
        }else if(category==209){
            return "辅警(法制)";
        }else if(category==210){
            return "辅警(内勤)";
        }else if(category==211){
            return "辅警(窗口)";
        }else if(category==212){
            return "辅警(农副)";
        }else if(category==213){
            return "辅警(其他)";
        }else{
            return "未知";
        }
    }

    public static String transferDutyCategoryName(String dutyCategory){
        if("Z".equals(dutyCategory)){
            return "";
        }else {
            return dutyCategory;
        }
    }

    public static String transferDutyAreaName(int dutyArea){
        if(dutyArea==1){
            return "城厢";
        }else if(dutyArea==2){
            return "高新";
        }else {
            return "";
        }
    }
}

package cn.connext.toolback.util;

public class TransferNameUtil {
    public static String transferUserCategoryName(int category){
        if(category==1){
            return "领导";
        }else if(category==2){
            return "民警(事故)";
        }else if(category==3){
            return "民警(铁骑)";
        }else if(category==4){
            return "民警(外围)";
        }else if(category==5){
            return "民警(其他)";
        }else if(category==6){
            return "辅警(铁骑)";
        }else if(category==7){
            return "辅警(重骑)";
        }else if(category==8){
            return "辅警(外围)";
        }else if(category==9){
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
        }else{
            return "高新";
        }
    }
}

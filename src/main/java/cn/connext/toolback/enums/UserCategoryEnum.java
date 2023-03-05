package cn.connext.toolback.enums;

public enum UserCategoryEnum {
    POLICE_MANAGER("领导",1),
    POLICE_MALFUNCTION("民警(事故)",2),
    POLICE_MOTO("民警(铁骑)",3),
    POLICE_OUTER("民警(外围)",4),
    POLICE_OTHER("民警(其他)",5),
    ASSIST_MOTOR("辅警(铁骑)",6),
    ASSIST_MOTOR_BLACK("辅警(重骑)",7),
    ASSIST_OUTER("辅警(外围)",8),
    ASSIST_OTHER("辅警(其他)",9);

    // 成员变量
    private String name;
    private int index;

    public String getName() {
        return name;
    }

    public int getIndex() {
        return index;
    }

    // 构造方法
    private UserCategoryEnum(String name,int index) {
        this.name = name;
        this.index = index;
    }
}

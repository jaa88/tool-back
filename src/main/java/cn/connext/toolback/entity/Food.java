package cn.connext.toolback.entity;

/**
 *  用户类，对应user表
 */
public class Food {
    private Long id;
    //名字
    private String name;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

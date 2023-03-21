package cn.connext.toolback.service;

import cn.connext.toolback.entity.manage.ArrangeClass;

import java.util.Date;

public interface ArrangeClassService {
    /**
     * 查询对应班次表内有没有排班信息
     * @return
     */
    ArrangeClass selectTargetDateArrangeClass(String dateString);

    void checkAndInsertArrangeClass();
}

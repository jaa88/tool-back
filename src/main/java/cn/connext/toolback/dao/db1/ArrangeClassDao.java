package cn.connext.toolback.dao.db1;

import cn.connext.toolback.entity.User;
import cn.connext.toolback.entity.manage.ArrangeClass;
import cn.connext.toolback.entity.manage.QueryUserListParam;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 *
 */
@Repository
public interface ArrangeClassDao {
    ArrangeClass selectTargetDateArrangeClass(String date);

    ArrangeClass selectLastArrangeClassByDutyCategory(String dutyCategory);

    int addArrangeClass(ArrangeClass arrangeClass);
}

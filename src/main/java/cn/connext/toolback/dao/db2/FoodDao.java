package cn.connext.toolback.dao.db2;

import cn.connext.toolback.entity.Food;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 */
@Repository
public interface FoodDao {
    List<Food> selectAllFood();

    int selectAllCount();


}

package cn.itcast.travel.dao.category;

import cn.itcast.travel.domain.Category;

import java.util.List;

/**
 * 路线dao
 * @author david
 * @create 2019-06-15 13:08
 */
public interface CategoryDao {
    /**
     * 查询所有路线信息
     * @return
     */
    public List<Category> findAll();
}

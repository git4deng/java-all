package cn.itcast.travel.service.category;

import cn.itcast.travel.domain.Category;

import java.util.List;

/**
 * 路线类型service
 * @author david
 * @create 2019-06-15 12:55
 */
public interface CategoryService {
    /**
     * 查询所有的路线
     * @return
     */
    public List<Category> findAll();
}

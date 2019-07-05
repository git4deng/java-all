package cn.itcast.travel.dao.category.impl;

import cn.itcast.travel.dao.category.CategoryDao;
import cn.itcast.travel.domain.Category;
import cn.itcast.travel.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @author david
 * @create 2019-06-15 13:10
 */
public class CategoryDaoImpl implements CategoryDao{

    private JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());
    /**
     * 查询所有路线信息
     * @return
     */
    @Override
    public List<Category> findAll() {
        String sql="select * from tab_category ";
        List<Category> categories = template.query(sql, new BeanPropertyRowMapper<Category>(Category.class));
        return categories;
    }
}

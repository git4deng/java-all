package com.david.redis.dao.impl;

import com.david.redis.dao.ProvinceDao;
import com.david.redis.domain.Province;
import com.david.redis.utils.JdbcUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @author david
 * @create 2019-06-13 14:48
 */
public class ProvinceDaoImpl implements ProvinceDao {

    private JdbcTemplate template=new JdbcTemplate(JdbcUtils.getDataSource());

    @Override
    public List<Province> getAllProvince() {
        String sql="select * from province ";
        try {
            List<Province> provinces = template.query(sql, new BeanPropertyRowMapper<Province>(Province.class));
            return provinces;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
}

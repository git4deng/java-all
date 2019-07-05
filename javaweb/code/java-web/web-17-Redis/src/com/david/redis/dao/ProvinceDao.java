package com.david.redis.dao;

import com.david.redis.domain.Province;

import java.util.List;

/**
 * @author david
 * @create 2019-06-13 14:46
 */
public interface ProvinceDao {
    //获取所有的省份
    public List<Province> getAllProvince();
}

package com.david.redis.service;

import com.david.redis.domain.Province;

import java.util.List;

/**
 * @author david
 * @create 2019-06-13 14:49
 */
public interface ProvinceService {
    public List<Province> getAllProvinces();
    //获取所有省份的json字符串
    public String getAllProvinceJsonString();
}

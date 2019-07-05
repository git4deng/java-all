package com.david.redis.service.impl;

import com.david.redis.dao.ProvinceDao;
import com.david.redis.dao.impl.ProvinceDaoImpl;
import com.david.redis.domain.Province;
import com.david.redis.service.ProvinceService;
import com.david.redis.utils.JedisPoolUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * @author david
 * @create 2019-06-13 14:50
 */
public class ProvinceServiceImpl implements ProvinceService {
    private ProvinceDao provinceDao=new ProvinceDaoImpl();
    @Override
    public List<Province> getAllProvinces() {
        return provinceDao.getAllProvince();
    }

    @Override
    public String getAllProvinceJsonString(){
        //先从redis数据库中查询是否存在
        Jedis jedis = JedisPoolUtils.getJedis();
        String province = jedis.get("province");
        if (province!=null&& !"".equals(province)){
            //缓存中存在
            jedis.close();
            return province;
        }else {
            //缓存中不存在
            System.out.println("redis 缓存中不存在对应数据，查询数据库！");
            //查询关系型数据库
            List<Province> provinces = provinceDao.getAllProvince();
            if (provinces!=null && provinces.size()>0){
                try {
                    ObjectMapper mapper=new ObjectMapper();
                    String provice_json = mapper.writeValueAsString(provinces);
                    //存入缓存
                    jedis.set("province",provice_json);
                    //返回json字符串
                    jedis.close();
                    return provice_json;
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}

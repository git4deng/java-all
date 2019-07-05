package cn.itcast.travel.service.category.impl;

import cn.itcast.travel.dao.category.CategoryDao;
import cn.itcast.travel.dao.category.impl.CategoryDaoImpl;
import cn.itcast.travel.domain.Category;
import cn.itcast.travel.service.category.CategoryService;
import cn.itcast.travel.util.JedisUtil;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author david
 * @create 2019-06-15 13:07
 */
public class CategoryServiceImpl implements CategoryService{
    private CategoryDao categoryDao=new CategoryDaoImpl();
    /**
     * 查询所有的路线
     * @return
     */
    @Override
    public List<Category> findAll() {
        List<Category> ctgs=new ArrayList<>();
        //此处增加缓存优化
        Jedis jedis=JedisUtil.getJedis();
        //先去缓存查询，如果存在即返回数据，如果不存在再去数据库查询
        Set<Tuple> categories = jedis.zrangeWithScores("categories", 0, -1);
        if(categories!=null&& categories.size()>0){
            //缓存中存在对应数据
            System.out.println("从缓存中获取数据......");
            for (Tuple tuple : categories) {
                Category c=new Category();
                c.setCid((int) tuple.getScore());
                c.setCname(tuple.getElement());
                ctgs.add(c);
            }
        }else{
            //数据库中获取
            System.out.println("数据库中获取......");
            ctgs= categoryDao.findAll();
            //将数据存入缓存
            for (Category ctg : ctgs) {
                jedis.zadd("categories",ctg.getCid(),ctg.getCname());
            }
        }
        return ctgs;
    }
}

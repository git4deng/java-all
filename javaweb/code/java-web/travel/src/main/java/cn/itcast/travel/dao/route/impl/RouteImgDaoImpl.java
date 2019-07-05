package cn.itcast.travel.dao.route.impl;

import cn.itcast.travel.dao.route.RouteImgDao;
import cn.itcast.travel.domain.RouteImg;
import cn.itcast.travel.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @author david
 * @create 2019-06-16 22:01
 */
public class RouteImgDaoImpl implements RouteImgDao{
    private JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());
    /**
     * 通过路线id,获取路线图片列表
     * @return
     */
    @Override
    public List<RouteImg> getRouteImgsByRid(int rid) {
        String sql="select * from tab_route_img where rid= ?";
        List<RouteImg> routeImgs = template.query(sql, new BeanPropertyRowMapper<RouteImg>(RouteImg.class), rid);
        return routeImgs;
    }
}

package cn.itcast.travel.dao.route;

import cn.itcast.travel.domain.RouteImg;

import java.util.List;

/**
 * @author david
 * @create 2019-06-16 22:00
 */
public interface RouteImgDao {
    /**
     * 通过路线id,获取路线图片列表
     * @return
     */
    public List<RouteImg> getRouteImgsByRid(int rid);
}

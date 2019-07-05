package cn.itcast.travel.dao.route;

import cn.itcast.travel.domain.Route;

import java.util.List;

/**
 * @author david
 * @create 2019-06-15 16:31
 */
public interface RouteDao {
    /**
     * 根据cid查询总数
     * @param cid
     * @param rname
     * @return
     */
   public int getTotalCount(int cid, String rname);

    /**
     * 查询分页数据
     * @param start
     * @param pageSize
     * @param cid
     * @param rname
     * @return
     */
   public List<Route> getRoutesByPage(int start, int pageSize, int cid, String rname);

    /**
     * 通过id查询路线信息
     * @param integer
     * @return
     */
   public  Route findById(Integer integer);
}

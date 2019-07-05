package cn.itcast.travel.service.route;

import cn.itcast.travel.domain.Favorite;
import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.domain.Route;

/**路线信息service
 * @author david
 * @create 2019-06-15 16:28
 */
public interface RouteService {
    /**
     * 路线
     * @param cid
     * @param currentPage
     * @param pageSize
     * @param rname
     * @return
     */
    public PageBean<Route> pageQuery(int cid, int currentPage, int pageSize, String rname);

    /**
     * 根据路线id查询路线详情
     * @param rid
     * @return
     */
    public Route findRouteByRid(String rid);

    /**
     * 通过路线id和用户id查询收藏数据
     * @param uid
     * @param integer
     * @return
     */
    public Favorite findFavoriteByRidAndUid(int uid, Integer integer);

    /**
     * 添加用户收藏记录
     * @param rid
     * @param uid
     */
    public int addFavorite(Integer rid,int uid);
}

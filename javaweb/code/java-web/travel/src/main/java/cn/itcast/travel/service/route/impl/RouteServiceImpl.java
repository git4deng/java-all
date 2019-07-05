package cn.itcast.travel.service.route.impl;

import cn.itcast.travel.dao.favorite.FavoriteDao;
import cn.itcast.travel.dao.favorite.impl.FavoriteDaoImpl;
import cn.itcast.travel.dao.route.RouteDao;
import cn.itcast.travel.dao.route.RouteImgDao;
import cn.itcast.travel.dao.route.impl.RouteDaoImpl;
import cn.itcast.travel.dao.route.impl.RouteImgDaoImpl;
import cn.itcast.travel.dao.seller.SellerDao;
import cn.itcast.travel.dao.seller.impl.SellerDaoImpl;
import cn.itcast.travel.domain.*;
import cn.itcast.travel.service.route.RouteService;

import java.util.List;

/**
 * @author david
 * @create 2019-06-15 16:28
 */
public class RouteServiceImpl implements RouteService {
    private RouteDao routeDao=new RouteDaoImpl();
    private SellerDao sellerDao=new SellerDaoImpl();
    private RouteImgDao routeImgDao=new RouteImgDaoImpl();
    private FavoriteDao favoriteDao=new FavoriteDaoImpl();

    /**
     * 分页查询路线信息列表
     * @param cid
     * @param currentPage
     * @param pageSize
     * @param rname
     * @return
     */
    @Override
    public PageBean<Route> pageQuery(int cid, int currentPage, int pageSize, String rname) {
        PageBean<Route> pb=new PageBean<>();
        pb.setCurrentPage(currentPage);
        pb.setPageSize(pageSize);
        int totalCount = routeDao.getTotalCount(cid,rname);
        pb.setTotalCount(totalCount);
        int start=(currentPage-1)*pageSize;
        List<Route> list = routeDao.getRoutesByPage(start, pageSize, cid,rname);
        pb.setList(list);
        int totalPage=totalCount%pageSize==0?totalCount/pageSize:totalCount/pageSize+1;
        pb.setTotalPage(totalPage);
        return pb;
    }

    /**
     * 根据路线id查询路线详情
     * @param rid
     * @return
     */
    @Override
    public Route findRouteByRid(String rid) {
        Route route=routeDao.findById(Integer.valueOf(rid));
        if (route==null) return null;
        int sid = route.getSid();
        Seller seller = sellerDao.findSellerById(sid);
        route.setSeller(seller);
        List<RouteImg> imgs = routeImgDao.getRouteImgsByRid(route.getRid());
        route.setRouteImgList(imgs);
        int n=favoriteDao.findFavoriteCountByRid(rid);
        route.setCount(n);
        return route;
    }

    @Override
    public Favorite findFavoriteByRidAndUid(int uid, Integer rid) {
        return favoriteDao.findFavoriteByRidAndUid(uid,rid);
    }

    @Override
    public int  addFavorite(Integer rid, int uid) {
        return  favoriteDao.addFavorite(rid,uid);
    }
}

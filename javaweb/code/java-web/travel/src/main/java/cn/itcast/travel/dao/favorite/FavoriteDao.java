package cn.itcast.travel.dao.favorite;

import cn.itcast.travel.domain.Favorite;

/**
 * @author david
 * @create 2019-06-16 23:23
 */
public interface FavoriteDao {
    /**
     * 通过用户id和路线id查询收藏信息
     * @param uid
     * @param integer
     * @return
     */
    public Favorite findFavoriteByRidAndUid(int uid, Integer integer);

    /**
     * 查询收藏次数
     * @param rid
     * @return
     */
    public  int findFavoriteCountByRid(String rid);

    public int addFavorite(Integer rid, int uid);
}

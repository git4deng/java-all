package cn.itcast.travel.dao.favorite.impl;

import cn.itcast.travel.dao.favorite.FavoriteDao;
import cn.itcast.travel.domain.Favorite;
import cn.itcast.travel.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Date;

/**
 * @author david
 * @create 2019-06-16 23:25
 */
public class FavoriteDaoImpl implements FavoriteDao {
    private JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public Favorite findFavoriteByRidAndUid(int uid, Integer rid) {
        try {
            String sql="select * from tab_favorite where rid=? and uid=?";
            Favorite favorite = template.queryForObject(sql, new BeanPropertyRowMapper<Favorite>(Favorite.class), rid, uid);
            return favorite;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int findFavoriteCountByRid(String rid) {
        try {
            String sql="select count(*) from tab_favorite where rid=?";
            Integer n = template.queryForObject(sql, Integer.class, rid);
            return n;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int addFavorite(Integer rid, int uid) {
        String sql=" insert into tab_favorite VALUES (?,?,?)";
        int i = template.update(sql, rid, new Date(), uid);
        return i;
    }
}

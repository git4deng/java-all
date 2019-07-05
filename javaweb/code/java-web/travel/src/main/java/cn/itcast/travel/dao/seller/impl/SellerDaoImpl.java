package cn.itcast.travel.dao.seller.impl;

import cn.itcast.travel.dao.seller.SellerDao;
import cn.itcast.travel.domain.Seller;
import cn.itcast.travel.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author david
 * @create 2019-06-16 21:56
 */
public class SellerDaoImpl implements SellerDao{
    private JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());
    /**
     * 通过id查询卖家信息
     * @param sid
     * @return
     */
    @Override
    public Seller findSellerById(int sid) {
        try {
            String sql="select * from tab_seller where sid=?";
            Seller seller = template.queryForObject(sql, new BeanPropertyRowMapper<Seller>(Seller.class), sid);
            return seller;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
}

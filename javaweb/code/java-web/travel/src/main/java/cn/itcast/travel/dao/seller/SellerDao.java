package cn.itcast.travel.dao.seller;

import cn.itcast.travel.domain.Seller;

/**
 * 卖家信息DAO
 * @author david
 * @create 2019-06-16 21:54
 */
public interface SellerDao {
    /**
     * 通过id查询卖家信息
     * @param sid
     * @return
     */
    public Seller findSellerById(int sid);
}

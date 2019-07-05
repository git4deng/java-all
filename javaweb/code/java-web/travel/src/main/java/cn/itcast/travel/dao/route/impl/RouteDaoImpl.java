package cn.itcast.travel.dao.route.impl;

import cn.itcast.travel.dao.route.RouteDao;
import cn.itcast.travel.domain.Route;
import cn.itcast.travel.util.JDBCUtils;
import com.sun.tools.javac.util.RichDiagnosticFormatter;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * @author david
 * @create 2019-06-15 16:31
 */
public class RouteDaoImpl implements RouteDao {
    private JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());
    /**
     * 根据cid查询总数
     * @param cid
     * @param rname
     * @return
     */
    @Override
    public int getTotalCount(int cid, String rname) {
        String sql="select count(*) from tab_route where 1=1 ";
        StringBuilder sb=new StringBuilder(sql);
        List<Object> params=new ArrayList<>();
        if(cid!=0){
            sb.append(" and cid= ? ");
            params.add(cid);
        }
        if(rname!=null&& !"".equals(rname)){
            sb.append(" and rname like ?");
            params.add("%"+rname+"%");
        }
        Integer integer = template.queryForObject(sb.toString(), Integer.class, params.toArray());
        return integer;
    }

    /**
     * 查询分页数据
     * @param start
     * @param pageSize
     * @param cid
     * @param rname
     * @return
     */
    @Override
    public List<Route> getRoutesByPage(int start, int pageSize, int cid, String rname) {
        String sql="select * from tab_route where 1=1 ";
        StringBuilder sb=new StringBuilder(sql);
        List<Object> params=new ArrayList<>();
        if(cid!=0){
            sb.append(" and cid=? ");
            params.add(cid);
        }
        if(rname!=null&& !"".equals(rname)){
            sb.append(" and rname like ?");
            params.add("%"+rname+"%");
        }
        sb.append(" limit ?, ?");
        params.add(start);
        params.add(pageSize);
        List<Route> routes = template.query(sb.toString(), new BeanPropertyRowMapper<Route>(Route.class),params.toArray());
        return routes;
    }

    @Override
    public Route findById(Integer rid) {
        try {
            String sql="select * from tab_route where rid=? ";
            Route route = template.queryForObject(sql, new BeanPropertyRowMapper<Route>(Route.class), rid);
            return route;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
}

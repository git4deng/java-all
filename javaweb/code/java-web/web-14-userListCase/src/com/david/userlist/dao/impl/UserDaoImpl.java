package com.david.userlist.dao.impl;

import com.david.userlist.dao.UserDao;
import com.david.userlist.domain.User;
import com.david.userlist.utils.JdbcUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author david
 * @create 2019-06-03 22:03
 */
public class UserDaoImpl implements UserDao{
    private JdbcTemplate template=new JdbcTemplate(JdbcUtils.getDataSource());

    @Override
    public User loginByUsernameAndPssword(String username, String password) {
        try {
            String sql="select * from user where username=? and password=? ";
            User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username, password);
            return user;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<User> findAllUser() {
        String sql="select * from user ";
        List<User> userList = template.query(sql, new BeanPropertyRowMapper<User>(User.class));
        return userList;
    }

    @Override
    public void addUser(User user) {
        String sql="insert into user values(null,?,?,?,?,?,?,null,null)";
        template.update(sql, user.getName(), user.getGender(), user.getAge(), user.getAddress(), user.getQq(), user.getEmail());
    }

    @Override
    public void deleteUserById(int id) {
        String sql="delete from user where id=? ";
        int n = template.update(sql, id);
    }

    @Override
    public User findUserById(int id) {
        String sql="select * from user where id=? ";
        try {
            User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), id);
            return user;
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void updateUser(User user) {
        String sql = "update user set name = ?,gender = ? ,age = ? , address = ? , qq = ?, email = ? where id = ?";
        template.update(sql, user.getName(), user.getGender(), user.getAge(), user.getAddress(), user.getQq(), user.getEmail(), user.getId());
    }

    @Override
    public int findTotalCount(Map<String, String[]> condition) {
//        String sql="select count(*) from user where 1=1 ";
//        StringBuilder sb=new StringBuilder(sql);
//        List<Object> param =new ArrayList<Object>();
//
//        Set<String> keySet = condition.keySet();
//        for (String s : keySet) {
//            if("currentPage".equals(s)|| "rows".equals(s)){
//                //排除分页参数
//                continue;
//            }
//            String v = condition.get(s)[0];
//            if(v!=null && !"".equals(v)){
//                sb.append(" and "+s+" like ? ");
//                param.add(" %"+v+"% ");
//            }
//        }
//        sql=sb.toString();//注意不要忘了这一步
//        System.out.println(sb);
//        System.out.println(param);
//        Integer total = template.queryForObject(sql, Integer.class,param.toArray());
//        return total;
        //1.定义模板初始化sql
        String sql = "select count(*) from user where 1 = 1 ";
        StringBuilder sb = new StringBuilder(sql);
        //2.遍历map
        Set<String> keySet = condition.keySet();
        //定义参数的集合
        List<Object> params = new ArrayList<Object>();
        for (String key : keySet) {

            //排除分页条件参数
            if("currentPage".equals(key) || "rows".equals(key)){
                continue;
            }

            //获取value
            String value = condition.get(key)[0];
            //判断value是否有值
            if(value != null && !"".equals(value)){
                //有值
                sb.append(" and "+key+" like ? ");
                params.add("%"+value+"%");//？条件的值
            }
        }
        System.out.println(sb.toString());
        System.out.println(params);

        return template.queryForObject(sb.toString(),Integer.class,params.toArray());
    }

    @Override
    public List<User> findUserListByPage(int start, int rows, Map<String, String[]> condition) {
        String sql="select * from user where 1=1 ";
        StringBuilder sb=new StringBuilder(sql);
        List<Object> param =new ArrayList<Object>();

        Set<String> keySet = condition.keySet();
        for (String s : keySet) {
            if("currentPage".equals(s)|| "rows".equals(s)){
                //排除分页参数
                continue;
            }
            String v = condition.get(s)[0];
            if(v!=null && !"".equals(v)){
                sb.append(" and "+s+" like ?");
                param.add("%"+v+"%");
            }
        }
        sb.append(" limit ?,? ");
        param.add(start);
        param.add(rows);
        sql=sb.toString();
        System.out.println(sb);
        System.out.println(param);
        List<User> userList= template.query(sql, new BeanPropertyRowMapper<User>(User.class),param.toArray());
        return userList;
    }
}

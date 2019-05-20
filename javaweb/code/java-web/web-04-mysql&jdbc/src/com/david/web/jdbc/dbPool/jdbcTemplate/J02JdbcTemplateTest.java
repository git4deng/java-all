package com.david.web.jdbc.dbPool.jdbcTemplate;

import com.david.web.jdbc.dbPool.Druid.JDBCUtils;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author david
 * @create 2019-05-13 22:33
 */
public class J02JdbcTemplateTest {
    private JdbcTemplate jt;
    @Before
    public  void init(){
        jt=new JdbcTemplate(JDBCUtils.getDataSourece());
    }

    /**
     * 测试修改update
     */
    @Test
    public void testUpdate(){
        String sql="update emp set salary=10000 where id= ?";
        int n = jt.update(sql, 1001);
        System.out.println(n);
    }
    /**
     * 测试插入
     */
    @Test
    public void testInsert(){
        String sql="insert into emp (id,ename,dept_id) values(?,?,?)";
        int n = jt.update(sql, 1015,"李元芳",10);
        System.out.println(n);
    }
    /**
     * 测试删除
     */
    @Test
    public void testDelete(){
        String sql="delete from emp where id=?";
        int n = jt.update(sql, 1015);
        System.out.println(n);
    }

    /**
     * 通过id查询数据，结果封装成map
     * 注意：queryForMap方法的结果只能是一条数据
     */
    @Test
    public void testQueryById(){
        String sql="SELECT * from emp where id=?";
        Map<String, Object> rs = jt.queryForMap(sql, 1001);
        System.out.println(rs);
        Set<String> keys = rs.keySet();
        for (String key : keys) {
            System.out.println(key+"="+rs.get(key));
        }
    }

    /**
     * QueryForList方法
     */
    @Test
    public void testQueryForList(){
        String sql="SELECT * from emp";
        //将每条记录封装成一个map,然后保存在list集合中
        List<Map<String, Object>> maps = jt.queryForList(sql);
        maps.stream().forEach(System.out::println);
    }
    /**
     * Query方法,将结果封装成JavaBean
     */
    @Test
    public void testQueryForListObject(){
        String sql="SELECT * from emp";
        List<Employee> emps = jt.query(sql, new RowMapper<Employee>() {

            @Override
            public Employee mapRow(ResultSet rs, int i) throws SQLException {
                Employee emp = new Employee();
                emp.setId(rs.getInt("id"));
                emp.setEname(rs.getString("ename"));
                emp.setDept_id(rs.getInt("job_id"));
                emp.setMgr(rs.getInt("mgr"));
                emp.setJoindate(rs.getDate("joindate"));
                emp.setSalary(rs.getDouble("salary"));
                emp.setBonus(rs.getDouble("bonus"));
                emp.setDept_id(rs.getInt("dept_id"));
                return emp;
            }
        });

        emps.stream().forEach(System.out::println);
    }
    /**
     * Query方法,将结果封装成JavaBean,使用lambda表达式
     */
    @Test
    public void testQueryForListObjectLambda(){
        String sql="SELECT * from emp";
        List<Employee> emps = jt.query(sql, (ResultSet rs, int i) -> {
            Employee emp = new Employee();
            emp.setId(rs.getInt("id"));
            emp.setEname(rs.getString("ename"));
            emp.setDept_id(rs.getInt("job_id"));
            emp.setMgr(rs.getInt("mgr"));
            emp.setJoindate(rs.getDate("joindate"));
            emp.setSalary(rs.getDouble("salary"));
            emp.setBonus(rs.getDouble("bonus"));
            emp.setDept_id(rs.getInt("dept_id"));
            return emp;
        });

        emps.stream().forEach(System.out::println);
    }
    @Test
    public void testQueryForListObjectWithBeanRowMapper(){
        String sql="SELECT * from emp";
        List<Employee> emps = jt.query(sql, new BeanPropertyRowMapper<>(Employee.class));
        emps.stream().forEach(System.out::println);
    }
    @Test
    public void testCount(){
        String sql="select count(*) from emp ";
        Long count = jt.queryForObject(sql, Long.class);
        System.out.println(count);
    }












}

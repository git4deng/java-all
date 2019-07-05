package com.david.mybatis.test;

import com.david.dao.AccountDao;
import com.david.dao.RoleDao;
import com.david.dao.UserDao;
import com.david.domain.*;
import com.david.domain.QueryVo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * @author david
 * @create 2019-06-18 21:07
 */
public class MybataisTest {
    private InputStream is=null;
    private SqlSession sqlSession=null;
    private UserDao userDao=null;
    private AccountDao accountDao=null;
    private RoleDao roleDao=null;
    private SqlSessionFactory factory=null;
    @Before
    public void init() throws IOException {
        is = Resources.getResourceAsStream("sqlMapConfig.xml");
        factory = new SqlSessionFactoryBuilder().build(is);
        sqlSession = factory.openSession(true);//开启事务
        userDao=sqlSession.getMapper(UserDao.class);
        accountDao=sqlSession.getMapper(AccountDao.class);
        roleDao=sqlSession.getMapper(RoleDao.class);
    }
    @After
    public void destroy(){

        sqlSession.close();
        if(is!=null) {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 测试查询所有
     */
    @Test
    public void findAllTest(){
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

    /**
     * 测试插入一个user
     */
    @Test
    public void saveUserTest(){
        User user=new User();
        user.setUsername("david");
        user.setSex("男");
        user.setBirthday(new Date());
        user.setAddress("成都双流");
        System.out.println("保存之前的数据：");
        System.out.println(user);//User{id=null, username='david', birthday=Tue Jun 18 22:30:49 CST 2019, sex='男', address='成都双流'}
        userDao.saveUser(user);
        System.out.println("保存之后的数据：");//User{id=50, username='david', birthday=Tue Jun 18 22:30:49 CST 2019, sex='男', address='成都双流'}
        System.out.println(user);
    }

    /**
     * 更新操作测试
     */
    @Test
    public void updateUserTest(){
        User user=new User();
        user.setId(49);
        user.setUsername("David");
        user.setSex("男");
        user.setBirthday(new Date());
        user.setAddress("成都双流东升");
        userDao.updateUser(user);
    }

    /**
     * 删除测试
     */
    @Test
    public void deleteUserTest(){
        userDao.deleteUser(49);
    }
    /**
     * 通过id查询用户
    */
    @Test
    public void findUserByIdTest(){
        User user = userDao.findUserById(48);
        System.out.println(user);
    }

    /**
     * 模糊查询
     */
    @Test
    public void findUsersByNameTest(){
        List<User> users = userDao.findUsersByName("%王%");//注意模糊查询%是在此处拼接进去的
        for (User user : users) {
            System.out.println(user);
        }
    }/**
     * 模糊查询
     */
    @Test
    public void findTotalTest(){
        int total = userDao.findTotal();
        System.out.println(total);
    }

    /**
     * 使用实体对象的包装对象作为查询条件，这样可以封装多个实体对象进行入参查询
     */
    @Test
    public void findUsersByVoTest(){
        QueryVo vo=new QueryVo();
        User user=new User();
        user.setUsername("%王%");
        vo.setUser(user);
        List<User> users= userDao.findUsersByVo(vo);

        for (User u : users) {
            System.out.println(u);
        }
    }

    /**
     * 动态sql查询，if where 标签的使用
     */
    @Test
    public void findUserByConditionTest(){
        User user=new User();
        user.setUsername("老王");
        List<User> users = userDao.findUserByCondition(user);
        for (User u : users) {
            System.out.println(u);
        }
    }
    /**
     * 动态sql查询，foreach 标签的使用
     */
    @Test
    public void findUserByIdsTest(){
        QueryVo vo=new QueryVo();
        List<Integer> ids=new ArrayList<Integer>();
        ids.add(41);
        ids.add(46);
        ids.add(48);
        vo.setIds(ids);

        List<User> userList = userDao.findUserByIds(vo);
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void findAllCountTest(){
        List<Account> accounts = accountDao.findAllCount();
        for (Account account : accounts) {
            System.out.println(account);
        }
    }

    /**
     * 1对1，采用继承的方式实现（组合）
     */
    @Test
    public void findAccountAndUserTest(){
        List<AccountUser> aus = accountDao.findAccountAndUser();
        for (AccountUser au : aus) {
            System.out.println(au);
        }
    }

     /**
     * 1对1，采用mybatis配置的方式实现
     */
    @Test
    public void findAccountAndUserMybatisTest(){
        List<Account> aus = accountDao.findAccountAndUserMybatis();
        for (Account au : aus) {
            System.out.println(au);
        }
    }
    /**
     * 1对1，采用mybatis配置的延迟加载方式实现
     */
    @Test
    public void findAccountAndUserLazyTest(){
        List<Account> aus = accountDao.findAccountAndUserLazy();
        for (Account au : aus) {
            System.out.println(au);
        }
    }

    @Test
    public void findAllUsersAndAccountTest(){
        List<User> users = userDao.findAllUsersAndAccount();
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void findAllRoles(){
        List<Role> roles = roleDao.findAll();
        for (Role role : roles) {
            System.out.println(role);
        }

    }

    /**
     * 角色到用户的many2many
     */
    @Test
    public  void findRolesAndUsers(){
        List<Role> roles = roleDao.findRolesAndUsers();
        for (Role role : roles) {
            System.out.println(role);
        }
    }
    /**
     * 角色到用户的many2many
     */
    @Test
    public  void findRolesAndUsersLazy(){
        List<Role> roles = roleDao.findRolesAndUsersLazy();
        for (Role role : roles) {
            System.out.println(role);
        }
    }

    /**
     * 用户到角色的多对多关系查询
     */
    @Test
    public void findAllUsersAndRolesTest(){
        List<User> users = userDao.findAllUsersAndRoles();
        for (User user : users) {
            System.out.println(user);
        }
    }

    /**
     *一级缓存测试
     */
    @Test
    public void firstLevelCacheTest(){
        //因sqlSession的缓存存在，查询的时候会先去查询session的缓存，如果不存在再去数据库查询，因此下面2次查询仅仅发送一次sql
        User user = userDao.findUserById(41);
        //直接调用清楚session缓存，第二次查询将重新从数据库里面查询
        //sqlSession.clearCache();
        User user1 = userDao.findUserById(41);
        System.out.println(user);
        System.out.println(user1);
        System.out.println(user1==user);//true;
        //关闭该session
        sqlSession.close();

        SqlSession sqlSession = factory.openSession();//新获取的session对象和关闭的对象不是同一个
        UserDao userDao1 = sqlSession.getMapper(UserDao.class);
        User user2 = userDao1.findUserById(41);
        System.out.println(user2==user1);//false

        /*
        一级缓存是 SqlSession 范围的缓存，当调用 SqlSession 的修改，添加，删除，commit()，close()等方法时，就会清空一级缓存。
         */

        User user3 = userDao1.findUserById(42);
        System.out.println(user3);
        user3.setUsername("david");
        userDao1.updateUser(user3);
        //下面查询将会重新发送查询请求的sql
        User user4 = userDao1.findUserById(42);

        System.out.println(user4);
        System.out.println(user3==user4);//false
    }
    @Test
    public void SecendLevelCacheTest(){
        SqlSession sqlSession1 = factory.openSession();
        UserDao userDao1 = sqlSession1.getMapper(UserDao.class);
        List<User> all1 = userDao1.findAll();
        sqlSession1.close();
        SqlSession sqlSession2 = factory.openSession();
        UserDao userDao2 = sqlSession2.getMapper(UserDao.class);
        List<User> all2 = userDao2.findAll();
        sqlSession2.close();
        //两次查询仅仅发送一次sql查询语句
    }
}

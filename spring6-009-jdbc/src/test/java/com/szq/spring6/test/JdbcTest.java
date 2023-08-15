package com.szq.spring6.test;

import com.szq.spring6.bean.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JdbcTest {
    @Test
    public void testJdbc() {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring6.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);
        System.out.println(jdbcTemplate);
    }

    @Test
    public void testInsert() {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring6.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);
        String sql="insert into t_user(real_name,age) values(?,?)";
        //注意在jdbcTemplate当中，只要是insert，delete，update语句，都是调用update方法
        int count = jdbcTemplate.update(sql, "王五", 20);
        System.out.println(count);
    }

    @Test
    public void testUpdate() {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring6.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);
        String sql="update t_user set real_name=?,age=? where id=?";
        int count = jdbcTemplate.update(sql, "张师傅", 55, 1);
        System.out.println(count);
    }

    @Test
    public void testSelectOne(){
        // 获取JdbcTemplate对象
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring6.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);
        // 执行select
        String sql = "select id, real_name, age from t_user where id = ?";
        User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), 2);
        System.out.println(user);
    }

    @Test
    public void testSelectAll(){
        // 获取JdbcTemplate对象
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring6.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);
        // 执行select
        String sql = "select id, real_name, age from t_user";
        List<User> users = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
        System.out.println(users);
    }

    @Test
    public void testSelectOneValue(){
        // 获取JdbcTemplate对象
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring6.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);
        // 执行select
        String sql = "select count(1) from t_user";
        Integer count = jdbcTemplate.queryForObject(sql, int.class); // 这里用Integer.class也可以
        System.out.println("总记录条数：" + count);
    }

    @Test
    public void testAddBatch(){
        // 获取JdbcTemplate对象
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring6.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);
        // 批量添加
        String sql = "insert into t_user(id,real_name,age) values(?,?,?)";

        Object[] objs1 = {null, "小花", 20};
        Object[] objs2 = {null, "小明", 21};
        Object[] objs3 = {null, "小刚", 22};
        List<Object[]> list = new ArrayList<>();
        list.add(objs1);
        list.add(objs2);
        list.add(objs3);

        int[] count = jdbcTemplate.batchUpdate(sql, list);
        System.out.println(Arrays.toString(count));
    }

    @Test
    public void testUpdateBatch(){
        // 获取JdbcTemplate对象
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring6.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);
        // 批量修改
        String sql = "update t_user set real_name = ?, age = ? where id = ?";
        Object[] objs1 = {"小花11", 10, 2};
        Object[] objs2 = {"小明22", 12, 3};
        Object[] objs3 = {"小刚33", 9, 4};
        List<Object[]> list = new ArrayList<>();
        list.add(objs1);
        list.add(objs2);
        list.add(objs3);

        int[] count = jdbcTemplate.batchUpdate(sql, list);
        System.out.println(Arrays.toString(count));
    }

    @Test
    public void testDeleteBatch(){
        // 获取JdbcTemplate对象
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring6.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);
        // 批量删除
        String sql = "delete from t_user where id = ?";
        Object[] objs1 = {2};
        Object[] objs2 = {3};
        Object[] objs3 = {4};
        List<Object[]> list = new ArrayList<>();
        list.add(objs1);
        list.add(objs2);
        list.add(objs3);
        int[] count = jdbcTemplate.batchUpdate(sql, list);
        System.out.println(Arrays.toString(count));
    }

    @Test
    public void testCallback(){
        // 获取JdbcTemplate对象
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring6.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);
        String sql = "select id, real_name, age from t_user where id = ?";

        User user = jdbcTemplate.execute(sql, new PreparedStatementCallback<User>() {
            @Override
            public User doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
                User user = null;
                ps.setInt(1, 5);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    user = new User();
                    user.setId(rs.getInt("id"));
                    user.setRealName(rs.getString("real_name"));
                    user.setAge(rs.getInt("age"));
                }
                return user;
            }
        });
        System.out.println(user);
    }

    @Test
    public void name() {
    }
}

package cn.szq.dao.impl;

import cn.szq.dao.StudentDao;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDaoImpl implements StudentDao {
    @Override
    public void deleteById() {
        System.out.println("mysql数据库正在删除学生信息");
    }
}

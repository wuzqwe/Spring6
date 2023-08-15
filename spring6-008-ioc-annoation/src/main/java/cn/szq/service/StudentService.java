package cn.szq.service;

import cn.szq.dao.StudentDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.annotation.Resources;

@Service
public class StudentService {

    @Resource
    private StudentDao studentDao;

    public void deleteByStudent(){
        studentDao.deleteById();
    }
}

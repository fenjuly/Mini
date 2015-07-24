package org.elite.mini.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.elite.mini.bean.Student;
import org.elite.mini.common.QueryBase;
import org.elite.mini.common.Status;
import org.elite.mini.mapper.StudentMapper;
import org.elite.mini.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by fenjuly
 * Date: 15/7/23
 * Time: 上午9:30
 */
@Service
public class StudentServiceImpl implements StudentService {

    private Log logger = LogFactory.getLog(StudentServiceImpl.class);

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public int add(Student student) {
        if (studentMapper.insert(student) > 0) {
            logger.debug("添加大学生: " + student.getName() + "成功");
            return Status.SUCCESS;
        }
        return Status.ERROR;
    }

    @Override
    public int update(Student student) {
        Student s = studentMapper.selectByPrimaryKey(student.getId());
        if (s == null) {
            logger.warn("尝试更新大学生，但是大学生不存在");
            return Status.NOT_EXISTS;
        }
        studentMapper.updateByPrimaryKeySelective(student);
        logger.debug("修改大学生：" + student.getName() + " Id: " + student.getId() + "成功");
        return Status.SUCCESS;
    }

    @Override
    public int delete(Student student) {
        Student s = studentMapper.selectByPrimaryKey(student.getId());
        if (s == null) {
            logger.warn("尝试删除大学生，但是大学生不存在");
            return Status.NOT_EXISTS;
        }
        studentMapper.deleteByPrimaryKey(student.getId());
        logger.debug("删除大学生：" + student.getName() + " Id: " + student.getId() + "成功");
        return Status.SUCCESS;
    }

    @Override
    public Student get(int id) {
        Student student = studentMapper.selectByPrimaryKey(id);
        if (student == null) {
            logger.warn("大学生 ID:" + id + " 不存在");
        } else {
            logger.debug("大学生 ID:" + id + " 成功");
        }
        return student;
    }

    @Override
    public void query(QueryBase queryBase) {

    }
}

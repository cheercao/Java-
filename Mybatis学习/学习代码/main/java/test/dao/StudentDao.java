package test.dao;

import test.pojo.student;

import java.util.List;

// 这里的接口的方法不由具体的实体类来实现而是由xml配置文件来实现
public interface StudentDao {
    //查询全部学生
    List<student> getStudentList();
    //根据学生id查询学生
    student getStudentById(int id);
    //插入一个学生
    int InsertStudent(student stu);
    //修改学生信息
    int updateStudent(student stu);
    //删除学生
    int deleteStudent(int id);
}

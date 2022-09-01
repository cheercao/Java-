package test.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import test.pojo.student;

import java.util.List;
import java.util.Map;

// 这里的接口的方法不由具体的实体类来实现而是由xml配置文件来实现
public interface StudentMapper {
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
    //分页查询学生信息
    List<student> getStudentByPage(Map map);
    //使用注解进行简单SQL代码编写 ;
    @Select("select * from student where id = #{uid}")
    student getStudentById2(@Param("uid") int id);
    //多对一练习，多个学生对应一个老师
}

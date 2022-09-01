package test.dao;

import org.apache.ibatis.annotations.Param;
import test.pojo.Teacher;

import java.util.List;

public interface TeacherMapper {
    List<Teacher> getTeacher();
    List<Teacher> getTeacherList(@Param("tid") int id);
}

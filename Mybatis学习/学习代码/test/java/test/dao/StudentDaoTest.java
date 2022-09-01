package test.dao;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import test.pojo.StudentAndTeacher;
import test.pojo.Teacher;
import test.pojo.student;
import test.utils.MybatisUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentDaoTest {
    @Test
    public void test(){
        //测试查询所有学生
        //第一步：获得SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //方式一：getMapper 推荐使用
        // 通过mapper获得接口的实体类，然后就可以直接调用方法
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        List<student> studentList = studentMapper.getStudentList();
        //方式二 不推荐使用
       // List<student> studentList = sqlSession.selectList("test.dao.StudentDao.getStudentList");
        for (student student : studentList) {
            System.out.println(student);
        }
        sqlSession.close();
    }
    @Test
    public void testById(){
        //测试查询某一个id的学生
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        student studentById = studentMapper.getStudentById2(11);
        System.out.println(studentById);
        sqlSession.close();
    }
    //增删改需要提交事务
    @Test
    public void insertStudent(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        student student = new student(12,"曹","123456","男",String.valueOf(new java.sql.Date(new Date().getTime())),"湖南科技大学","269762@qq.com");
        int i = mapper.InsertStudent(student);
        if(i>0){
            System.out.println("插入成功");
        }
        //提交事务
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void updateStudent(){
        //具体业务具体分析
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        student student = new student();
        student.setId(12);
        student.setName("阿辉");
        student.setPassword("1527384");
        student.setSex("女");
        mapper.updateStudent(student);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void deleteStudent(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        mapper.deleteStudent(12);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void selectByPage(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("startpoint",0);
        map.put("page",2);
        List<student> studentByPage = mapper.getStudentByPage(map);
        for (student student : studentByPage) {
            System.out.println(student);
        }
        sqlSession.close();
    }
    @Test
    public void test1(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentAndTeacherMapper mapper = sqlSession.getMapper(StudentAndTeacherMapper.class);
        List<StudentAndTeacher> studentList = mapper.getStudentList();
        for (StudentAndTeacher studentAndTeacher : studentList) {
            System.out.println(studentAndTeacher);
        }
        sqlSession.close();
    }
    @Test
    public void test2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentAndTeacherMapper mapper = sqlSession.getMapper(StudentAndTeacherMapper.class);
        List<StudentAndTeacher> studentList = mapper.getStudentList1();
        for (StudentAndTeacher studentAndTeacher : studentList) {
            System.out.println(studentAndTeacher);
        }
        sqlSession.close();
    }
    @Test
    public void test3(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        List<Teacher> teachers = mapper.getTeacher();
        for (Teacher teacher : teachers) {
            System.out.println(teacher);
        }
        sqlSession.close();
    }
    @Test
    public void test4(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        List<Teacher> teachers = mapper.getTeacherList(1);
        for (Teacher teacher : teachers) {
            System.out.println(teacher);
        }
        sqlSession.close();
    }
}

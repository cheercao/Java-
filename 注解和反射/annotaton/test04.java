package src.annotaton;

import java.lang.annotation.*;
import java.lang.reflect.Field;

//反射操作注解
//反射与注解可以与数据库联系起来
public class test04 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {

        //注意是获得某一个类的class
        Class c1 = Class.forName("src.annotaton.Student");

        //通过反射获得该类的注解
        Annotation[] annotations = c1.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }

        //获取该类的注解的value值
        Table table = (Table) c1.getAnnotation(Table.class);
        String value = table.value();
        System.out.println(value);

        //获得该类的某一个属性的注解
        Field f = c1.getDeclaredField("name");
        TableField annotation = f.getAnnotation(TableField.class);
        System.out.println(annotation.columnName());
        System.out.println(annotation.length());
        System.out.println(annotation.type());
    }
}

@Table("student")
class Student{

    @TableField(columnName = "db_id",type = "int",length = 10)
    private int id;
    @TableField(columnName = "db_age",type = "int",length = 10)
    private int age;
    @TableField(columnName = "db_name",type = "String",length = 10)
    private String name;

    public Student() {

    }

    public Student(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

//类名的注解
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface Table{
    String value();
}

//属性的注解
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface TableField{
    String columnName();
    String type();
    int length();
}

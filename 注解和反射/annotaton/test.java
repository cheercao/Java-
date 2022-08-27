package src.annotaton;

import java.lang.annotation.*;

public class test {

    //注解可以显示赋值，如果没有默认值，我们就必须给参数赋值
    @MyAnnotation(name = "注解赋值",schools = {"湖南科技大学"})
    public void test1(){
    }
}

// @Target表示注解在哪些地方使用
// 表示这个注解只能用在方法上，不能用在类或其他地方
@Target(value = {ElementType.METHOD,ElementType.TYPE})

//Retention 表示我们的注解在什么地方还有效，下列表示在任何地方都有效
// runtime>class>sources
@Retention(value = RetentionPolicy.RUNTIME)

//表示是否将我们的注解生成在JAVAdoc中
@Documented

//Inherited 子类可以继承父类的注解
@Inherited
@interface MyAnnotation{
    // 注解的参数：参数类型 + 参数名(); 这里默认值为空
    String name() default "";
    int age() default 0;
    String[] schools(); //没有默认值则必须赋值否则报错
}

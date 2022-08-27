package src.annotaton;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//动态创建对象 通过反射
public class test03 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        //获得Class对象
        Class c1 = Class.forName("src.annotaton.User");

        //构造一个对象
        User user = (User) c1.newInstance(); //本质是调用了类的无参构造器
        System.out.println(user);

        //通过构造器对象创建对象
        Constructor constructor = c1.getDeclaredConstructor(String.class, int.class, int.class); //获取构造器
        User user2 = (User) constructor.newInstance("小曹", 001, 18);
        System.out.println(user2);

        //通过反射调用普通方法
        User user3 = (User) c1.newInstance();
        //通过反射获取一个方法
        Method setName = c1.getDeclaredMethod("setName", String.class);

        //invoke:激活的意思
        //（对象，"方法的值"）
        setName.invoke(user3,"大曹");
        System.out.println(user3.getName());

        //通过反射操作属性
        User user4 = (User) c1.newInstance();
        //因为属性是私有的，通过反射拿到的私有属性不能直接使用，如果直接使用会报错
        Field name = c1.getDeclaredField("name");
        //不能直接操作私有属性，我们需要关闭程序的安全检测，可以通过属性或方法的setAccessible方法来关闭
        name.setAccessible(true);
        name.set(user4,"属性");
        System.out.println(user4.getName());

    }
}

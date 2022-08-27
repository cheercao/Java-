package src.annotaton;

import java.lang.annotation.ElementType;

//所有类型的Class
public class test02 {
    public static void main(String[] args) {
        //对象的Class
        Class c1 = Object.class;
        //接口的Class
        Class c2 = Comparable.class;
        //数组的Class
        Class c3 = String[].class;
        //注解的Class
        Class c4 = Override.class;
        //枚举的Class
        Class c5 = ElementType.class;
        //Integer的Class
        Class c6 = Integer.class;
        //void的class
        Class c7 = void.class;
        //Class的class
        Class c8 = Class.class;

        //只要元素类型与维度一样，就是同一个Class，此时a和b是同一个Class
        int[] a = new int[10];
        int[] b = new int[100];
        System.out.println(a.getClass().hashCode());
        System.out.println(b.getClass().hashCode());
    }
}

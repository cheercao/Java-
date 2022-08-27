package src.annotaton;

//什么叫反射
public class test01 extends Object {
    public static void main(String[] args) throws ClassNotFoundException {
        //通过反射获取类的class对象 注意路径是包名加定义的类名
        //一个类在内存中只有一个Class对象
        //一个类被加载后类的整个结构都被封装在Class对象中

        User user = new User();

        //Class类的创建方式有哪些
        //方式一：通过对象获得Class
        Class c1 = user.getClass();

        //方式二：通过forName获得Class
        Class c2 = Class.forName("src.annotaton.User");

        //方式三：通过类名.class获得Class
        Class c3 = User.class;

        //方式四：基本内置类型的包装类都有一个Type属性
        Class c4 = Integer.class;
        System.out.println(c4);

        //获得父类类型，在此列中我没有定义父类
        Class c5 = c1.getSuperclass();
        System.out.println(c5);

        System.out.println(c1);


    }
}

class User{
    private String name;
    private int id;
    private int age;
    public User(){

    }

    //ALT+insert可以快速构造方法
    public User(String name, int id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
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

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", age=" + age +
                '}';
    }
}

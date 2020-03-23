package com.moqi.test;

import java.util.Scanner;

/**
 * @author moqi
 * @date 2020/3/23 19:51
 *
（6-3）设计猫类，要求如下：
（1）成员变量包括种类、颜色、年龄和体重；
（2）定义空构造方法，能够初始化所有成员的构造方法；
（3）定义所有setter和getter方法；
（4）功能方法包括输出猫的详细信息printCat()、猫发出叫声yelling()、猫玩玩具，playing(String toy),与另一只猫玩playing(Cat cat)。

定义测试类，测试猫的所有功能方法
 */
public class Cat {
    private String type;
    private String color;
    private String age;
    private String height;

    public Cat(String type, String color, String age, String height) {
        this.type = type;
        this.color = color;
        this.age = age;
        this.height = height;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public void printCat() {
        System.out.println(  "Cat{" +
                "type='" + type + '\'' +
                ", color='" + color + '\'' +
                ", age='" + age + '\'' +
                ", height='" + height + '\'' +
                '}');
    }
    public String yelling() {
        return "喵喵喵";
    }
    public void playing(String toy) {
        System.out.println("玩具是" + toy);
    }
    public void playing(Cat cat) {
        System.out.println("朋友" + cat.getType());
    }

    public static void main(String[] args) {
//        Cat cat = new Cat("英短","灰色","2岁","4kg");
//        cat.yelling();
//        cat.playing("毛球");
//        cat.playing(new Cat("加菲","橘色","2岁","4kg"));
//        cat.printCat();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入种类");
        String type = scanner.next();
        System.out.println("请输入颜色");
        String color = scanner.next();
        System.out.println("请输入年龄");
        String age = scanner.next();
        System.out.println("请输入重量");
        String height = scanner.next();
        Cat cat1 = new Cat(type,color,age,height);
        cat1.yelling();
        System.out.println("请给一个玩具");
        String toy = scanner.next();
       cat1.playing(toy);
       cat1.playing(new Cat("加菲","橘色","2岁","4kg"));
       cat1.printCat();
    }
}

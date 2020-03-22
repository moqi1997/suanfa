package com.moqi.test;

/**
 * @author moqi
 * @date 2020/3/22 14:56
 */
public class Student {
    private String sno;
    private String sname;
    private double java;
    private double shujujiegou;
    private String time;
    private String cname;
    private String place;
    public Student(String sno, String sname) {
        this.sno = sno;
        this.sname = sname;
    }

    public Student(String sno, String sname, double java, double shujujiegou) {
        this.sno = sno;
        this.sname = sname;
        this.java = java;
        this.shujujiegou = shujujiegou;
    }
    public void behavior() {
        double sum = java + shujujiegou;
        double avg = (java + shujujiegou) / 2;
        System.out.println("总成绩" + sum + "平均成绩" + avg);
    }


    public void inClass(String time, String cname, String place) {
        this.time = time;
        this.cname = cname;
        this.place = place;
        System.out.println("上课时间" + time + "课程名称" + cname + "上课地点" + place);
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public double getJava() {
        return java;
    }

    public void setJava(double java) {
        this.java = java;
    }

    public double getShujujiegou() {
        return shujujiegou;
    }

    public void setShujujiegou(double shujujiegou) {
        this.shujujiegou = shujujiegou;
    }

    public static void main(String[] args) {
        Student stu1 = new Student("001","小王",89,23);
        Student stu2 = new Student("002","小李",34,67);
        stu1.behavior();
        stu1.inClass("2017年9月29日","3223","Java课程");
        stu2.behavior();
        stu2.inClass("2018年9月29日","4443","Java课程");
    }
}

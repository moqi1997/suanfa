package com.moqi.test;

/**
 * @author moqi
 * @date 2020/3/22 15:32
 */
public class CPU {
    private String model;
    private String frequency;
    private String  price;
    private String register;

    public CPU() {
    }

    public CPU(String model, String frequency, String price) {
        this.model = model;
        this.frequency = frequency;
        this.price = price;
    }

    public String getRegister() {
        return register;
    }

    public void setRegister(String register) {
        this.register = register;
    }

    @Override
    public String toString() {
        return "CPU{" +
                "model='" + model + '\'' +
                ", frequency='" + frequency + '\'' +
                ", price='" + price + '\'' +
                ", register='" + register + '\'' +
                '}';
    }
}

class Test {
    public static void main(String[] args) {
        //创建CPU实例
        CPU cpu = new CPU();

        //创建内存实例
        RAM ram = new RAM();
        ram.setDate("0x0000345");
        //cpu从内存读取数据到寄存器
        cpu.setRegister(ram.getDate());
        System.out.println(cpu.toString());
        //数据从寄存器读取到内存
        ram.setDate(cpu.getRegister());
        System.out.println(ram.toString());

    }
}
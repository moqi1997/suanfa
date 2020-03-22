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
}

package com.example.homework.entity;

public class Order {

    private String command;
    private String name;
    private String value;

    public Order() {
    }

    public Order(String command, String name, String value) {
        this.command = command;
        this.name = name;
        this.value = value;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Order{" +
                "command='" + command + '\'' +
                ", name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}

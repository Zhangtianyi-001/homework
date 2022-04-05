package com.example.homework.homework;

import com.example.homework.entity.Order;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.regex.Pattern;

public class test {

    public static void main(String[] args) throws IOException {
        //0.在文件中进行输入
        //1.打开并读取一个文件
        FileReader file = new FileReader("F:\\factory\\2.txt");
        BufferedReader br = new BufferedReader(file);

        //2.建立一个集合
        ArrayList<Object> arrayList = new ArrayList<>();
        String thing;

        //3.将文件数据放入集合中，判断之后一行是否为空，如果为空，则结束循环。
        while ((thing = br.readLine()) != null) {
            Order order = new Order();
            String[] s = thing.split(" ");
            if (s.length == 2){
                order.setCommand(s[0]);
                order.setName(s[1]);
            }
            else {
                order.setCommand(s[0]);
                order.setName(s[1]);
                order.setValue(s[2]);
            }
            arrayList.add(order);
        }

        //4.关闭文件
        br.close();

        //5.判断command的值，分别执行不同的任务，保存变量名称和值到map中
        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < arrayList.size(); i++) {
            Order order = (Order) arrayList.get(i);
            if (order.getCommand().equals("mov")) {
                //判断第三个变量是否为数字
                Pattern pattern = Pattern.compile("[0-9]*");
                boolean matches = pattern.matcher(order.getValue()).matches();
                //如果是数字
                if (matches){
                    map.put(order.getName(),order.getValue());
                }
                //如果不是数字
                else {
                    String s = map.get(order.getValue());
                    map.put(order.getName(),s);
                }
            }
            if (order.getCommand().equals("inc")){
                String x = map.get(order.getName());
                Integer y = Integer.valueOf(x);
                y++;
                String s = String.valueOf(y);
                map.put(order.getName(),s);
            }
            if (order.getCommand().equals("dec")){
                String x = map.get(order.getName());
                Integer y = Integer.valueOf(x);
                y--;
                String s = String.valueOf(y);
                map.put(order.getName(),s);
            }
            if (order.getCommand().equals("jnz")) {
                String s = map.get(order.getName());
                if (Integer.valueOf(s) == 0) {
                    continue;
                } else {
                    String value = order.getValue();
                    i = i + Integer.valueOf(value) - 1;
                }
            }
        }

        //6.打印map里的变量名称和值
        Set<String> set = map.keySet();
        for (String key : set){
            String value = map.get(key);
            System.out.println(key + " " + value);
        }
    }
}

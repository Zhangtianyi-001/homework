package com.example.homework.Liu;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Liu {
    public static void main(String[] args) throws IOException {

            Path path = Paths.get("F:\\factory\\2.txt");
            Stream<String> stream = Files.lines(path);
            stream.sorted().limit(3).forEach(System.out::println);
            System.out.println(stream);

        // 获取一个Stream流
        Stream<String> stream1 = Stream.of("迪丽热巴", "古力娜扎", "高圆圆", "李沁");
        // 使用Stream流中的方法forEach对Stream流中的数据进行遍历
        stream1.forEach((String asd) -> {
            System.out.println(asd);
        });
    }
}

package com.example.homework;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@SpringBootTest
class HomeworkApplicationTests {

    @Test
    public void test1() {
        List<String> strs = Arrays.asList("a", "bb", "ccc", "dd");
        strs.stream().map(x -> x.length())   // 方法引用：map(String::length)
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    @Test
    //字符串流
    public void test2() {
        // 获取一个Stream流
        Stream<String> stream1 = Stream.of("迪丽热巴", "古力娜扎", "高圆圆", "李沁");
        // 使用Stream流中的方法forEach对Stream流中的数据进行遍历
        stream1.forEach((String asd) -> {
            System.out.println(asd);
        });
    }

    @Test
    //文件流
    public void test3() throws IOException {
        Path path = Paths.get("F:\\factory\\2.txt");
        Stream<String> stream = Files.lines(path);
        stream.map(x -> x.split(" ")).flatMap(Arrays::stream).forEach(System.out::println);
        //stream.sorted().limit(3).forEach(System.out::println);
        //System.out.println(stream);
    }

    @Test
    public void testFilter() {
        List<Integer> nums = Arrays.asList(10, 2, 2, 5, 6, 6, 3);
        //从流中选出偶数，且没有重复
        nums.stream().filter(i -> i % 2 == 0)  //过滤
                .distinct()  //去重
                .sorted((x, y) -> x.compareTo(y)) //排序
                .forEach(x -> System.out.println(x + "-"));
    }

    @Test
    public void test15() {
        int[] arr = {1, 2, 3, 4, 5, 0};

        // 带起始种子
        int sum1 = Arrays.stream(arr).reduce(0, (a, b) -> a + b);
        int sum2 = Arrays.stream(arr).reduce(0, (a, b) -> Integer.sum(a, b));
        int sum3 = Arrays.stream(arr).reduce(0, Integer::sum);
        System.out.println("sum= " + sum1);
        System.out.println("sum= " + sum2);
        System.out.println("sum= " + sum3);

        // 无起始种子，返回Option
        OptionalInt sum4 = Arrays.stream(arr).reduce(Integer::sum);
        sum4.ifPresent(System.out::println);

        // 最大值
        int max = Arrays.stream(arr).reduce(0, Integer::max);
        System.out.println("max= " + max);

        // 最小值
        int min = Arrays.stream(arr).reduce(0, Integer::min);
        System.out.println("min= " + min);
    }


    @Test
    public static int threeSumClosest(int[] nums, int target) {
        if (nums.length < 3) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int sout = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2;) {
            int start = i + 1;
            int end = nums.length - 1;
            while (start != end) {
                int num = Math.abs(nums[i] + nums[start] + nums[end] - target);
                if (num < min) {
                    min = num;
                    sout = nums[i] + nums[start] + nums[end];
                    if (min == 0){
                        return sout;
                    }
                }
                if (nums[i] + nums[start] + nums[end] > target) {
                    end--;
                } else if (nums[i] + nums[start] + nums[end] < target) {
                    start++;
                }
                if (start == end) {
                    i++;
                }
            }
        }
        return sout;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,4,8,16,32,64,128};
        int x = 82;
        int i = threeSumClosest(nums, x);
        System.out.println(i);
    }
}

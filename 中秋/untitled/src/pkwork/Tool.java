package pkwork;

import java.util.Scanner;

public class Tool {
    static Scanner scanner = new Scanner(System.in);

    public static int getInt(String s) {
        System.out.println(s);
        while (!scanner.hasNextInt()) {
            System.out.println("请输入一个有效的整数！");
            scanner.next(); // 跳过错误的输入
            System.out.println(s);
        }
        return scanner.nextInt();
    }

    public static String getStr(String s) {
        System.out.println(s);
        return scanner.next();
    }
}
package Three;

import java.util.Scanner;

public class DemoAccMan {
        public static void main(String[] args) {
            AccountManger manager = new AccountManger();
            Scanner scanner = new Scanner(System.in);
            loopMenu(manager, scanner);
        }

        private static void loopMenu(AccountManger manager, Scanner scanner) {
            while (true) {
                System.out.println("1. 重新登录   2. 修改密码   3. 注册   0. 退出");
                int choice = scanner.nextInt();
                try {
                    switch (choice) {
                        case 1:
                            login(manager, scanner);
                            break;
                        case 2:
                            changePassword(manager, scanner);
                            break;
                        case 3:
                            register(manager, scanner);
                            break;
                        case 0:
                            System.out.println("退出系统");
                            return;
                        default:
                            System.out.println("无效的选择，请重新选择");
                            break;
                    }
                } catch (Exception e) {
                    System.out.println("发生错误：" + e.getMessage());
                }
            }
        }
        private static void login(AccountManger manager, Scanner scanner) throws Exception {
            System.out.println("请输入手机号:");
            String phone = scanner.nextLine();
            System.out.println("请输入密码:");
            String password = scanner.nextLine();
            manager.login(phone, password);
            System.out.println("登录成功");
        }
        //静态修改密码输入方法
        private static void changePassword(AccountManger manager, Scanner scanner) throws Exception {
            System.out.println("请输入新密码:");
            String newPassword = scanner.nextLine();
            manager.changePass(newPassword);
            System.out.println("密码已更新");
        }
        //静态注册输入方法

        private static void register(AccountManger manager, Scanner scanner) throws Exception {
            System.out.println("请输入名字:");
            String name = scanner.nextLine();
            System.out.println("请输入手机号:");
            String phone = scanner.nextLine();
            System.out.println("请输入密码:");
            String password = scanner.nextLine();
            System.out.println("请再次输入密码:");
            String confirmPassword = scanner.nextLine();
            if (!password.equals(confirmPassword)) {
                throw new Exception("两次输入的密码不一致");
            }
            Account newAccount = new Account(name, phone, password);
            manager.addNewAccount(newAccount);
            System.out.println(manager);
    }
}

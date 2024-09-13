package Two;

import java.util.ArrayList;
import java.util.List;

public class AccountManger {
    // 集合列表，用于存储账户信息
    private Account[] accounts;
    // 当前已添加的账户数量
    private int count;

    public AccountManger() {
        this.accounts = new Account[10]; // 初始容量为10
        this.count = 0;
        // 添加3位大佬
        accounts[count++] = new Account("12345678901", "111111", "太上老君");
        accounts[count++] = new Account("12345678902", "222222", "天蓬元帅");
        accounts[count++] = new Account("12345678903", "123456", "玉皇大帝");
    }
    //登录
    public boolean login(String phone, String password) throws Exception {
        for (int i = 0; i < count; i++) {
            Account account = accounts[i];
            if (account.getPhone().equals(phone) && account.getPassword().equals(password)) {
                return true;
            }
        }
        throw new Exception("账号不存在或密码错误");//使用throw语句手动抛出异常
    }

    //修改密码
    public void changePass(String newPassword , String oldPassword) throws Exception {
        for (int i = 0; i < count; i++) {
            Account account = accounts[i];
            if (account.getPassword().equals(oldPassword)) {
                account.setPassword(newPassword);
                return;
            }
        }
        throw new Exception("账号不存在");
    }
    //注册操作

    public void addNewAccount(Account newAccount) throws Exception {
        if (count >= accounts.length) {
            throw new Exception("账户已满，无法添加更多账户");
        }

        // 检查名字长度
        if (newAccount.getName().length() < 2) {
            throw new Exception("名字长度至少为2位");
        }

        // 检查手机号码格式
        if (newAccount.getPhone().length() != 11 ) {
            throw new Exception("手机号格式错误");
        }

        // 检查密码长度
        if (newAccount.getPassword().length() < 6) {
            throw new Exception("密码长度至少为6位");
        }

        accounts[count++] = newAccount;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(accounts[i]).append("\n");
        }
        return sb.toString();
    }
}

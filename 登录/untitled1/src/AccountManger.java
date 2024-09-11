import java.util.ArrayList;
import java.util.List;

public class AccountManger {
    // 集合列表，用于存储账户信息
    private List<Account> accounts;

    private Account account;

    public AccountManger() {
        this.accounts = new ArrayList<>();
        //添加3位大佬
        accounts.add(new Account("12345678901","111111","太上老君"));
        accounts.add(new Account("12345678902","222222","天蓬元帅"));
        accounts.add(new Account("12345678903","123456","玉皇大帝"));
    }
    //登录操作
    public boolean login(String phone, String password) throws Exception {
        for (Account accountT : accounts) {
            // 验证用户输入的电话号码和密码是否与系统中存储的信息匹配
            if (accountT.getPhone().equals(phone) && accountT.getPassword().equals(password)) {
                account = accountT;
                return true;
            }
        }
        throw new Exception("账号不存在或密码错误");
    }

    //修改密码
    public void changePass(String newPassword) throws Exception {
        if (account == null) {
            throw new Exception("未登录，无法修改密码");
        }
        if (newPassword.length() < 6) {
            throw new Exception("密码长度至少为6位");
        }
        account.setPassword(newPassword);
    }
    //注册操作

    public void addNewAccount(Account newAccount) throws Exception {
        // 检查是否已登录，如果未登录抛出异常
        if (accounts == null) {
            throw new Exception("未登录，无法注册新账号");
        }

        // 检查账号名字长度，如果名字长度小于2位，抛出异常
        if (newAccount.getName().length() < 2) {
            throw new Exception("名字长度至少为2位");
        }

        // 检查手机号码格式，如果手机号码长度不是11位或包含非数字，抛出异常
        if (newAccount.getPhone().length() != 11 || !newAccount.getPhone().matches("\\d+")) {
            throw new Exception("手机号格式错误");
        }

        // 检查密码长度，如果密码长度小于6位，抛出异常
        if (newAccount.getPassword().length() < 6) {
            throw new Exception("密码长度至少为6位");
        }

        // 如果所有验证通过，将新账号添加到用户列表中
        accounts.add(newAccount);
    }
    @Override
    public String toString() {
        // 可变字符串StringBuilder
        StringBuilder sb = new StringBuilder();
        // 遍历账户数组，将每个账户的信息添加到StringBuilder中
        for (Account account : accounts) {
            // append()方法将字符串追加到可变字符串的末尾 "\n"换行符
            sb.append(account).append("\n");
        }
        // 将StringBuilder转换为String并返回
        return sb.toString();
    }

}

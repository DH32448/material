package One;

public class Account {
    private String phone;
    private String password;
    private String name;

    public Account() {
    }

    public Account(String phone, String password, String name) {
        this.phone = phone;
        this.password = password;
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "One.Account{" +
                "手机号：'" + phone + '\'' +
                ", 密码：='" + password + '\'' +
                ", 姓名：='" + name + '\'' +
                '}';
    }
}

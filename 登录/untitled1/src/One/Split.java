package One;

public class Split {
    public static void main(String[] args) {
        String str = "GET /addPlayer?name=张无忌&age=20&hp=100 HTTP/1.1";

        // 第一步: 获取查询参数字符串
        int a = str.indexOf('?') + 1;
        int b = str.indexOf(' ', a);
        String c = str.substring(a, b);

        // 第二步: 使用 '&' 对字符串进行分割
        String[] split = c.split("&");

        // 第三步: 对每个数组元素进行 '=' 的分割，并输出结果
        for (String str2 : split) {
            String[] d = str2.split("=");
            if (d.length == 2) {
                System.out.println(d[0] + "->" + d[1]);
            }
        }
    }
}

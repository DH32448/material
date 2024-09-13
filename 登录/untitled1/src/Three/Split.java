package Three;

public class Split {
    public static void main(String[] args) {
        String str = "GET /addPlayer?name=张无忌&age=20&hp=100 HTTP/1.1";

        String[] str2 = str.split("[?]");
         str2 = str2[1].split(" ");
        System.out.println(str2[0]);

        str2 = str2[0].split("&");
        for (String str3 : str2) {
            String[] d = str3.split("=");
            if (d.length == 2) {
                System.out.println(d[0] + "->" + d[1]);
            }
        }

    }
}

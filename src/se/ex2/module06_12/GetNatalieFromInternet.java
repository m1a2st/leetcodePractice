package se.ex2.module06_12;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class GetNatalieFromInternet {

    public static void main(String[] args) {
        File dir = new File("C:\\Pictures");
        if (!dir.exists()) {
            dir.mkdir();
        }

        for (int i = 1; i <= 42; i++) {
            String url = "http://www.space-fox.com/wallpapers/celebs/natalie-portman" +
                    "/natalie_portman_" + i + ".jpg";
            String filename = url.substring(url.lastIndexOf("/") + 1);
            File file = new File(dir, filename);
            try {
                URL myURL = new URL(url);
                URLConnection conn = myURL.openConnection();//要使用http方法所以轉型
                InputStream is = conn.getInputStream();
                FileOutputStream fos = new FileOutputStream(file);

                System.out.println("Wallpaper: " + filename + " kick-off!");

                int length = 0;
                byte[] b = new byte[4096];//4kb(這個數字可以自訂)
                while ((length = is.read(b)) != -1) {
                    // b: 代表要輸出的byte陣列 (資料都放在裡面了)
                    // 0: 代表從這個陣列的第一個元素開始輸出 (索引值)
                    // length: 代表要輸出的資料量
                    fos.write(b, 0, length);
                    fos.flush();   //沖
                }

                fos.close();
                is.close();
                System.out.println(filename + " Done!");

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}

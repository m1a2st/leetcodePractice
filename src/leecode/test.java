package leecode;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Author Ken
 * @Date
 * @Version
 * @Description
 */
public class test {
    public static void main(String[] args) throws IOException {
        Process process = Runtime.getRuntime().exec("top");
        InputStream inputStream = process.getInputStream();
        BufferedInputStream bis = new BufferedInputStream(inputStream);
        byte[] buffer = new byte[1024];
        int bytesRead = 0;
        while ((bytesRead = bis.read(buffer)) != -1) {
            String topString = new String(buffer, 0, bytesRead);
            System.out.println(topString);
        }
    }
}


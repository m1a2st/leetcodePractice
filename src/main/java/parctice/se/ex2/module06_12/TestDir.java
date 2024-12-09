package parctice.se.ex2.module06_12;

import java.io.File;

public class TestDir {

    public static void main(String[] args) {
        File dir = new File("c:\\javawork");     //建立目錄物件
        String[] contents = dir.list();          //取得目錄中的目錄、檔案陣列

        if (!dir.isDirectory())
            System.out.println("Not a directory");
        else if (contents.length == 0)
            System.out.println("目錄 " + dir.getName() + " 內無檔案");
        else
            for (int i = 0; i < contents.length; i++)
                System.out.println(contents[i]);    //列出目錄中的目錄、檔案
    }

}

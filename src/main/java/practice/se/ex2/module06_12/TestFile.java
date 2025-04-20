package practice.se.ex2.module06_12;

import java.io.File;

public class TestFile {
    static void p(String s) {
        System.out.println(s);
    }

    public static void main(String[] args) {

        File f1 = new File("c:\\javawork"); // 目錄物件
        p("File Name: " + f1.getName());
        p("Path: " + f1.getPath());
        p("Abs Path: " + f1.getAbsolutePath());
        p("Parent: " + f1.getParent());
        p(f1.exists() ? "exists" : "does not exist");
        p(f1.canWrite() ? "is writeable" : "is not writeable");
        p(f1.canRead() ? "is readable" : "is not readable");
        p(f1.isDirectory() ? "is a directory" : "is not a directory");
        p(f1.isFile() ? "is a file" : "is not a file");
        p(f1.isAbsolute() ? "is absolute" : "is not absolute");
        p("File last modified: " + f1.lastModified());
        p("File size: " + f1.length() + " Bytes");

    }
}

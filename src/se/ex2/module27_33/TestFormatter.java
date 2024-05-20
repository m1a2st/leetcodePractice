package se.ex2.module27_33;

import java.text.DecimalFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

import static java.lang.System.out;

public class TestFormatter {
    public static void main(String[] args) {

        out.println("------------------數字格式化-------------------");

        double num1 = 12345.678;
        out.println(num1 + "【格式化之前】\n");

        // 使用DecimalFormat類別
        Format dfm1 = new DecimalFormat("#,###.00");
        out.println(dfm1.format(num1) + "【使用DecimalFormat類別格式化】");

        // 使用printf
        out.printf("%,.2f【使用printf格式化】%n", num1);

        out.println("\n------------------日期格式化-------------------");

        Date d1 = new Date();
        out.println(d1 + "【格式化之前的java.util.Date】\n");

        Format sfm1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        out.println(sfm1.format(d1) + "【使用SimpleDateFormat類別格式化】");
        Format sfm2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        out.println(sfm2.format(d1) + "【使用SimpleDateFormat類別格式化】\n");

        out.printf("%tY/%<tm/%<td %<tT【使用printf格式化】%n", d1);
        out.printf("%tF %<tT【使用printf格式化】%n", d1);

        out.println("\n-----------------------------------------------");

        out.printf("我叫%s, 今年%d歲%n", "Peter", 18); // %s字串 , %d整數 , %n換行
        out.printf("PI值趨近於%f ,而自然對數E趨近於%f%n", Math.PI, Math.E); // %f浮點數
        out.printf("PI值不是null: %b", Math.PI); // %b非null為true , null為false

    }
}

package main.java.parctice.se.ex2.module27_33;

import java.text.DateFormat;
import java.util.TimeZone;

public class TestDateFormat {
    public static void main(String[] args) {
        //與地區無關(預設本地格式)
        DateFormat df = DateFormat.getInstance();
//	    DateFormat df = DateFormat.getDateInstance(DateFormat.FULL);
//	    DateFormat df = DateFormat.getTimeInstance(DateFormat.FULL);
//	    DateFormat df = DateFormat.getDateTimeInstance(DateFormat.FULL , DateFormat.FULL);   

        //隨地區語言而變, 如
//	    Locale locale = Locale.TAIWAN ;    //new Locale("zh","TW");
//	    Locale locale = Locale.US ;        //new Locale("en","US");
//	    Locale locale = Locale.JAPAN ;     //new Locale("ja","JP");
//	    Locale locale = Locale.KOREA ;     //new Locale("ko","KR");
//	    Locale locale = Locale.GERMANY;    //new Locale("de","DE")等不同地區語言

//	    DateFormat df = DateFormat.getDateTimeInstance(DateFormat.FULL , DateFormat.FULL , locale);
//	    DateFormat df = DateFormat.getDateTimeInstance(DateFormat.LONG , DateFormat.LONG , locale);
//	    DateFormat df = DateFormat.getDateTimeInstance(DateFormat.MEDIUM , DateFormat.MEDIUM , locale);
//	    DateFormat df = DateFormat.getDateTimeInstance(DateFormat.SHORT , DateFormat.SHORT , locale);


        //設定時區, 如 Japan ; America/Los_Angeles ; Australia/Queensland 等不同的時區
        TimeZone tz = TimeZone.getTimeZone("Japan");
        df.setTimeZone(tz);
        System.out.println(tz.getDisplayName());//傳回適合於展示給預設區域的用戶的時區名稱

        //透過format方法, 將java.util.Date格式化為, 所要顯示的資訊
        String dfu = df.format(new java.util.Date());
        System.out.println(dfu);


        //有那些時區
//	    String[] ids = TimeZone.getAvailableIDs();
//	    for (int i=0 ; i<ids.length ; i++)
//	    		System.out.println(ids[i]);


        //傳回所有語言環境的陣列
//	    Locale[] locales = DateFormat.getAvailableLocales(); 
//	    Locale[] locales = Locale.getAvailableLocales();
//	    for (int i = 0; i < locales.length; i++)
//			System.out.println(locales[i]+ "=" + locales[i].getDisplayName()); 
        //locales[i]: 使用由下劃線分隔的語言、國家/地區和變數來獲取整個語言環境的編程名稱。
        //locales[i].getDisplayName(): 傳回適合向用戶顯示的語言環境名


        //Locale常數測試
//		System.out.println("Locale.TAIWAN="+Locale.TAIWAN);
//	    System.out.println("Locale.TAIWAN="+Locale.US);
//	    System.out.println("Locale.JAPAN="+Locale.JAPAN);
//	    System.out.println("Locale.KOREA="+Locale.KOREA);
//	    System.out.println("Locale.GERMANY="+Locale.GERMANY);

    }
}

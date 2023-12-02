package se.ex1.module16_19;
/*
 * 此範例為示範static方法使用
 */
public class TestStaticMethod {

	public static void main(String[] args) {
		 System.out.println("請畫三角形!");
         int count = 9;
         drawTriangle(count);
         System.out.println("畫的還不錯!");
     }
     
     public static void drawTriangle(int count){
         int i, j;
         for ( i = 1; i <= count; i++){
            for ( j = 1; j <= i; j++ )
               System.out.print("*");
            System.out.println();
         }
	}

}

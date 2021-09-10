package prob01;

import java.util.Scanner;

public class Prob01 {

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      
      int money, a, b, c, d, e, f, g, h, i, j;
      
      System.out.print("금액을 입력하시오>>");
      money = sc.nextInt();
      
      a = money / 50000;
      money = money - (a * 50000); //5만원 계산
      
      b = money / 10000;
      money = money - (b * 10000); //1만원 계산
      
      c = money / 5000;
      money = money - (c * 5000); //5천원 계산
      
      d = money / 1000;
      money = money - (d * 1000); //1000원 계산
      
      e = money / 500;
      money = money - (e * 500); //500원 계산
      
      f = money / 100;
      money = money - (f * 100); //100원 계산
      
      g = money / 50;
      money = money - (g * 50); //50원 계산
      
      h = money / 10;
      money = money - (h * 10); //10원 계산
      
      i = money / 5;
      money = money - (i * 5); //5원 계산
      
      j = money; // 1원 계산
      
      System.out.println("오만원권 : "+ a +"개");
      System.out.println("만원권 : "+ b +"개");
      System.out.println("오천원권 : "+ c +"개");
      System.out.println("천원권 : "+ d +"개");
      System.out.println("오백원 :"+ e +"개");
      System.out.println("백원 : "+ f +"개");
      System.out.println("오십원 : "+ g +"개");
      System.out.println("십원 : " + h +"개");
      System.out.println("오원 : "+ i +"개");
      System.out.println("일원 : " + j +"개");
      
      sc.close();
   }

}
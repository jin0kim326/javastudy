package prob01;

import java.util.Scanner;

public class Prob01 {

   public static void main(String[] args) {
      // TODO Auto-generated method stub
      Scanner sc = new Scanner(System.in);
      
      int money, a, b, c, d, e, f, g;
      //a = 5만원, b = 1만원, c = 1천원, d = 100원, e = 50원, f = 10원, g = 1원
      
      System.out.print("금액을 입력하시오>>");
      money = sc.nextInt();
      
      a = money / 50000;
      money = money - (a * 50000); //5만원 계산
      
      b = money / 10000;
      money = money - (b * 10000); //1만원 계산
      
      c = money / 1000;
      money = money - (c * 1000); //1천원 계산
      
      d = money / 100;
      money = money - (d * 100); //100원 계산
      
      e = money / 50;
      money = money - (e * 50); //50원 계산
      
      f = money / 10;
      money = money - (f * 10); //10원 계산
      
      g = money; // 1원 계산
      
      System.out.print("오만원권 "+a+"매");
      System.out.print("만원권 "+b+"매");
      System.out.print("천원권 "+c+"매");
      System.out.print("백원 "+d+"매");
      System.out.print("오십원 "+e+"매");
      System.out.print("십원 "+f+"매");
      System.out.print("일원 "+g+"매");
      
      sc.close();
   }

}
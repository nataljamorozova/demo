package com.example.demo;

public class MathUtil {

   public static int min(int a, int b) {
      if (a > b) {
         return b;
      } else {
         return a;
      }

   }

   public static int abs(int a) {
      if (a < 0) {
         return a * (-1);
      } else {
         return a;
      }

   }

   public static int neg(int x) {
      //return -abs(x);
      if (x < 0) {
         return x;
      } else {
         return x * (-1);
      }
   }

   public static boolean isNumberEven(int a) {
      if (a % 2 == 0) {
         return (true);
      } else {
         return (false);
      }

   }
   public static int fibonacci1(int nr) {
      int[] a = new int[nr];
      a[0] = 0;
      a[1] = 1;
      for (int i = 2; i < nr; i++) {
         a[i] = a[i - 1] + a[i - 2];
      }
      //for (int i = 0; i <= nr; i++) {
      //    System.out.println(a[i]);
      return a[nr - 1];
   }

   public static int closestToZero(int a, int b, int c) {
      //siin parem kasutada if ((abs(a)>abs(b))&&(abs(b)>abs(c)){
      //return c
      if (abs(a) > abs(b)) {
         if (abs(b) > abs(c)) {
            return c;
         } else {
            return b;
         }
      } else {
         if (abs(a) > abs(c)) {
            return c;
         } else {
            return a;
         }
      }
   }
}
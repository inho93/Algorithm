package normal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
https://www.acmicpc.net/problem/2748
 */
public class p2748 {
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    long num1 = 0;
    long num2 = 1;
    long num3 = 1;
    for (int i = 0; i < n - 1; i++) {
      num3 = num1 + num2;
      num1 = num2;
      num2 = num3;
    }
    System.out.println(num3);
  }
}
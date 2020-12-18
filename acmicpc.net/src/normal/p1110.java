package normal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
https://www.acmicpc.net/problem/1110
 */
public class p1110 {
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    int count = 0;
    int newNum = n;
    while(true) {
      count++;
      int ten = newNum / 10;
      int one = newNum % 10;
      if (newNum < 10) {
        ten = 0;
      }

      int sum = ten + one;
      newNum = one * 10 + sum % 10;
      if (newNum == n) {
        break;
      }
    }
    System.out.println(count);
  }
}
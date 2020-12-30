package normal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
https://www.acmicpc.net/problem/2739
 */
public class p2739 {
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    for (int i = 1; i < 10; i++) {
      System.out.println(n + " * " + i + " = " + n*i);
    }
  }
}

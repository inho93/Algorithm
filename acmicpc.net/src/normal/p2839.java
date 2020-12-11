package normal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
https://www.acmicpc.net/problem/2839
 */
public class p2839 {
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int NKg = Integer.parseInt(br.readLine());
    int div = NKg / 5 ;
    int min = 0;
    for (int i = div; i >= 0; i--) {
      int remain = NKg - i * 5;
      if (remain % 3 == 0) {
        min = i + remain / 3;
        break;
      }
    }
    if (min == 0) {
      System.out.println(-1);
    }
    else {
      System.out.println(min);
    }
  }
}

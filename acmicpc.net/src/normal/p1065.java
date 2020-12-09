package normal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
https://www.acmicpc.net/problem/1065
 */
public class p1065 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int sum = 99;
    if (n < 100) {
      // 1부터 99까지는 모두 해당.
      System.out.println(n);
    }
    else {
      for (int i = 100; i <= n; ++i) {
        int i_100 = i / 100;
        int i_10 = (i % 100) / 10;
        int i_1 = (i % 10);

        if ((i_100 - i_10) == (i_10 - i_1)) {
          sum++;
        }
      }
      System.out.println(sum);
    }
  }
}

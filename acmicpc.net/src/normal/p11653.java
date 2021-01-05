package normal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
https://www.acmicpc.net/problem/11653
 */
public class p11653 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    if (n == 1) {
      return;
    }
    int i = 2;
    while(n != 1) {
      if (n % i == 0) {
        n = n / i;
        System.out.println(i);
      }
      else {
        i++;
      }
    }
  }
}

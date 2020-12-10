package normal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
소수구하기 에라토스테네스의 체
https://www.acmicpc.net/problem/1929
 */
public class p1929 {
  static boolean[] isPrime = new boolean[1000001];
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] line = br.readLine().split(" ");
    int m = Integer.parseInt(line[0]);
    int n = Integer.parseInt(line[1]);

    for (int i = 1; i <=n; ++i) {
      isPrime[i] = true;
    }

    for (int i = 2; i <=n; ++i) {
      if (!isPrime[i]) {
        continue;
      }

      // 배수 지우는 반복문
      for (int j = i+i; j <= n; j = j+i) {
        isPrime[j] = false;
      }
    }

    for (int i =m;i<=n;i++) {
      if (isPrime[i]) {
        if (i == 1){
          continue;
        }
        System.out.println(i);
      }
    }
  }
}

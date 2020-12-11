package normal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
https://www.acmicpc.net/problem/1978
 */
public class p1978 {
  public static boolean[] isPrime = new boolean[1001];
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int caseCount = Integer.parseInt(br.readLine());

    for (int i = 0; i < 1001; i++) {
      isPrime[i] = true;
    }

    for (int i = 2; i < 1001; i++) {
      if (isPrime[i] == false) {
        continue;
      }
      for (int j = 2; j*i < 1001; j++) {
        isPrime[j*i] = false;
      }
    }

    String[] inputNum = br.readLine().split(" ");
    int count = 0;
    for (int i = 0; i < caseCount; i++) {
      int checkNum = Integer.parseInt(inputNum[i]);
      if (checkNum == 1) {
        continue;
      }
      if (isPrime[checkNum] == true) {
        count++;
      }
    }
    System.out.println(count);
  }
}

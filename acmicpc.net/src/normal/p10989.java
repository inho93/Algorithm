package normal;

import java.io.*;

/*
메모리와 시간초과를 고려한 최적화
https://www.acmicpc.net/problem/10989
 */
public class p10989 {
  static Short[] nums = new Short[20001];
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    for (int i = 0; i < 20001; i++) {
      nums[i] = 0;
    }

    for (int i = 0; i < n; i++) {
      Short inputNum = Short.parseShort(br.readLine());
      nums[inputNum + 10000]++;
    }
    br.close();

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    for (int i = 0; i < 20001; i++) {
      if (nums[i] != 0) {
        for (int j = 0; j < nums[i]; j++) {
          int resultNum = i - 10000;
          bw.write(resultNum + "\n");
        }
      }
    }
    bw.flush();
  }
}

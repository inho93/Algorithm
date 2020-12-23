package normal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
https://www.acmicpc.net/problem/9012
 */
public class p9012 {
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int caseCount = Integer.parseInt(br.readLine());
    for (int i = 0; i <caseCount; i++) {
      int leftCount = 0;
      int rightCount = 0;
      boolean isEnd = false;
      String line = br.readLine();
      for (char ch : line.toCharArray()) {
        if (ch == '(') {
          leftCount++;
        }
        else {
          rightCount++;
        }
        if (leftCount < rightCount) {
          System.out.println("NO");
          isEnd = true;
          break;
        }
      }
      if (!isEnd) {
        if (leftCount == rightCount) {
          System.out.println("YES");
        } else {
          System.out.println("NO");
        }
      }
    }

  }
}

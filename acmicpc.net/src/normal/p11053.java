package normal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
수열, 다이나믹 프로그래밍
https://www.acmicpc.net/problem/11053
 */
public class p11053 {
  static int[] visited = new int[1001];
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int caseCount = Integer.parseInt(br.readLine());
    String[] line = br.readLine().split(" ");
    int[] sequence = new int[caseCount];
    for (int i = 0; i < caseCount; i++) {
      sequence[i] = Integer.parseInt(line[i]);
    }

    Arrays.fill(visited, 0);
    if (sequence.length == 1) {
      visited[sequence[0]]++;
    }
    else {
      for (int currentX = 0; currentX < sequence.length - 1; currentX++) {
        int currentY = sequence[currentX];
        if (visited[currentX] == 0) {
          visited[currentX]++;
        }
        for (int nextX = currentX + 1; nextX < sequence.length; nextX++) {
          int nextY = sequence[nextX];
          if (currentY < nextY) {
            if (visited[nextX] <= visited[currentX]) {
              visited[nextX] = visited[currentX] + 1;
            }
          }
        }
      }
    }
    int max = 0;
    for (Integer integer : visited) {
      if (integer > max) {
        max = integer;
      }
    }
    System.out.println(max);
  }
}
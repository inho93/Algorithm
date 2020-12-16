package normal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
https://www.acmicpc.net/problem/1012
 */
public class p1012 {
  static int row;
  static int column;
  static boolean[][] isOn;
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int caseCount = Integer.parseInt(br.readLine());
    for (int i = 0; i < caseCount; i++) {
      String[] firstLine = br.readLine().split(" ");
      int index = 0;
      row = Integer.parseInt(firstLine[index++]);
      column = Integer.parseInt(firstLine[index++]);
      int onTotalCount = Integer.parseInt(firstLine[index++]);

      isOn = new boolean[row][column];
      for (int j = 0; j < row; j++) {
        Arrays.fill(isOn[j], false);
      }

      for (int j = 0; j < onTotalCount; j++) {
        String[] location = br.readLine().split(" ");
        int locationIndex = 0;
        int x = Integer.parseInt(location[locationIndex++]);
        int y = Integer.parseInt(location[locationIndex++]);
        isOn[x][y] = true;
      }

      // Logic
      int bug = 0;
      for (int j = 0; j < row; j++) {
        for (int k = 0; k < column; k++) {
          if (isOn[j][k]) {
            bug++;
            findBug(j, k);
          }
        }
      }
      System.out.println(bug);
    }
  }

  private static void findBug(int x, int y) {
    if (isOn[x][y]) {
      isOn[x][y] = false;
      if (x > 0) {
        findBug( x - 1, y);
      }

      if (y > 0) {
        findBug( x, y - 1);
      }

      if (x < row - 1) {
        findBug( x + 1, y);
      }

      if (y < column - 1) {
        findBug( x, y + 1);
      }
    }
  }
}

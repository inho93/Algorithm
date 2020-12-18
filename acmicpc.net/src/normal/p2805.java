package normal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
https://www.acmicpc.net/problem/2805
 */
public class p2805 {
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] firstLine = br.readLine().split(" ");
    int treeTotal = Integer.parseInt(firstLine[0]);
    int neededLength = Integer.parseInt(firstLine[1]);

    int[] treeLengthArray = new int[treeTotal];
    int maxLength = 0;
    String[] treesLength = br.readLine().split(" ");
    for (int i = 0; i < treeTotal; i++) {
      int treeLength = Integer.parseInt(treesLength[i]);
      treeLengthArray[i] = treeLength;
      if (maxLength < treeLength) {
        maxLength = treeLength;
      }
    }

    int max = maxLength;
    int min = 0;
    for (int h = maxLength / 2; h >= 0;) {
      long cutSum = 0;
      for (int i = 0; i < treeTotal; i++) {
        int cutLength = treeLengthArray[i] - h;
        if (cutLength > 0) {
          cutSum += cutLength;
        }
      }

      if (cutSum == neededLength) {
        System.out.println(h);
        break;
      }
      else if (cutSum > neededLength) {
        min = h;
      }
      else {
        max = h;
      }
      if (max - min <= 1) {
        if (h == max && cutSum > neededLength) {
          System.out.println(max);
        }
        else {
          System.out.println(min);
        }
        break;
      }
      h = min + (max - min) / 2;
    }
  }
}

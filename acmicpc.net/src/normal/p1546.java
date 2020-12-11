package normal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
https://www.acmicpc.net/problem/1546
 */
public class p1546 {
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int caseCount = Integer.parseInt(br.readLine());

    String[] line = br.readLine().split(" ");
    int[] scores = new int[caseCount];
    int maxScore = 0;
    for (int i = 0; i < caseCount; i++) {
      scores[i] = Integer.parseInt(line[i]);
      if (maxScore < scores[i]) {
        maxScore = scores[i];
      }
    }

    double[] newSocres = new double[caseCount];
    double sum = 0;
    for (int i = 0; i < caseCount; i++) {
      newSocres[i] = ((double)scores[i] / (double)maxScore) * 100;
      sum += newSocres[i];
    }
    System.out.println(sum / caseCount);
  }
}

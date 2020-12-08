package normal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
https://www.acmicpc.net/problem/4344
 */
public class p4344 {
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int caseCount = Integer.parseInt(br.readLine());
    List<String> outputs = new ArrayList<>();
    for (int i = 0; i < caseCount; ++i) {
      String[] line = br.readLine().split(" ");
      int index = 0;
      int N = Integer.parseInt(line[index++]);
      int studentScore[] = new int[N+1];
      int scoreSum = 0;
      for (int j = 0; j < N; ++j) {
        int score = Integer.parseInt(line[index++]);
        studentScore[j] = score;
        scoreSum += score;
      }
      double scoreAvg = scoreSum / N;

      int upAvgNum = 0;
      for (int j = 0; j < N; ++j) {
        if (studentScore[j] > scoreAvg) {
          upAvgNum++;
        }
      }
      double rate = (double)(upAvgNum * 100) / (double)N;
      String output = String.format("%.3f", rate) + "%";
      outputs.add(output);
    }

    for (String output : outputs) {
      System.out.println(output);
    }
  }
}

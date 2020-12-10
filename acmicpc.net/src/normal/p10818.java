package normal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
https://www.acmicpc.net/problem/10818
 */
public class p10818 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] line = br.readLine().split(" ");
    int caseCount = Integer.parseInt(line[0]);

    int[] array = new int[caseCount];
    String[] numbers = br.readLine().split(" ");
    for (int i = 0; i < caseCount; ++i) {
      array[i] = Integer.parseInt(numbers[i]);
    }

    Arrays.parallelSort(array);
    System.out.println(array[0] + " " + array[caseCount - 1]);
  }
}

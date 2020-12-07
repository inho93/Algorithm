import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
https://www.acmicpc.net/problem/1003
 */
public class p1003 {
  private static Map<Integer, Integer> zeroSaveMap = new HashMap<>();
  private static Map<Integer, Integer> oneSaveMap = new HashMap<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int caseCount = Integer.parseInt(br.readLine());
    List<String> answerList = new ArrayList<>();

    for (int i = 0; i < caseCount; ++i) {
      int n = Integer.parseInt(br.readLine());

      zeroFibonacci(n);
      oneFibonacci(n);

      String answer = zeroSaveMap.get(n) + " " + oneSaveMap.get(n);
      answerList.add(answer);
    }

    for (String answer : answerList) {
      System.out.println(answer);
    }
  }

  private static int zeroFibonacci(int n) {
    if (n == 0) {
      zeroSaveMap.put(n, 1);
      return 1;
    }
    else if (n == 1) {
      zeroSaveMap.put(n, 0);
      return 0;
    }
    else {
      int before1;
      int before2;

      if (!zeroSaveMap.containsKey(n - 1)) {
        before1 = zeroFibonacci(n - 1);
        zeroSaveMap.put(n - 1, before1);
      }
      else {
        before1 = zeroSaveMap.get(n - 1);
      }

      if (!zeroSaveMap.containsKey(n - 2)) {
        before2 = zeroFibonacci(n - 2);
        zeroSaveMap.put(n - 2, before2);
      }
      else {
        before2 = zeroSaveMap.get(n - 2);
      }

      zeroSaveMap.put(n, before1 + before2);
      return before1 + before2;
    }
  }

  private static int oneFibonacci(int n) {
    if (n == 0) {
      oneSaveMap.put(n, 0);
      return 0;
    }
    else if (n == 1) {
      oneSaveMap.put(n, 1);
      return 1;
    }
    else {
      int before1;
      int before2;

      if (!oneSaveMap.containsKey(n - 1)) {
        before1 = oneFibonacci(n - 1);
        oneSaveMap.put(n - 1, before1);
      }
      else {
        before1 = oneSaveMap.get(n - 1);
      }

      if (!oneSaveMap.containsKey(n - 2)) {
        before2 = oneFibonacci(n - 2);
        oneSaveMap.put(n - 2, before2);
      }
      else {
        before2 = oneSaveMap.get(n - 2);
      }

      oneSaveMap.put(n, before1 + before2);
      return before1 + before2;
    }
  }
}

package normal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
기하학
https://www.acmicpc.net/problem/1002
 */
public class p1002 {
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int caseCount = Integer.parseInt(br.readLine());
    List<Integer> answerList = new ArrayList<>();

    for(int i = 0; i < caseCount; ++i) {
      String caseLine = br.readLine();
      String[] words = caseLine.split(" ");

      int j = 0;
      int joX = Integer.parseInt(words[j++]);
      int joY = Integer.parseInt(words[j++]);
      int joR = Integer.parseInt(words[j++]);

      int backX = Integer.parseInt(words[j++]);
      int backY = Integer.parseInt(words[j++]);
      int backR = Integer.parseInt(words[j++]);

      int twoPersonDistance = (joX - backX) * (joX - backX) + (joY - backY) * (joY - backY);
      int marinDistanceSum = (joR + backR) * (joR + backR);
      int marinDistanceSub = (joR - backR) * (joR - backR);

      if (marinDistanceSub < twoPersonDistance && twoPersonDistance < marinDistanceSum) {
        answerList.add(2);
      }
      else if (twoPersonDistance == marinDistanceSum) {
        answerList.add(1);
      }
      else if (twoPersonDistance == marinDistanceSub && twoPersonDistance > 0){
        answerList.add(1);
      }
      else if (twoPersonDistance < marinDistanceSub) {
        answerList.add(0);
      }
      else if (twoPersonDistance > marinDistanceSum) {
        answerList.add(0);
      }
      else if (twoPersonDistance == 0 && joR == backR) {
        answerList.add(-1);
      }
      else {
        answerList.add(0);
      }
    }

    for (Integer answer : answerList) {
      System.out.println(answer);
    }
  }
}

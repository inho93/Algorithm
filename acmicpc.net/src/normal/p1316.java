package normal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class p1316 {
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int caseCount = Integer.parseInt(br.readLine());
    int count = 0;
    for (int i = 0; i < caseCount; i++) {
      String word = br.readLine();
      char[] chars = word.toCharArray();
      Map<Character, Boolean> map = new HashMap<>();
      char beforeCh = ' ';
      boolean isSequenceWord = true;
      for (char ch : chars) {
        if (map.containsKey(ch)) {
          if (beforeCh == ch) {
            continue;
          }
          else {
            isSequenceWord = false;
            break;
          }
        }
        map.put(ch, true);
        beforeCh = ch;
      }
      if (isSequenceWord) {
        count++;
      }
    }
    System.out.println(count);
  }
}
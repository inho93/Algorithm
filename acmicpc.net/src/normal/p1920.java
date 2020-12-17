package normal;

import java.io.*;
import java.util.*;

/*
https://www.acmicpc.net/problem/1920
 */
public class p1920 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    Map<Long, Boolean> numMap = new HashMap<>();
    String[] nLine = br.readLine().split(" ");
    for (int i = 0; i < n ; i++) {
      long inputNum = Long.parseLong(nLine[i]);
      numMap.put(inputNum, Boolean.TRUE);
    }

    int m = Integer.parseInt(br.readLine());
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String[] mLine = br.readLine().split(" ");
    for (int i = 0; i < m ;i++) {
      long inputNum = Long.parseLong(mLine[i]);
      if (numMap.containsKey(inputNum)) {
        bw.write(1 +"\n");
      }
      else {
        bw.write(0 +"\n");
      }
    }
    bw.flush();
  }
}

package normal;

import java.io.*;
import java.util.*;

/*
정렬, Arrays와 Collections의 sort함수의 차이 이해 및 숙지
입출력에서 뭐가 빠른지에 대한 이해 및 숙지
https://www.acmicpc.net/problem/2751
 */
public class p2751 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    List<Integer> numList = new ArrayList<>();
    for (int i = 0; i < n ; i++) {
      int inputNum = Integer.parseInt(br.readLine());
      numList.add(inputNum);
    }

    Collections.sort(numList);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    for (int i = 0; i < n ;i++) {
      bw.write(numList.get(i) + "\n");
    }
    bw.flush();
  }
}

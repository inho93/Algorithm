package normal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/*
https://www.acmicpc.net/problem/1463
 */
public class p1463 {
  private static int[] d = new int[1000001];
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    for (int i=0; i < 1000001; i++) {
      d[i] = 0;
    }
    Queue<Integer> queue = new LinkedBlockingQueue<>();
    queue.add(n);
    while (true) {
      n = queue.poll();
      if (n == 1) {
        break;
      }
      int count = d[n];
      count++;
      if (n % 3 == 0) {
        if (d[n/3] == 0 || d[n/3] > count) {
          d[n / 3] = count;
          queue.add(n / 3);
        }
      }
      if (n % 2 == 0) {
        if (d[n/2] == 0 || d[n/2] > count) {
          d[n / 2] = count;
          queue.add(n / 2);
        }
      }
      if (d[n-1] == 0 || d[n-1] > count) {
        d[n - 1] = count;
        queue.add(n - 1);
      }
    }
    System.out.println(d[1]);
  }
}
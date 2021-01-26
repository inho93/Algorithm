package normal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
https://www.acmicpc.net/problem/1330
 */
public class p1330 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] line = br.readLine().split(" ");
    int a = Integer.parseInt(line[0]);
    int b = Integer.parseInt(line[1]);

    String output;
    if ( a > b) {
      output = ">";
    }
    else if (a < b) {
      output = "<";
    }
    else {
      output = "==";
    }
    System.out.println(output);
  }
}
package normal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
https://www.acmicpc.net/problem/2908
 */
public class p2908 {
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] line = br.readLine().split(" ");
    String A = line[0];
    String B = line[1];

    char[] reverseA = new char[A.length()];
    int i = A.length() - 1;
    for (char ch : A.toCharArray()) {
      reverseA[i--] = ch;
    }

    char[] reverseB = new char[B.length()];
    i = B.length() - 1;
    for (char ch : B.toCharArray()) {
      reverseB[i--] = ch;
    }

    String reverseAStr = new String(reverseA);
    String reverseBStr = new String(reverseB);

    int AInt = Integer.parseInt(reverseAStr);
    int BInt = Integer.parseInt(reverseBStr);
    if (AInt > BInt) {
      System.out.println(reverseAStr);
    }
    else {
      System.out.println(reverseBStr);
    }
  }
}
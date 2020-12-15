package normal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

/*
BigDecimal 사용해보기
https://www.acmicpc.net/problem/1008
 */
public class p1008 {
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] lines = br.readLine().split(" ");
    int a = Integer.parseInt(lines[0]);
    int b = Integer.parseInt(lines[1]);
    BigDecimal A = BigDecimal.valueOf(a);
    BigDecimal B = BigDecimal.valueOf(b);
    BigDecimal div = A.divide(B, 38, BigDecimal.ROUND_UP);;
    System.out.println(div.toString());
  }
}

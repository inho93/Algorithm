package normal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
https://www.acmicpc.net/problem/11047
 */
public class p11047 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] firstLine = br.readLine().split(" ");
    int n = Integer.parseInt(firstLine[0]);
    int k = Integer.parseInt(firstLine[1]);

    List<Integer> coinList = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      int coin = Integer.parseInt(br.readLine());
      coinList.add(coin);
    }
    Collections.reverse(coinList);

    int money = k;
    int totalCoin = 0;
    while(money != 0) {
      for (Integer coin : coinList) {
        int coinCount = money / coin;
        if (coinCount < 1) {
          continue;
        }
        money = money - coin * coinCount;
        totalCoin = totalCoin + coinCount;
      }
    }
    System.out.println(totalCoin);
  }
}

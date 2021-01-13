package normal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
https://www.acmicpc.net/problem/13305
 */
public class p13305 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    List<City> cityList = new ArrayList<>();
    String[] distanceStrs = br.readLine().split(" ");
    String[] priceStrs = br.readLine().split(" ");

    for (int i = 0; i < n; i++) {
      City city = new City(Integer.parseInt(priceStrs[i]));
      cityList.add(city);
    }

    for (int i = 0; i < n - 1; i++) {
      cityList.get(i).setRightCityDistance(Integer.parseInt(distanceStrs[i]));
    }

    long totalPrice = 0;
    int distance = 0;
    int minPrice = cityList.get(0).oilPrice;
    for (int i = 0; i < n; i++) {
      City city = cityList.get(i);
      if ((i == n - 1) || city.oilPrice < minPrice) {
        totalPrice += (long) distance * minPrice;
        minPrice = city.oilPrice;
        distance = city.rightCityDistance;
      }
      else {
        distance += city.rightCityDistance;
      }
    }

    System.out.println(totalPrice);
  }

  private static class City {
    private int oilPrice;
    private int rightCityDistance = 1;

    public City(int oilPrice) {
      this.oilPrice = oilPrice;
    }

    public void setRightCityDistance(int rightCityDistance) {
      this.rightCityDistance = rightCityDistance;
    }
  }
}

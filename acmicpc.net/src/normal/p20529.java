package normal;

import java.io.*;

/*
https://www.acmicpc.net/problem/20529
 */
public class p20529 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int caseT = Integer.parseInt(br.readLine());
    for (int i = 0; i < caseT; i++) {
      int studentNum = Integer.parseInt(br.readLine());
      String[] mbtiArray = br.readLine().split(" ");

      int mbtiCase[] = new int[16];
      for (int j = 0; j < studentNum; j++) {
        String mbti = mbtiArray[j];
        mbtiCase[mbtiConvert(mbti)]++;
      }

      int ABMin = 100;
      int ACMin = 100;
      int BCMin = 100;
      int SumMin = 100;
      for (int j = 0; j < 16; j++) {
        int ANum = mbtiCase[j];
        if (ANum == 0) {
          continue;
        }

        for (int k = 0; k < 16; k++) {
          int BNum = mbtiCase[k];
          if (j == k && BNum <= 1) {
            continue;
          } else if (BNum == 0) {
            continue;
          }

          for (int l = 0; l < 16; l++) {
            int CNum = mbtiCase[l];
            if (j == k && k == l && CNum <= 2) {
              continue;
            } else if ((j == l || k == l) && CNum <= 1) {
              continue;
            } else if (CNum == 0) {
              continue;
            }

            int distance1 = j ^ k;
            distance1 = Integer.bitCount(distance1);
            int distance2 = j ^ l;
            distance2 = Integer.bitCount(distance2);
            int distance3 = k ^ l;
            distance3 = Integer.bitCount(distance3);
            if (ABMin >= distance1) {
              if (ACMin >= distance2) {
                if (BCMin >= distance3) {
                  ABMin = distance1;
                  ACMin = distance2;
                  BCMin = distance3;
                  SumMin = ABMin + ACMin + BCMin;
                }
              }
            }
          }
        }
      }
      System.out.println(SumMin);
    }
  }

  private static int mbtiConvert(String mbti) {
    int mbtiInteger = 0;
    for (char ch : mbti.toLowerCase().toCharArray()) {
      switch (ch) {
        case 'i':
          mbtiInteger = mbtiInteger + 1;
          break;
        case 'n':
          mbtiInteger = mbtiInteger + 2;
          break;
        case 'f':
          mbtiInteger = mbtiInteger + 4;
          break;
        case 'p':
          mbtiInteger = mbtiInteger + 8;
          break;
        default:
          break;
      }
    }
    return mbtiInteger;
  }
}

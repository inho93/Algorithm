package normal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
https://www.acmicpc.net/problem/2941
 */
public class p2941 {
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String word = br.readLine();

    int count = 0;
    char before2Ch = ' ';
    char beforeCh = ' ';
    char[] words = word.toCharArray();
    for (char ch : words) {
      count++;
      switch (ch) {
        case '=':
          if (beforeCh == 'c' || beforeCh == 's') {
            count--;
            beforeCh = ' ';
          }
          else if (beforeCh == 'z') {
            if (before2Ch == 'd') {
              count = count - 2;
              before2Ch = ' ';
            }
            else {
              count--;
            }
            beforeCh = ' ';
          }
          break;
        case '-':
          if (beforeCh == 'c' || beforeCh == 'd') {
            count--;
            beforeCh = ' ';
          }
          break;
        case 'j':
          if (beforeCh == 'l' || beforeCh == 'n') {
            count--;
            beforeCh = ' ';
          }
          break;
        default:
          before2Ch = beforeCh;
          beforeCh = ch;
      }
    }
    System.out.println(count);
  }
}

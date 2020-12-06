import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Main 으로 클래스명 변경필요.
public class p1000 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line = br.readLine();
    String[] words = line.split(" ");
    if (words.length < 2) {
      System.out.println("입력 부족.");
      return;
    }

    int x = Integer.parseInt(words[0]);
    int y = Integer.parseInt(words[1]);
    System.out.println(x+y);
  }
}

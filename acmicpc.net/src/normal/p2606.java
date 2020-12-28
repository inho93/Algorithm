package normal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
https://www.acmicpc.net/problem/2606
 */
public class p2606 {
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int caseCount = Integer.parseInt(br.readLine());

    List<Computer> computers = new ArrayList<>();
    for (int i = 0; i <caseCount; i++) {
      computers.add(new Computer(i+1));
    }

    int nodeCount = Integer.parseInt(br.readLine());
    for (int i = 0; i < nodeCount; i++) {
      String[] line = br.readLine().split(" ");
      int first = Integer.parseInt(line[0]);
      int second = Integer.parseInt(line[1]);

      computers.get(first - 1).linkedComputer.add(computers.get(second - 1));
      computers.get(second - 1).linkedComputer.add(computers.get(first - 1));
    }

    int count = 0;
    Queue<Computer> queue = new ArrayDeque<>();
    queue.add(computers.get(0));
    while (queue.size() != 0) {
      Computer computer = queue.poll();
      if (!computer.checked) {
        computer.checked = true;
        count++;
      }
      for (Computer linkComputer : computer.linkedComputer) {
        if (!linkComputer.checked) {
          queue.add(linkComputer);
        }
      }
    }
    System.out.println(count - 1);
  }

  private static class Computer {
    private int no;
    private List<Computer> linkedComputer = new LinkedList<>();
    private boolean checked = false;
    Computer(int no) {
      this.no = no;
    }
  }
}

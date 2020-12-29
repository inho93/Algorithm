package normal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
https://www.acmicpc.net/problem/10814
 */
public class p10814 {
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int caseCount = Integer.parseInt(br.readLine());

    List<Member> memberList = new LinkedList<>();
    for (int i = 0; i < caseCount; i++) {
      String[] line = br.readLine().split(" ");
      int age = Integer.parseInt(line[0]);
      String name = line[1];
      memberList.add(new Member(age, name, i));
    }

    Collections.sort(memberList);

    for (Member member : memberList) {
      System.out.println(member.age + " " + member.name);
    }
  }

  private static class Member implements Comparable<Member> {
    int age;
    String name;
    int joinNum;
    Member(int age, String name, int joinNum) {
      this.age = age;
      this.name = name;
      this.joinNum = joinNum;
    }

    @Override
    public int compareTo(Member o) {
      if (this.age < o.age) {
        return -1;
      }
      else if (this.age > o.age) {
        return 1;
      }
      else {
        if (this.joinNum > o.joinNum) {
          return 1;
        }
        else {
          return -1;
        }
      }
    }
  }
}

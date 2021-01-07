package normal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/*
https://www.acmicpc.net/problem/1931
 */
public class p1931 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    List<Meeting> meetingList = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      String[] line = br.readLine().split(" ");
      int start = Integer.parseInt(line[0]);
      int end = Integer.parseInt(line[1]);
      Meeting meeting = new Meeting(start, end);
      meetingList.add(meeting);
    }

    Collections.sort(meetingList);

    int count = 0;
    int currentEnd = 0;
    for (Meeting meeting : meetingList) {
      if (meeting.start >= currentEnd) {
        currentEnd = meeting.end;
        count++;
      }
    }
    System.out.println(count);
  }

  private static class Meeting implements Comparable {
    int start;
    int end;

    public Meeting(int start, int end) {
      this.start = start;
      this.end = end;
    }

    @Override
    public int compareTo(Object o) {
      Meeting meeting = (Meeting) o;
      if (this.end < meeting.end) {
        return -1;
      } else if (this.end == meeting.end){
        if (this.start > meeting.start) {
          return 1;
        }
        else {
          return -1;
        }
      }
      else {
        return 1;
      }
    }
  }
}

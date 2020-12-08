package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
https://www.acmicpc.net/problem/20055
 */
public class p20055 {
  /*
    로봇 이동 과정 순서
    1. 벨트 1 회전
    2. 먼저 올라간 로봇부터 회전 방향으로 한 칸씩 이동. 이동 X시 그대로
        이동 조건 1. 이동 칸에 로봇X    2. 이동 칸의 내구도 1 이상
    3. 올라가는 위치 로봇X시 올리기
    4. 내구도 0이 K 이상시 종료

    -> 종료 시 몇 단계까지. 처음 = 1단계
   */

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] firstLine = br.readLine().split(" ");
    int N = Integer.parseInt(firstLine[0]);
    int K = Integer.parseInt(firstLine[1]);

    class BeltSpace {
      Integer health;
      Boolean isRobot;
      BeltSpace nextBeltSpace;

      BeltSpace(Integer health) {
        this.health = health;
        this.isRobot = false;
      }

      public void setNextBeltSpace(BeltSpace nextBeltSpace) {
        this.nextBeltSpace = nextBeltSpace;
      }
    }

    List<BeltSpace> belts = new ArrayList<>();
    String[] health = br.readLine().split(" ");
    for (int i = 0; i < health.length; ++i) {
      BeltSpace beltSpace = new BeltSpace(Integer.parseInt(health[i]));
      belts.add(beltSpace);

      if (i > 0) {
        BeltSpace before = belts.get(i - 1);
        before.setNextBeltSpace(beltSpace);
      }
    }
    belts.get(belts.size() - 1).setNextBeltSpace(belts.get(0));

    Set<BeltSpace> zeroHealth = new HashSet<>();

    class Robot {
      BeltSpace beltSpace;

      Robot(BeltSpace beltSpace) {
        this.beltSpace = beltSpace;
        beltSpace.isRobot = true;
        beltSpace.health--;
        if (beltSpace.health == 0) {
          zeroHealth.add(beltSpace);
        }
      }

      void move(BeltSpace nextBeltSpace) {
        if (!nextBeltSpace.isRobot && nextBeltSpace.health > 0) {
          beltSpace.isRobot = false;

          beltSpace = nextBeltSpace;
          beltSpace.isRobot = true;
          beltSpace.health--;
          if (beltSpace.health == 0) {
            zeroHealth.add(beltSpace);
          }
        }
      }
    }

    int level = 1;

    // 올라가는 위치만 영향
    int upIndex = 0;
    int downIndex = N - 1;
    List<Robot> robots = new ArrayList<>();
    while (true) {
      // 1번 작업 벨트 한 칸 이동
      // 벨트 이동하면서 로봇 내리기
      for (Iterator<Robot> robotIterator = robots.iterator(); robotIterator.hasNext(); ) {
        Robot robot = robotIterator.next();
        if (robot.beltSpace == belts.get(downIndex)) {
          // 로봇 내리기
          robot.beltSpace.isRobot = false;
          robotIterator.remove();
          break;
        }
      }
      upIndex--;
      downIndex--;
      if (upIndex < 0) {
        upIndex = belts.size() - 1;
      }

      if (downIndex < 0) {
        downIndex = belts.size() - 1;
      }

      // 2번 작업 로봇 이동
      for (Iterator<Robot> robotIterator = robots.iterator(); robotIterator.hasNext(); ) {
        Robot robot = robotIterator.next();
        if (robot.beltSpace == belts.get(downIndex)) {
          // 로봇 내리기
          robot.beltSpace.isRobot = false;
          robotIterator.remove();
        } else {
          BeltSpace nextBeltSpace = robot.beltSpace.nextBeltSpace;
          robot.move(nextBeltSpace);
        }
      }

      // 로봇 올리기
      if (!belts.get(upIndex).isRobot && belts.get(upIndex).health > 0) {
        robots.add(new Robot(belts.get(upIndex)));
      }

      // 내구도 검사
      if (zeroHealth.size() >= K) {
        break;
      }
      level++;
    }
    System.out.println(level);
  }
}

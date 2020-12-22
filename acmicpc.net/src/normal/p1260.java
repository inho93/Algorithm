package normal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/*
https://www.acmicpc.net/problem/1260
 */
public class p1260 {
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] line = br.readLine().split(" ");
    int index = 0;
    int n = Integer.parseInt(line[index++]);
    int m = Integer.parseInt(line[index++]);
    int v = Integer.parseInt(line[index++]);

    List<Node> nodes = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      nodes.add(new Node(i + 1));
    }

    for (int i = 0; i < m; i++) {
      String[] nodeLine = br.readLine().split(" ");
      int vertexOne = Integer.parseInt(nodeLine[0]);
      int vertexTwo = Integer.parseInt(nodeLine[1]);
      nodes.get(vertexOne - 1).add(nodes.get(vertexTwo - 1));
      nodes.get(vertexTwo - 1).add(nodes.get(vertexOne - 1));
    }


    List<Node> dfsSequence = new ArrayList<>();
    Node firstNode = nodes.get(v - 1);

    // dfs
    dfs(firstNode, dfsSequence);

    System.out.print(dfsSequence.get(0).no);
    dfsSequence.remove(0);
    for (Node node : dfsSequence) {
      System.out.print(" " + node.no);
    }
    System.out.println();

    // bfs
    Queue<Node> queue = new ArrayDeque<>();
    List<Node> bfsSequence = new ArrayList<>();
    for (Node node : nodes) {
      node.isVisited = false;
    }
    firstNode.isVisited = true;
    queue.add(firstNode);
    bfsSequence.add(firstNode);
    while (queue.size() != 0) {
      Node currentNode = queue.poll();
      while (true) {
        Node nextNode = currentNode.nextNotVisited();
        if (nextNode == null) {
          break;
        }
        nextNode.isVisited = true;
        queue.add(nextNode);
        bfsSequence.add(nextNode);
      }
    }

    System.out.print(bfsSequence.get(0).no);
    bfsSequence.remove(0);
    for (Node node : bfsSequence) {
      System.out.print(" " + node.no);
    }
  }

  private static void dfs(Node node, List<Node> dfsSequence) {
    if (!node.isVisited) {
      node.isVisited = true;
      dfsSequence.add(node);
      while(true) {
        Node nextNode = node.nextNotVisited();
        if (nextNode != null) {
          dfs(nextNode, dfsSequence);
        }
        else {
          break;
        }
      }
    }
  }

  private static class Node {
    int no;
    boolean isVisited;
    List<Node> connectNodes;

    public Node(int no) {
      this.no = no;
      isVisited = false;
      connectNodes = new ArrayList<>();
    }

    public void add(Node node) {
      connectNodes.add(node);
    }

    public Node nextNotVisited() {
      Node minNode = null;
      for (Node node : connectNodes) {
        if (node.isVisited) {
          continue;
        }
        else {
          if (minNode == null) {
            minNode = node;
          }
          else {
            if (minNode.no > node.no) {
              minNode = node;
            }
          }
        }
      }
      return minNode;
    }
  }
}

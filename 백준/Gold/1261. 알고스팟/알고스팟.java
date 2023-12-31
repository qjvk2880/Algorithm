import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node implements Comparable<Node> {
    int x, y;
    int minBreak;

    public Node(int x, int y, int minBreak) {
        this.x = x;
        this.y = y;
        this.minBreak = minBreak;
    }

    @Override
    public int compareTo(Node o) {
        return this.minBreak - o.minBreak;
    }
}

public class Main {
    public static int ans = Integer.MAX_VALUE;
    public static int n, m;
    public static char[][] input;
    public static boolean[][] visited;
    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, 1, 0, -1};


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = bf.readLine().split(" ");
        m = Integer.parseInt(tmp[0]);
        n = Integer.parseInt(tmp[1]);
        input = new char[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            input[i] = bf.readLine().toCharArray();
        }
        bfs();
        System.out.println(ans);

    }

    public static void bfs() {
        Queue<Node> q = new PriorityQueue<>();
        q.add(new Node(0, 0, 0));
        visited[0][0] = true;
        while (!q.isEmpty()) {
            Node current = q.remove();
            if (current.x == n - 1 && current.y == m - 1) {
                ans = current.minBreak;
                break;
            }
            for (int i = 0; i < 4; i++) {
                int newX = current.x + dx[i];
                int newY = current.y + dy[i];

                if (!(newX >= 0 && newX < n && newY >= 0 && newY < m)) {
                    continue;
                }
                if (visited[newX][newY]) {
                    continue;
                }

                int nextBreakNum = current.minBreak;
                if (input[newX][newY] == '1') {
                    nextBreakNum++;
                }

                q.add(new Node(newX, newY, nextBreakNum));
                visited[newX][newY] = true;
            }
        }
    }
}


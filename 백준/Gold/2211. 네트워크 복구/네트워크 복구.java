import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static ArrayList<Node>[] graph;
    static int[] dist;
    static int[] parent;
    static final int INF = Integer.MAX_VALUE;
    static StringTokenizer st;

    static class Node implements Comparable<Node> {
        int to, cost;

        Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a].add(new Node(b, c));
            graph[b].add(new Node(a, c));
        }

        dist = new int[N + 1];
        parent = new int[N + 1];
        Arrays.fill(dist, INF);

        dijkstra(1);

        StringBuilder sb = new StringBuilder();
        sb.append(N - 1).append("\n");

        for (int i = 2; i <= N; i++) {
            sb.append(parent[i]).append(" ").append(i).append("\n");
        }

        System.out.print(sb);
    }

    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[start] = 0;
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            int now = cur.to;
            int cost = cur.cost;

            if (dist[now] < cost) continue;

            for (int i = 0; i < graph[now].size(); i++) {
                Node nextNode = graph[now].get(i);

                int next = nextNode.to;
                int nextCost = cost + nextNode.cost;

                if (dist[next] > nextCost) {
                    dist[next] = nextCost;
                    parent[next] = now;
                    pq.offer(new Node(next, nextCost));
                }
            }
        }
    }
}
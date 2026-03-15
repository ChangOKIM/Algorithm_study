import java.io.*;
import java.util.*;

public class SWEA_4206 {

    static int T, N, M;
    static int[][] graph;
    static int[][] virusTime;
    static boolean[][] visited;

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++) {

            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            graph = new int[N][M];
            virusTime = new int[N][M];
            visited = new boolean[N][M];

            Deque<int[]> dq = new ArrayDeque<>();

            int sx = 0, sy = 0;

            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < M; j++) {

                    graph[i][j] = Integer.parseInt(st.nextToken());
                    virusTime[i][j] = Integer.MAX_VALUE;

                    if(graph[i][j] == 2) {
                        dq.addLast(new int[]{i,j});
                        virusTime[i][j] = 0;
                    }

                    if(graph[i][j] == 3) {
                        sx = i;
                        sy = j;
                    }
                }
            }

            // 바이러스 BFS
            while(!dq.isEmpty()) {

                int[] now = dq.pollFirst();
                int x = now[0];
                int y = now[1];

                for(int d = 0; d < 4; d++) {

                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                    if(graph[nx][ny] == 1) continue;

                    if(virusTime[nx][ny] > virusTime[x][y] + 1) {

                        virusTime[nx][ny] = virusTime[x][y] + 1;
                        dq.addLast(new int[]{nx,ny});
                    }
                }
            }

            // 사람 BFS
            dq.clear();
            dq.addLast(new int[]{sx,sy,0});
            visited[sx][sy] = true;

            boolean infected = false;
            int escapeTime = -1;

            while(!dq.isEmpty()) {

                int[] now = dq.pollFirst();

                int x = now[0];
                int y = now[1];
                int time = now[2];

                // 감염 체크
                if(time >= virusTime[x][y]) {
                    infected = true;
                    continue;
                }

                for(int d = 0; d < 4; d++) {

                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    // 탈출 성공
                    if(nx < 0 || ny < 0 || nx >= N || ny >= M) {
                        escapeTime = time + 1;
                        dq.clear();
                        break;
                    }

                    if(graph[nx][ny] == 1) continue;
                    if(visited[nx][ny]) continue;

                    if(time+1 >= virusTime[nx][ny]){
                        infected = true;
                        continue;
                    }

                    visited[nx][ny] = true;
                    dq.addLast(new int[]{nx,ny,time+1});
                }
            }

            // 결과 출력
            if(escapeTime != -1)
                System.out.println("#"+tc+" "+escapeTime);
            else if(infected)
                System.out.println("#"+tc+" ZOMBIE");
            else
                System.out.println("#"+tc+" CANNOT ESCAPE");
        }
    }
}
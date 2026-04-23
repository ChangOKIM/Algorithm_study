import java.util.*;
import java.io.*;

public class Main {
	static int T;
	static int M, N, K;
	static int cnt;
	static int[][] graph;
	static boolean[][] visited;
	static StringTokenizer st;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			graph = new int[N][M];
			visited = new boolean[N][M];
			
			cnt = 0;
			
			for(int i=0; i<K; i++) {
				st = new StringTokenizer(br.readLine());
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				graph[x][y] = 1;
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(graph[i][j] == 1 && !visited[i][j]) {
						bfs(i, j);
						cnt++;
					}
				}
			}
			
			System.out.println(cnt);
			
		}
	}
	
	static void bfs(int x, int y) {
		ArrayDeque<int[]> queue = new ArrayDeque<>();
		queue.addFirst(new int[] {x, y});
		visited[x][y] = true;
		
		while(!queue.isEmpty()) {
			int[] check = queue.pollFirst();
			int cx = check[0];
			int cy = check[1];
			
			for(int i=0; i<4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				
				if(0<= nx && nx<N && 0<=ny && ny<M) {
					if(!visited[nx][ny] && graph[nx][ny] == 1) {
						queue.addFirst(new int[] {nx, ny});
						visited[nx][ny] = true;
					}
				}
			}
		}
	}
	
	
	
}

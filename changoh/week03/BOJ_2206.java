import java.io.*;
import java.util.*;

public class BOJ_2206 {
    static int N, M;
    static int[][] map;
    static boolean[][][] visited;  //상태 저장을 위해 3차원 배열 활용
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static StringTokenizer st;
    
    static class Node{
    	int x, y, breakWall, dist;
    	
    	Node(int x, int y, int breakWall, int dist){
    		this.x = x;
    		this.y = y;
    		this.breakWall = breakWall;
    		this.dist = dist;
    	}
    }
    
    public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	st = new StringTokenizer(br.readLine());
    	
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	map = new int[N][M];
    	visited = new boolean[N][M][2];
    	
    	for(int i=0; i<N; i++) {
    		String s = br.readLine();
    		for(int j=0; j<M; j++) {
    			map[i][j] = s.charAt(j) - '0';
    		}
    	}
    	
    	System.out.println(bfs());
		
	}
    
    static int bfs() {
    	ArrayDeque<Node> queue = new ArrayDeque<>();
    	queue.add(new Node(0, 0, 0, 1));
    	visited[0][0][0] = true;
    	
    	while(!queue.isEmpty()) {
    		Node cur = queue.pollFirst();
    		
    		if(cur.x == N-1 && cur.y == M-1) {
    			return cur.dist;
    		}
    		
    		for(int i=0; i<4; i++) {
    			int nx = cur.x + dx[i];
    			int ny = cur.y + dy[i];
    			
				//map 범위를 만족하는 nx, ny중에서 
    			if(0<=nx && nx<N && 0<=ny && ny<M) {
					//1. 빈칸이라면 이동
    				if(map[nx][ny] == 0 && !visited[nx][ny][cur.breakWall]) {
    					visited[nx][ny][cur.breakWall] = true;
    					queue.add(new Node(nx, ny, cur.breakWall, cur.dist + 1));
    				}
    				
					//2. 벽인데 벽도 안 부순 상태(breakwall=0)이면 벽 부수고(visited[nx][ny][1] = true) 이동
    				if(map[nx][ny] == 1 && cur.breakWall == 0 && !visited[nx][ny][1]) {
    					visited[nx][ny][1] = true;
    					queue.add(new Node(nx, ny, 1, cur.dist + 1));
    				}
    			}
    		}
    	}
    	
    	return -1;
    }
    
}
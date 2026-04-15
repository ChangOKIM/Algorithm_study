import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int houseCnt, chickenCnt;
	static int[][] graph;
	static int[][] house;
	static int[][] chicken;
	static int[][] temp;
	static StringTokenizer st;
	static int minDistance;
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
				if(graph[i][j] == 1) houseCnt++;
				if(graph[i][j] == 2) chickenCnt++;
			}
		}
		
		house = new int[houseCnt][2];
		chicken = new int[chickenCnt][2];
		minDistance = Integer.MAX_VALUE;
		
		int houseIncrease = 0;
		int chickenIncrease = 0;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(graph[i][j] == 1) {
					house[houseIncrease][0] = i;
					house[houseIncrease][1] = j;
					houseIncrease++;
					
				}else if(graph[i][j] == 2) {
					chicken[chickenIncrease][0] = i;
					chicken[chickenIncrease][1] = j;
					chickenIncrease++;
				}
				
			}
		}
		
		temp = new int[M][2];
		
		dfs(0, 0);
		
		System.out.println(minDistance);
	}
	
	static void dfs(int init, int depth) {
		if(depth == M) {
			int result = checkDistance();
			if(result < minDistance) {
				minDistance = result;
			}
			return;
		}
		
		for(int i=init; i<chicken.length; i++) {
			temp[depth][0] = chicken[i][0];
			temp[depth][1] = chicken[i][1];
			
			dfs(i + 1, depth + 1);
		}
	}
	
	static int checkDistance() {
		int tempDistance = 0;
		for(int i=0; i<house.length; i++) {
			int eachDistance = Integer.MAX_VALUE;
			for(int j=0; j<M; j++) {
				int dst = Math.abs(temp[j][0] - house[i][0]) + Math.abs(temp[j][1] - house[i][1]);
				if(dst <eachDistance) {
					eachDistance = dst;
				}
			}
			tempDistance += eachDistance;
			if(tempDistance >minDistance) {
				return Integer.MAX_VALUE;
			}
		}

		return tempDistance;
	}
}

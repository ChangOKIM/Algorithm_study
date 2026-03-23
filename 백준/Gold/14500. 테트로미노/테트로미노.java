import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[][] graph;
	static int maxValue;
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		maxValue = Integer.MIN_VALUE;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(j<M-3) {
					int temp =0;
					for(int k=j; k<j+4; k++) {
						temp += graph[i][k];
					}
					maxValue = Math.max(maxValue, temp);
				}
				if(i<N-3) {
					int temp = 0;
					for(int k=0; k<4; k++) {
						temp += graph[i+k][j];
					}
					maxValue = Math.max(maxValue, temp);
				}
				if(i<N-1 && j<M-1) {
					int temp = 0;
					for(int k=0; k<2; k++) {
						for(int t=0; t<2; t++) {
							temp += graph[i+k][j+t];
						}
					}
					maxValue = Math.max(maxValue, temp);
				}
				if(i<N-2 && j<M-1) {
					int temp = 0;
					for(int k=0; k<3; k++) {
						for(int t=0; t<2; t++) {
							temp += graph[i+k][j+t];
						}
					}
					int check1 = temp - (graph[i][j+1] + graph[i+1][j+1]);
					int check2 = temp - (graph[i][j] + graph[i+1][j]);
					int check3 = temp - (graph[i][j+1] + graph[i+2][j]);
					int check4 = temp - (graph[i][j] + graph[i+2][j+1]);
					int check5 = temp - (graph[i][j+1] + graph[i+2][j+1]);
					int check6 = temp - (graph[i][j] + graph[i+2][j]);
					int check7 = temp - (graph[i+1][j+1] + graph[i+2][j+1]);
					int check8 = temp - (graph[i+1][j] + graph[i+2][j]);
					
					int[] arr = {check1, check2, check3, check4, check5, check6, check7, check8};
					for(int z=0; z<8; z++) {
						maxValue = Math.max(maxValue, arr[z]);
					}
				}
				if(i<N-1 && j<M-2) {
					int temp = 0;
					for(int k=0; k<2; k++) {
						for(int t=0; t<3; t++) {
							temp += graph[i+k][j+t];
						}
					}
					int check1 = temp - (graph[i][j+1] + graph[i][j+2]);
					int check2 = temp - (graph[i][j] + graph[i][j+1]);
					int check3 = temp - (graph[i][j+2] + graph[i+1][j]);
					int check4 = temp - (graph[i][j] + graph[i+1][j+2]);
					int check5 = temp - (graph[i+1][j] + graph[i+1][j+2]);
					int check6 = temp - (graph[i][j] + graph[i][j+2]);
					int check7 = temp - (graph[i+1][j+1] + graph[i+1][j+2]);
					int check8 = temp - (graph[i+1][j] + graph[i+1][j+1]);
					
					int[] arr = {check1, check2, check3, check4, check5, check6, check7, check8};
					for(int z=0; z<8; z++) {
						maxValue = Math.max(maxValue, arr[z]);
					}
				}
			}
		}
		
		System.out.println(maxValue);
		
	}
}
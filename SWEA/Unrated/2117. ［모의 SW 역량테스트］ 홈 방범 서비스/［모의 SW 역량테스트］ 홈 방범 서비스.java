/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
// g = sc.nextByte();                          // char 변수 1개 입력받는 예제
// var = sc.next();                            // 문자열 1개 입력받는 예제
// AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;                            
// double b = 1.0;               
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int 변수 1개 출력하는 예제
//System.out.println(b); 		       						 // double 변수 1개 출력하는 예제
//System.out.println(g);		       						 // char 변수 1개 출력하는 예제
//System.out.println(var);		       				   // 문자열 1개 출력하는 예제
//System.out.println(AB);		       				     // long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
import java.util.*;
import java.io.*;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
	static int T;
    static int N, M;
    static int[][] graph;
    static int[][] house;
    static int maxIncome, init;
    static int answer;
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            graph = new int[N][N];
            int houseCnt = 0;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    graph[i][j] = Integer.parseInt(st.nextToken());
                    if (graph[i][j] == 1) {
                        houseCnt++;
                    }
                }
            }

            house = new int[houseCnt][2];

            int houseIdx = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (graph[i][j] == 1) {
                        house[houseIdx][0] = i;
                        house[houseIdx][1] = j;
                        houseIdx++;
                    }
                }
            }

            maxIncome = houseCnt * M;
            answer = 0;
            init = 0;

            while (true) {
                init++;
                int cost = init * init + (init - 1) * (init - 1);

                if (cost > maxIncome) {
                    break;
                }

                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        int count = checkHouse(i, j, init);
                        if (count * M >= cost) {
                            answer = Math.max(answer, count);
                        }
                    }
                }
            }

            System.out.println("#" + tc + " " + answer);
        }
    }

    static int checkHouse(int x, int y, int k) {
        int count = 0;

        for (int i = 0; i < house.length; i++) {
            int dist = Math.abs(house[i][0] - x) + Math.abs(house[i][1] - y);
            if (dist < k) {
                count++;
            }
        }

        return count;
    }
}
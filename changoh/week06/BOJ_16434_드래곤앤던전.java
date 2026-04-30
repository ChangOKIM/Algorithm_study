package personalArea;

import java.util.*;
import java.io.*;

public class BOJ_16434_드래곤앤던전 {
	static int N;
    static long Hatk;
    static long[][] rooms;
    
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        Hatk = Long.parseLong(st.nextToken());

        rooms = new long[N][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            rooms[i][0] = Long.parseLong(st.nextToken());
            rooms[i][1] = Long.parseLong(st.nextToken());
            rooms[i][2] = Long.parseLong(st.nextToken());
        }

        long left = 1;
        long right = Long.MAX_VALUE / 2;
        long answer = right;

        while (left <= right) {
            long mid = (left + right) / 2;

            if (canClear(mid)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(answer);
    }

    static boolean canClear(long maxHp) {
        long curHp = maxHp;
        long atk = Hatk;

        for (int i = 0; i < N; i++) {
            long t = rooms[i][0];
            long a = rooms[i][1];
            long h = rooms[i][2];

            if (t == 1) {
                long monsterAtk = a;
                long monsterHp = h;

                long hit = (monsterHp - 1) / atk;
                curHp -= hit * monsterAtk;

                if (curHp <= 0) {
                    return false;
                }
            } else {
                atk += a;
                curHp = Math.min(maxHp, curHp + h);
            }
        }

        return true;
    }
	
}


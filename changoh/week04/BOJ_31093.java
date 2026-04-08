import java.io.*;
import java.util.*;

public class BOJ_31093 {
    static int N, K;
    static char[] s;

    static long A, B, Z, C, D;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        s = br.readLine().toCharArray();

        classify();

        StringBuilder sb = new StringBuilder();
        long beauty = 2L * Z;
        sb.append(beauty).append('\n'); // 0번 교환

        for (int step = 1; step <= K; step++) {
            if (canType1()) {
                doType1();
                beauty += 4;
            } else if (canType2or3()) {
                doType2or3();
                beauty += 2;
            }
            sb.append(beauty).append('\n');
        }

        System.out.print(sb);
    }

    static void classify() {
        int half = N / 2;

        for (int i = 0; i < half; i++) {
            char l = s[i];
            char r = s[N - 1 - i];

            if (l == '3' && r == '3') A++;
            else if ((l == '2' && r == '3') || (l == '3' && r == '2')) B++;
            else if ((l == '2' && r == '2') || (l == '3' && r == 'E') || (l == 'E' && r == '3')) Z++;
            else if ((l == '2' && r == 'E') || (l == 'E' && r == '2')) C++;
            else if (l == 'E' && r == 'E') D++;
        }
    }

    static boolean canType1() {
        return (A > 0 && D > 0) || (B > 0 && C > 0);
    }

    static void doType1() {
        if (A > 0 && D > 0) {
            A--;
            D--;
            Z += 2;
        } else {
            B--;
            C--;
            Z += 2;
        }
    }

    static boolean canType2or3() {
        return (B > 0 && D > 0) || (A > 0 && C > 0) || (B >= 2) || (C >= 2);
    }

    static void doType2or3() {
        //-1, +2 -> 0, +1
        if (B > 0 && D > 0) {
            B--;
            D--;
            Z++;
            C++;
            return;
        }

        //+1, -2 -> 0, -1
        if (A > 0 && C > 0) {
            A--;
            C--;
            Z++;
            B++;
            return;
        }

        //-1, -1 -> 0, -2
        if (B >= 2) {
            B -= 2;
            Z++;
            A++;
            return;
        }

        //+1, +1 -> 0, +2
        C -= 2;
        Z++;
        D++;
    }
}
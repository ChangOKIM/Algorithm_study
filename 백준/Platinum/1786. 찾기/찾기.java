import java.io.*;
import java.util.*;

public class Main {
    static String T;
    static String P;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = br.readLine();
        P = br.readLine();

        int[] pi = getPi(P);
        List<Integer> list = new ArrayList<>();

        int j = 0;
        for (int i = 0; i < T.length(); i++) {
            while (j > 0 && T.charAt(i) != P.charAt(j)) {
                j = pi[j - 1];
            }

            if (T.charAt(i) == P.charAt(j)) {
                if (j == P.length() - 1) {
                    list.add(i - P.length() + 2);
                    j = pi[j];
                } else {
                    j++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(list.size()).append('\n');
        for (int pos : list) {
            sb.append(pos).append(' ');
        }

        System.out.println(sb);
    }

    static int[] getPi(String p) {
        int[] pi = new int[p.length()];
        int j = 0;

        for (int i = 1; i < p.length(); i++) {
            while (j > 0 && p.charAt(i) != p.charAt(j)) {
                j = pi[j - 1];
            }

            if (p.charAt(i) == p.charAt(j)) {
                pi[i] = ++j;
            }
        }

        return pi;
    }
}
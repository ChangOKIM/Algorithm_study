package week07;

import java.util.*;

public class PG_42884_1{
    public int solution(int[][] routes) {
        Arrays.sort(routes, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return Integer.compare(o1[1], o2[1]);
            }
            return Integer.compare(o1[0], o2[0]);
        });

        int answer = 1;
        int camera = routes[0][1];

        for (int i = 1; i < routes.length; i++) {
            if (routes[i][0] <= camera) {
                camera = Math.min(camera, routes[i][1]);
            } else {
                answer++;
                camera = routes[i][1];
            }
        }

        return answer;
    }
}
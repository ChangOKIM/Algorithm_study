package week07;

import java.util.*;

public class PG_42884_2 {
	public int solution(int[][] routes) {
		List<Integer> list = new ArrayList<>();

		Arrays.sort(routes, (o1, o2) -> {
			if (o1[1] == o2[1]) {
				return Integer.compare(o1[0], o2[0]); 
			}
			return Integer.compare(o1[1], o2[1]); 
		});
		int answer = 0;

		list.add(routes[0][1]);
		System.out.println(Arrays.deepToString(routes));
		for (int i = 1; i < routes.length; i++) {
			int size = list.size();
			if (list.get(size - 1) < routes[i][0]) {
				list.add(routes[i][1]);
			}
		}
		System.out.println(list);

		return answer = list.size();
	}
}
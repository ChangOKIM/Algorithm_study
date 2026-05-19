package week09;

/*
h번 이상 인용 h편 이상 나머지는 h번 이하 인용 
3가지 조건이 모두 만족하는 h값

최종 구해야하는 값 h

조건 1) h번 이상 2) 1 이상 h편 이상  3) 나머지 h번 이하 인용

가장 먼저 배열을 정렬하고 문제를 풀이하는 것이 이득이라고 판단

*/
import java.util.*;

public class PG_42747_1 {
	public int solution(int[] citations) {
		int num = 0;
		int h = -1;
		int ex = 0;
		int cnt = 0;
		Arrays.sort(citations);

		int len = citations.length / 2; // 중간값
		num = citations.length - len;// citations[len]보다 크거나 같은 값이 몇개인가?
		h = citations[len] > num ? num : citations[len];
		while (len != 0) {
			int tempL = 0;
			int tempN = 0;
			int tempH = 0;
			ex = h;
			if (citations[len] > num) {
				tempL = len - 1;
				tempN = num + 1;
				tempH = citations[tempL] > tempN ? tempN : citations[tempL];
				if (tempH > h) {
					len--;
				} else {
					break;
				}

			} else if (citations[len] > num) {
				tempL = len + 1;
				tempN = num - 1;
				tempH = citations[tempL] > tempN ? tempN : citations[tempL];
				if (tempH > h) {
					len++;
				} else {
					break;
				}
			}
			h = citations[len] > num ? num : citations[len];
			num = citations.length - len;
			if (ex == h)
				cnt++;
			if (cnt > 1)
				break;
		}

		return citations[len] > num ? num : citations[len];
	}
}
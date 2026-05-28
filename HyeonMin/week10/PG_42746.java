package week10;

import java.util.*;

public class PG_42746 {
	public String solution(int[] numbers) {
		String answer = "";
		String[] arr = new String[numbers.length];

		for (int i = 0; i < numbers.length; i++) {
			arr[i] = "" + numbers[i];
		}

		Arrays.sort(arr, (o1, o2) -> {
			String s1 = o1 + o2;
			String s2 = o2 + o1;

			return s1.compareTo(s2);

		});
		if (arr[numbers.length - 1].equals("0"))return "0";
		
		for (int i = numbers.length - 1; i >= 0; i--)answer += arr[i];
		
		return answer;
	}
}
package week09;

import java.util.*;
public class PG_42747_2 {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        
        for(int i=citations.length-1;i>=0;i--){
            if(citations[i]>answer)answer++;
            else break;
        }
        return answer;
    }
}
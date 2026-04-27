package week06;

import java.util.*;

public class PG_43165_1 {
    public int cnt=0;
    public int solution(int[] numbers, int target) {
        int answer = 0;
        
        dfs(0,0,numbers,target);
        
        return answer=cnt;
    }
    public void dfs(int sum,int depth,int numbers[],int target){
        if(depth==numbers.length){
            if(target==sum)cnt++;
            return;
        }
        dfs(sum-numbers[depth],depth+1,numbers,target);
        dfs(sum+numbers[depth],depth+1,numbers,target);
        
    }

}

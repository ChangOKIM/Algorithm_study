package week08;

import java.util.*;
public class PG_42895 {
    public int solution(int N, int number) {
        List<Set<Integer>> list=new ArrayList<>();
        for(int i=0;i<=9;i++)list.add(new HashSet<>());
    
        list.get(1).add(N);
        int answer = -1;
        
        
        for(int i=2;i<=9;i++){
            if(list.get(i-1).contains(number)){
                answer=i-1;
                break;
            }
            for(int j=0;j<=i;j++){
                for(int a:list.get(i-j)){
                    for(int b:list.get(j)){
                        list.get(i).add(a*b);
                        if(b!=0)list.get(i).add(a/b);
                        list.get(i).add(a+b);
                        list.get(i).add(a-b);
                    }
                }
            }
            int rep=0;
            for(int k=0;k<i;k++){
                rep=rep*10+N;
            }
            list.get(i).add(rep);

        }
        
        
        
        return answer;
    }
}
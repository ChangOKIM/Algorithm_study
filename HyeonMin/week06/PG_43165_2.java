package week06;

public class PG_43165_2 {
    public boolean visited[][];
    public int cnt=0;
    public int sum[];
    public int solution(int[] numbers, int target) {
        int answer = 0;
        visited=new boolean[numbers.length][2]; // - + 
        sum=new int[numbers.length];
        
        dfs(0,0,numbers,target);
        
        return answer=cnt;
    }
    public void dfs(int x,int depth,int numbers[],int target){
        if(depth==numbers.length){
            int total=0;
            for(int i=0;i<depth;i++){
                total+=sum[i];
            }
            //System.out.println(total);
            if(total==target)cnt++;
            return;
        }
        

            for(int j=0;j<2;j++){
                if(!visited[depth][j]){
                    int temp=1;
                    visited[depth][j]=true;
                    if(j==0)temp=-1;
                    sum[depth]=temp*numbers[depth];
                    dfs(x+1,depth+1,numbers,target);
                    visited[depth][j]=false;

                }
            }
        
        
        
        
    }
}
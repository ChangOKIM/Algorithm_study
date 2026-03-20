package week02;

import java.util.*;

public class BOJ_14500{
public static int sum[]=new int[4];
public static int paper[][];
public static boolean visited[][];
public static int max=0;
public static void main(String args[]){
    Scanner s=new Scanner(System.in);
    
    int n=s.nextInt();
    int m=s.nextInt();
    paper=new int[n][m];
    visited=new boolean[n][m];
    
    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            paper[i][j]=s.nextInt();
        }
    }
    exce();
    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            dfs(j,i,0);
        }
    }
    
    System.out.print(max);
}
public static void dfs(int x,int y,int depth){
    if(depth==4){
        int sumTotal=0;
        for(int i=0;i<4;i++)sumTotal+=sum[i];
        max=sumTotal>max?sumTotal:max;
        return;
    }
    
    int dx[]={0,0,-1,1};
    int dy[]={-1,1,0,0};

    for(int i=0;i<4;i++){
        int nx=x+dx[i];
        int ny=y+dy[i];
        if(nx>=0&&nx<paper[0].length&&ny>=0&&ny<paper.length){
            if(!visited[ny][nx]){
                visited[ny][nx]=true;
                sum[depth]=paper[ny][nx];
                dfs(nx,ny,depth+1);
                visited[ny][nx]=false;
            }
        }
    }
}

public static void exce(){
    
    int temp[]=new int[4];
    int dx[]={0,0,-1,1};
    int dy[]={-1,1,0,0};
    for(int i=0;i<paper.length;i++){
        for(int j=0;j<paper[0].length;j++){
            int sum=paper[i][j];
            int cnt=0;
            Arrays.fill(temp,0);
            for(int k=0;k<4;k++){
                int nx=j+dx[k];
                int ny=i+dy[k];
                if(nx>=0&&nx<paper[0].length&&ny>=0&&ny<paper.length){
                    temp[k]=paper[ny][nx];
                    cnt++;
                }
            }
            
            int tempSum=paper[i][j];
            if(cnt==3){
                for(int l=0;l<4;l++){
                    sum+=temp[l];
                }
                max=max>sum?max:sum;
            }
            else if(cnt==4){
                for(int l=0;l<4;l++){
                    tempSum+=temp[l];
                }
                for(int l=0;l<4;l++){
                    max=tempSum-temp[l]>max?tempSum-temp[l]:max;
                }
            }
        }
    }
}
}
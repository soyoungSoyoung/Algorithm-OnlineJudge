import java.util.*;

class Solution {
    static int[] dx = {1,0,0,-1}; //하좌우상
    static int[] dy = {0,-1,1,0};
    static char[] dir = {'d', 'l', 'r', 'u'}; //사전 순 배치
    static String answer = "";
    static int n,m,x,y,r,c,k;
    static boolean found = false; //dfs에서 답 찾으면, true로 변경 후 더 못 돌게 하기 위한 변수
    
    public String solution(int N, int M, int X, int Y, int R, int C, int K) {
        n=N; m=M; x=X; y=Y; r=R; c=C; k=K;
        //1. S~E의 거리 > 이동 횟수(k) 이면, 볼 것도 없이 못 감
        if(manhattan(x,y, r,c) > k) return "impossible";
        
        //가능하다면, 일단 사전 순으로 목표 지점까지 움직여놓기
        //순서는 "하좌우상"
        //while(x < r && k>0) {
        //    answer += "d";
        //    x++;
        //    k--;
        //}
        //while(y > c && k>0) {
        //    answer += "l";
        //    y--;
        //    k--;
        //}
       // while(y < c && k>0) {
        //    answer += "r";
        //    y++;
        //    k--;
        //}
        //while(x > r && k>0) {
        //    answer += "u";
         //   x--;
        //    k--;
        //}
        
        //움직임이 남은 횟수(k)가 홀수라면, 갈 방법이 없음.
        if((k-manhattan(x,y, r,c))%2 != 0) return "impossible";
        
        //아니라면(남은 횟수가 짝수라면), dfs를 돌리든 해서 가면 됨.
        //움직임 남은 수, 현재위치좌표, 답(4방 탐색을 사전순으로 하니까 맨 처음 나오는 문자열 더하면 됨)
        dfs(k, x,y, "");
        return answer;
    }
    
    static void dfs(int remainMove, int x,int y, String answer2) {
        //시간초과 방지용
        if(found) return;
        
        //찾으면 갱신
        if(remainMove==0 && x==r && y==c) {
            answer += answer2;
            found = true;
            return;
        }
        
        //
        for(int d=0; d<4; d++) {
            int nx = dx[d] + x;
            int ny = dy[d] + y;
            
            if(nx<=0 || nx>n || ny<=0 || ny>m) continue;
            
            if(manhattan(nx,ny, r,c) <= remainMove-1) {
                dfs(remainMove - 1, nx,ny, answer2+dir[d]);
            }
        }
    }
    
    static int manhattan(int x,int y, int r,int c) {
        return Math.abs(x-r) + Math.abs(y-c);
    }
}

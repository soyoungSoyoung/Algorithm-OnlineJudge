import java.util.*;

class Solution {
    int[] dx = {-1,1,0,0};
    int[] dy = {0,0,-1,1};
    int n,m;
    int Gx, Gy, Rx, Ry;
    int[][] dp;
    
    public int solution(String[] board) {
        n = board.length;
        m = board[0].length();
        
        dp = new int[n][m];
        for(int[] d : dp){
            Arrays.fill(d, Integer.MAX_VALUE);
        }
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(board[i].charAt(j) == 'G') {
                    Gx = i; Gy = j;
                }
                if(board[i].charAt(j) == 'R') {
                    Rx = i; Ry = j;
                }
            }
        }
        dp[Rx][Ry] = 0;
        //System.out.println(n+" "+m+" "+Gx+" "+Gy);
        
        //G주변 4방에 벽이나 D가 하나도 없어서 멈출 수 없음
        if(cannotEnd(board))
            return -1;
        
        int answer = bfs(board);
        return answer;
    }
    
    public int bfs(String[] board) {
        Queue<int[]> pq = new PriorityQueue<>((o1,o2) -> o1[2] - o2[2]);
        pq.add(new int[] {Rx, Ry, 0}); //좌표2, 움직인 횟수
        
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            int x = cur[0];
            int y = cur[1];
            int move = cur[2];
            
            if(x==Gx && y==Gy)
                return move;
            
            for(int d=0; d<4; d++) {
                int[] nxy = slide(d, x, y, board);
                
                if(nxy[0]==-1 || nxy[1]==-1) continue;
                
                if(move + 1 < dp[nxy[0]][nxy[1]]) {
                    dp[nxy[0]][nxy[1]] = move + 1;
                    pq.add(new int[] {nxy[0], nxy[1], move + 1});
                }
                
            }
        }
        return -1; //!
    }
    
    public int[] slide(int d, int x, int y, String[] board) {
        int nx = x + dx[d];
        int ny = y + dy[d];
        
        //움직일 수 없는 방향
        if(outOfBoard(nx, ny) || board[nx].charAt(ny) == 'D')
            return new int[] {-1, -1};
        
        while(true) {
            nx += dx[d];
            ny += dy[d];
            
            if(outOfBoard(nx, ny) || board[nx].charAt(ny) == 'D') {
                break;
            }
        }
        
        if(nx == x)
            return new int[] {nx, ny - dy[d]};
        else 
            return new int[] {nx - dx[d], ny};
    }
    
    public boolean cannotEnd(String[] board) {
        for(int d=0; d<4; d++) {
            int nx = Gx + dx[d];
            int ny = Gy + dy[d];
            
            if(outOfBoard(nx, ny))
                return false;
            if(board[nx].charAt(ny) == 'D')
                return false;
        }
        return true;
    }
    
    public boolean outOfBoard(int nx, int ny) {
        if(nx<0 || nx>=n || ny<0 || ny>=m)
            return true;
        return false;
    }
}
import java.util.*;
import java.io.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] map = new int[n][m];
        //웅덩이 표시
        for(int[] puddle : puddles) {
            map[puddle[1]-1][puddle[0]-1] = -1;
        }
        
        //최단거리로 가생이 가는 방법 하나뿐
        for(int i=1; i<m; i++){
            if(map[0][i] == -1) break;
            map[0][i] = 1;
        }
        for(int i=1; i<n; i++){
            if(map[i][0] == -1) break;
            map[i][0] = 1;
        }
        
        //
        for(int i=1; i<n; i++){
            for(int j=1; j<m; j++) {
                int left = map[i][j-1];
                int top = map[i-1][j];
                
                if(map[i][j]== -1) continue;
                
                if(left == -1) {
                    map[i][j] = top;
                }
                else if(top == -1) {
                    map[i][j] = left;
                }
                else {
                    map[i][j] = (left+top) % 1000000007;
                }
            }
        }
        //
        
        return map[n-1][m-1] % 1000000007;
    }
}
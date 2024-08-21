import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[][] sizes) {
        int max=0;
        int min=0;
        
        for(int i=0; i<sizes.length; i++){
            int r = Math.max(sizes[i][0], sizes[i][1]);
            int c = Math.min(sizes[i][0], sizes[i][1]);
            
            max = Math.max(max, r);
            min = Math.max(min, c);
        }
        
        return max*min;
    }
}
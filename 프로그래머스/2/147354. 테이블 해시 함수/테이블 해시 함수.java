import java.util.*;

class Solution {
    static Map<Integer, Integer> map = new HashMap<>();
    
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        data = sorting(data, col-1);
        //System.out.println(map);
        for(int i=row_begin-1; i<=row_end-1; i++) {
            int[] da = data[i];
            int sum = 0;
            for(int d : da) {
                sum += (d % (i+1));
            }
            
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        //System.out.println(map);
        return cal();
    }
    
    static int cal() {
        int answer = 0;
        
        for(int key : map.keySet()) {
            if(map.get(key) % 2 == 0) // A XOR A == 0
                continue;
                //System.out.println("ww");
            
            answer = answer ^ key;
            //System.out.println("ww");
        }
        
        return answer;
    }
    
    static int[][] sorting(int[][] data, int col) {
        Arrays.sort(data, (o1, o2) -> {
            if(o1[col] == o2[col]) return o2[0] - o1[0];
            return o1[col] - o2[col];
        });
        //for(int[] d : data) System.out.println(Arrays.toString(d));
        return data;
    }
}
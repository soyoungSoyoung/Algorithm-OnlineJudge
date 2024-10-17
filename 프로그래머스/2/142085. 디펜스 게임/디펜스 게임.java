import java.util.*;

class Solution {
    int allRound;
    Queue<Integer> 에너미 = new PriorityQueue<>((o1,o2) -> o2-o1);
    
    public int solution(int n, int k, int[] enemy) {
        allRound = enemy.length;
        
        if(allRound <= k)  //무적권으로 다 치울 수 있으면 그냥 리턴
            return allRound;
        
        int round = 0;
        while(round < allRound) {
            에너미.add(enemy[round]);
            n -= enemy[round];
            if(n < 0) {
                if(k <= 0) 
                    break;
                while(k > 0) {
                    k--;
                    n += 에너미.poll();
                    if(n >= 0)
                        break;
                }
                if(n < 0)
                    break;
            }
            round++;
        }
        
        return round;
    
    }
}
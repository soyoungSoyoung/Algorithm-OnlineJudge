import java.util.*;

class Solution {
    Queue<int[]> pq = new PriorityQueue<>((o1,o2) -> {
        //{다이아, 철, 돌, 총개수}
        //if(o1[3] != o2[3]) return o2[3] - o1[3];
        if(o1[0] != o2[0]) return o2[0] - o1[0];
        return o2[1] - o1[1];
        //return o2[2] - o1[2];
    });
    int answer = 0;
    
    public int solution(int[] picks, String[] minerals) {
        int allPicks = (picks[0]+picks[1]+picks[2]) *5;
        int canPick = Math.min(allPicks, minerals.length);
        
        for(int i=0; i<canPick; i+=5) {
            int[] mineral = {0,0,0, 0};
            int end = Math.min(i+5, canPick);
            for(int j=i; j<end; j++) {
                if(minerals[j].equals("diamond")) mineral[0]++;
                else if(minerals[j].equals("iron")) mineral[1]++;
                else mineral[2]++;
                mineral[3]++;
            }
            pq.add(mineral);
        }
        
        //다이아->철->돌 곡괭이로 캐기
        while(!pq.isEmpty()) {
            int[] mm = pq.poll();
            if(picks[0] > 0) {
                picks[0]--;
                answer += mm[0]*1 + mm[1]*1 + mm[2]*1;
            }
            else if(picks[1] > 0) {
                picks[1]--;
                answer += mm[0]*5 + mm[1]*1 + mm[2]*1;
            } else {
                picks[2]--;
                answer += mm[0]*25 + mm[1]*5 + mm[2]*1;
            }
        }
        
        return answer;
    }
}
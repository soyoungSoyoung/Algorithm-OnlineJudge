import java.util.*;

class Solution {
    static Stack<Integer> order = new Stack<>();
    static Stack<Integer> workSpeed = new Stack<>();
    
    public int[] solution(int[] progresses, int[] speeds) {
        for(int i=speeds.length-1; i>=0; i--) {
            order.push(progresses[i]);
            workSpeed.push(speeds[i]);
        }
        
        int days = -1;
        int cnt = 0; //한 번 배포할 때, 배포 가능한 갯수
        ArrayList<Integer> answer = new ArrayList<>();
        while(!order.isEmpty()) {
            int firstOrder = order.pop();
            int firstSpeed = workSpeed.pop();
            
            if(days == -1) {
                days = (100 - firstOrder) / firstSpeed;
                if(days * firstSpeed < 100 - firstOrder)
                    days++;
                cnt++;
            }
            else {
                if(days * firstSpeed >= 100 - firstOrder)
                    cnt++;
                else {
                    answer.add(cnt);
                    
                    cnt = 0;
                    days = days = (100 - firstOrder) / firstSpeed;
                    if(days * firstSpeed < 100 - firstOrder)
                        days++;
                    cnt++;
                }
            }
        } 
        answer.add(cnt);
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
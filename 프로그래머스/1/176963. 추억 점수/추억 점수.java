import java.util.*;
class Solution {
    Map<String, Integer> score = new HashMap<>();
    int nLen, len;
    
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        nLen = name.length;
        len = photo.length;
        
        init(name, yearning);
        
        int[] answer = new int[len];
        for(int i=0; i<len; i++) {
            for(int j=0; j<photo[i].length; j++) {
                answer[i] += score.containsKey(photo[i][j]) ? score.get(photo[i][j]) : 0;
            }
        }
        return answer;
    }
    
    public void init(String[] name, int[] yearning) {
        for(int i=0; i<nLen; i++) {
            score.put(name[i], yearning[i]);
        }
        System.out.println(score);
    }
}
import java.util.*;
//1번: 1 2 3 4 5 반복
//2번: 2 1 2 3 2 4 2 5 반복
//3번: 3 3 1 1 2 2 4 4 5 5 반복
class Solution {
    static int[][] a = new int[4][];
    // static int[] a1 = new int {1,2,3,4,5};
    // static int[] a2 = new int {2,1,2,3,2,4,2,5};
    // static int[] a3 = new int {3,3,1,1,2,2,4,4,5,5};
    
    public int[] solution(int[] answers) {
        a[1] = new int[] {1,2,3,4,5};
        a[2] = new int[] {2,1,2,3,2,4,2,5};
        a[3] = new int[] {3,3,1,1,2,2,4,4,5,5};
        
        int[] answerCnt = new int[4];
        for(int i=1; i<4; i++) {
            answerCnt[i] = cntCorrect(answers, a[i]);
        }
        // System.out.println(Arrays.toString(answerCnt));
        int max = answerCnt[1];
        ArrayList<Integer> answer = new ArrayList<>();
        answer.add(1);
        for(int i=2; i<4; i++) {
            if(max == answerCnt[i])
                answer.add(i);
            if(max < answerCnt[i]) {
                max = answerCnt[i];
                answer.clear();
                answer.add(i);
            }
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    
    static int cntCorrect(int[] answers, int[] jjik) {
        int correct = 0;
        
        int size = jjik.length;
        int idx = 0;
        for(int i=0; i<answers.length; i++) {
            if(answers[i] == jjik[idx]) correct++;
            idx = (idx+1) % size;
        }
        
        return correct;
    }
}
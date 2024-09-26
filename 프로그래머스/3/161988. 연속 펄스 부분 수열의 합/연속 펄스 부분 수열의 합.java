import java.util.*;

class Solution {
    static long[] pSequence, mSequence, pDp, mDp;
    
    public long solution(int[] sequence) {
        init(sequence);
        
        pDp[0] = pSequence[0];
        mDp[0] = mSequence[0];
        for(int i=1; i<sequence.length; i++) {
            pDp[i] = Math.max(pSequence[i], pDp[i-1] + pSequence[i]);
            mDp[i] = Math.max(mSequence[i], mDp[i-1] + mSequence[i]);
        }
        long answer = Long.MIN_VALUE;
        for(int i=0; i<sequence.length; i++) {
            answer = Math.max(pDp[i], Math.max(answer, mDp[i]));
        }
        //System.out.println(Arrays.toString(pDp));
        //System.out.println(Arrays.toString(mDp));
        return answer;
    }
    
    static void init(int[] sequence) {
        pSequence = new long[sequence.length];
        mSequence = new long[sequence.length];
        pDp = new long[sequence.length];
        mDp = new long[sequence.length];
        
        long gop = 1;
        for(int i=0; i<sequence.length; i++) {
            pSequence[i] = sequence[i] * gop;
            gop *= -1;
            mSequence[i] = sequence[i] * gop;
        }
        
        //System.out.println(Arrays.toString(pSequence));
        //System.out.println(Arrays.toString(mSequence));
    }
}
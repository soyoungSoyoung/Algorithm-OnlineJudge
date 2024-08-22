import java.util.*;

class Solution {
    static Set<Integer> origin, addition;
    
    public int solution(int coin, int[] cards) {
        int answer = 0;
        int result = cards.length + 1;
        
        origin = new HashSet<>();
        addition = new HashSet<>();
        
        int cardIdx = 0;
        for(cardIdx=0; cardIdx<cards.length/3; cardIdx++) {
            origin.add(cards[cardIdx]);
        }
        
        //게임 순서 2. 게임진행            
        while(true) {
            answer++; //answer(=라운드) 1증가 시키기
            
            //종료 조건1: 카드 뭉치x = cardIdx >= cardCnt가 되면
            if(cardIdx >= cards.length) break;
            
            addition.add(cards[cardIdx++]);
            addition.add(cards[cardIdx++]);
            
            boolean goNext = false;
            //1. origin에서 result를 만들기
            for(int card : origin) {
                if(origin.contains(result - card)) {
                    origin.remove(card);
                    origin.remove(result - card);
                    goNext = true;
                    break;
                }
            }
            
            //2. ㄴ origin 하나와 addition 하나에서 result 만들기(coin-1)
            if(!goNext) {
                if(coin > 0) {
                    for(int card : addition) {
                        if(origin.contains(result - card)) {
                            addition.remove(card);
                            origin.remove(result - card);
                            goNext = true;
                            coin -= 1;
                            break;
                        }
                    }
                }
            }
            
            //3. ㄴ ㄴ addition 두 개로 result 만들기 (coin-2)
            if(!goNext) {
                if(coin > 1) {
                    for(int card : addition) {
                        if(addition.contains(result - card)) {
                            addition.remove(card);
                            addition.remove(result - card);
                            goNext = true;
                            coin -= 2;
                            break;
                        }
                    }
                }
            }
            
            //종료 조건2: result를 만들 수 있는 쌍이 없음. 껙
            if(!goNext) break;
            // addition.clear(); -> 지워야 하는 이유??
                //ㄴ 진행 조건 2.때문에 안 지우는 듯하다
                //ㄴ 1번 예시에서 10은 사용하기 때문에 바로 가져가야 함
                //ㄴ 하지만 1카드는 나중에 사용되기 때문에 나중을 위해서 미리 가져야 함
                //clear때리면 위의 경우를 찾을 수 없으니까 문제가 됨.
            //그럼 진행 조건 3.에서 문제가 터지지 않을까?
                //어짜피 제한된 코인으로 써야 하기 때문에 괜춘
            // System.out.println(answer+"번째 라운드: "+addition);
        }
        
        return answer;
    }
}
import java.util.Arrays;

class Solution {
    public int solution(int k, int m, int[] score) { //k점이 최상품, m개의 사과, score는 점수
        int answer = 0;
        
        Arrays.sort(score);
        
        int p=0;  //최소금액
        for(int i=score.length%m; i<score.length; i+=m){
            p=score[i];
            for(int j=i; j<i+m; j++){
               if(p>score[j]) p=score[j];
           }
            answer+=p*m;
        }
        
        return answer;
    }
}
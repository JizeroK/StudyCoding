class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        answer=new int[s.length()];
        
        for(int i=0; i<s.length(); i++){
           Loop1:for(int j=i; j>=0; j--){
                    if(j==i){
                        answer[i]=-1; //첫글자는 무조건 -1
                        continue;
                    }
                    else{
                        if(s.charAt(i)==s.charAt(j)){
                            System.out.println(i+","+j);
                            answer[i]=i-j;
                            break Loop1;
                        }
                    }
           }
        }
        
        return answer;
    }
}

import java.util.ArrayList;

class Solution {
    public String solution(String X, String Y) {
        String answer = "";
        int numX[] = new int[10];  //0~9
        int numY[] = new int[10];  //0~9
        
        int tmpX=Integer.parseInt(X);
        int tmpY=Integer.parseInt(Y);
        int n=0;
        
        while(tmpX!=0){
            n=tmpX%10;
            numX[n]++;
            tmpX=tmpX/10;
        }
        
        while(tmpY!=0){
            n=tmpY%10;
            numY[n]++;
            tmpY=tmpY/10;
        }
        int min=0;
        for(int i=numX.length-1; i>=0; i--){
            if(numX[i]!=0 && numY[i]!=0){  
                if(i==0 && answer.equals("")) min=1;
                else min=Math.min(numX[i], numY[i]);
                //System.out.println("min : "+min);
                for(int j=0; j<min; j++){
                    answer=answer+i;
                }
            }
            //System.out.println(numX[i]+", "+numY[i]);
        }
        
        if(answer.equals("")) answer="-1";
        
        return answer;
    }
}





/* hashmap */
import java.util.HashMap;
import java.util.Set;
import java.util.Iterator;

class Solution {
    public String solution(String X, String Y) {
        String answer = "";
        HashMap<Integer, Integer> mapX = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> mapY = new HashMap<Integer, Integer>();
        
        int tmpX=Integer.parseInt(X);
        int tmpY=Integer.parseInt(Y);
        int n=0;
        
        while(tmpX!=0){
            n=tmpX%10;
            if(mapX.containsKey(n)){  //이미 존재하면
                mapX.put(n, mapX.get(n)+1);
            }else{
                mapX.put(n, 1);  //최초로 값을 세었을 때
            }
            tmpX=tmpX/10;
        }
        
        while(tmpY!=0){
            n=tmpY%10;
            if(mapY.containsKey(n)){  //이미 존재하면
                mapY.put(n, mapY.get(n)+1);
            }else{
                mapY.put(n, 1);  //최초로 값을 세었을 때
            }
            tmpY=tmpY/10;
        }
        
        Set<Integer> setX=mapX.keySet();
        System.out.println(setX);
        Set<Integer> setY=mapY.keySet();	
        System.out.println(setY);
        
        setX.retainAll(setY);
        System.out.println("retain : "+setX);
        int size=setX.size();
        
		Iterator<Integer> iter=setX.iterator();	
        int min=0;
		while(iter.hasNext()) {
            int tmp=iter.next();
			System.out.println(tmp+":"+mapX.get(tmp)+", "+mapY.get(tmp));
            if(setX.size()==1 && tmp==0){
                answer=answer+tmp; 
                break;
            }
            min=Math.min(mapX.get(tmp), mapY.get(tmp));
            System.out.println("min:" + min);
            for(int i=0; i<min; i++){
                answer=tmp+answer;
            }
		}
        
        if(answer.equals("")) answer="-1";
        
        return answer;
    }
}



/* switch case */
class Solution {
    public String solution(String X, String Y) {
        String answer = "";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(answer);
        int[][] num=new int[2][10];
        for(int i=0; i<X.length(); i++){
            switch(X.charAt(i)){
                case '0': num[0][0]++; break;
                case '1': num[0][1]++; break;
                case '2': num[0][2]++; break;
                case '3': num[0][3]++; break;
                case '4': num[0][4]++; break;
                case '5': num[0][5]++; break;
                case '6': num[0][6]++; break;
                case '7': num[0][7]++; break;
                case '8': num[0][8]++; break;
                case '9': num[0][9]++; break;
            }
        }
        
        for(int i=0; i<Y.length(); i++){
            switch(Y.charAt(i)){
                case '0': num[1][0]++; break;
                case '1': num[1][1]++; break;
                case '2': num[1][2]++; break;
                case '3': num[1][3]++; break;
                case '4': num[1][4]++; break;
                case '5': num[1][5]++; break;
                case '6': num[1][6]++; break;
                case '7': num[1][7]++; break;
                case '8': num[1][8]++; break;
                case '9': num[1][9]++; break;
            }
        }
        
        int min=0;
        for(int i=9; i>=0; i--){
            if(num[0][i]>0 && num[1][i] >0){
                if(i==0 && answer.equals("")) min=1;
                else min=Math.min(num[0][i], num[1][i]);
                for(int j=0; j<min; j++){
                    stringBuilder.append(answer).append(i);
                }
            }
        }
        answer=stringBuilder.toString();
        if(answer.equals("")) answer="-1";
        
        return answer;
    }
}

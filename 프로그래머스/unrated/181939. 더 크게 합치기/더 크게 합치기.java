class Solution {
    public int solution(int a, int b) {
        int answer=0;
        
        String str_a = Integer.toString(a);
        String str_b = Integer.toString(b);
        
        String a_b = str_a+str_b;
        String b_a = str_b+str_a;
        
        int answer1 = Integer.valueOf(a_b);
        int answer2 = Integer.valueOf(b_a);
        if(answer1<=answer2){
            answer = answer2;
        }
        else{
            answer = answer1;
        }
        return answer;
    }
}
class Solution {
    public int solution(int[] num_list) {
        int sumEven = 0; // 짝수 번째 원소들의 합을 저장할 변수
        int sumOdd = 0; // 홀수 번째 원소들의 합을 저장할 변수
        
        for (int i = 0; i < num_list.length; i++) {
            if (i % 2 == 0) {
                sumEven += num_list[i]; // 짝수 번째 원소들의 합 누적
            } else {
                sumOdd += num_list[i]; // 홀수 번째 원소들의 합 누적
            }
        }
        
        return Math.max(sumEven, sumOdd); // 두 합 중 큰 값을 반환
    }
}

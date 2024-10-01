package 프로그래머스;

import java.util.Arrays;

public class 순열_검사 {
    public boolean solution(int[] arr) {
        boolean answer = true;
        int N = arr.length; // 배열의 크기
        int[] compare = new int[N];

        for(int i=0; i<N; i++){
            compare[i] = i+1;
        }
        Arrays.sort(arr);

        for(int i=0; i<N; i++){
            if(arr[i] != compare[i]){
                answer = false;
                break;
            }
        }

        return answer;
    }
}

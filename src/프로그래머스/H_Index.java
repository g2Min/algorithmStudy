package 프로그래머스;

import java.util.Arrays;

public class H_Index {
    public int solution(int[] citations){
        int answer = 0;
        Arrays.sort(citations);
        int n = citations.length;
        for (int i = 0; i < n; i++) {
            int h = n - i;
            if (citations[i] >= h) {
                answer = h;
                break;
            }
        }

        return answer;
    }
}

/* n편 중 h 번 이상 인용된 논문, h편
 */
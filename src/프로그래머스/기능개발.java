package 프로그래머스;

import java.io.*;
import java.util.*;
public class 기능개발 {
    public int[] solution(int[] progresses, int[] speeds){
        int[] answer = {};
        int day = 0;
        Queue<Integer> pro = new LinkedList<>();
        for(int i=0; i<progresses.length ; i++){
            pro.add(progresses[i]);
        }



        return answer;
    }
}

/* progress 에는 먼저 배포되어야 하는게
 먼저 들어왔으므로 -> FIFO (큐)
1. x일이 지날때마다 모든 큐에는 speeds[i]*x 만큼
2. 큐.peek 가 100이 되면 나머지 100이된것들 모두 poll -> cnt ++; cnt 를 리스트로
3. 큐.isEmpty()가 될때까지
* */
package 프로그래머스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 더_맵게 {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] scoville = new int[6];
        for(int i=0; i<6; i++){
            scoville[i] = Integer.parseInt(st.nextToken());
        }
        int K = Integer.parseInt(br.readLine());
        System.out.print(solution(scoville, K));
    }
    public static int solution(int[] scoville, int K){
        int answer = 0;
        int max = 1000000;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i=0; i<scoville.length; i++){
            queue.add(scoville[i]);
        }

        while(queue.peek() < K){ //가장 맵지 않은 음식이 K보다 작을때까지
            if(queue.size() >= 2){
                int most = queue.poll();
                int then = queue.poll();
                int newOne = most + then*2;
                answer ++;
                queue.add(newOne);
            }else{
                return -1;
            }
        }

        return answer;
    }
}

/* 가장 작은 스코빌 + (두번째로 작은 스코빌 *2) => 새로운 음식으로 만들고 전체가 k 이상이 될때까지
실패하는 경우 -> 모든 원소가 0이상 1000,000 인데 모두 1000,000 넘고 가장 작은 것만 안남은 경우 -> -1 반환
* */
package 프로그래머스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 구명보트 {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 사람수
        int[] people = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            people[i] = Integer.parseInt(st.nextToken());
        }
        int limit = Integer.parseInt(br.readLine());
        System.out.print(solution(people, limit));
    }
    public static int solution(int[] people, int limit){
        int answer = 0;
        PriorityQueue<Integer> minPq = new PriorityQueue<>(); // 가장 작은 숫자가 맨 위로
        PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());
        int size = people.length;
        for(int i=0; i<size; i++){
            maxPq.add(people[i]);
            minPq.add(people[i]);
        }
        while(!minPq.isEmpty()){
            int min = minPq.peek();
            int max = maxPq.peek();
            if(minPq.size() > 1) { // pq개수가 둘 이상일떼
                if(min + max <= limit){
                    maxPq.remove(minPq.poll());
                    minPq.remove(maxPq.poll());
                }
                int minium = minPq.poll();
                int nextMinium = minPq.poll();
                minPq.add(minium);
                minPq.add(nextMinium);
                if(minium + nextMinium <= limit){
                    maxPq.remove(minPq.poll());
                    maxPq.remove(minPq.poll());
                }else{
                    maxPq.remove(minPq.poll());
                }
            }else{
                maxPq.remove(minPq.poll());
            }
            answer++;
        }

        return answer;
    }
}

/* 입력값: (사람수) \n (사람 무게 배열) \n (한계)
* */
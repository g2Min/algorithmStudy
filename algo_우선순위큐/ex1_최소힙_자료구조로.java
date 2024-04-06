package algo_우선순위큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class ex1_최소힙_자료구조로 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 연산 개수
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int size = pq.size();
        boolean empty = pq.isEmpty();

        for(int i=1; i<=N; i++){
            int num = Integer.parseInt(br.readLine());
            if(num == 0 && !empty){

            }
            if(num == 0 && empty){

            }
            if(num!=0){

            }
        }

    }
}

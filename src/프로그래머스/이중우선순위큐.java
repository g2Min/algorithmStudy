package 프로그래머스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class 이중우선순위큐 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] operations = new String[7];
        for(int i=0; i<7; i++){
            operations[i] = br.readLine();
        }
    }
    public static int[] solution(String[] operations){
        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0; i<operations.length; i++){
            String[] chunk = operations[i].split(" ");
            int num = Integer.parseInt(chunk[1]);
            switch (chunk[0]){
                case "I" :
                    min.add(num);
                    max.add(num);
                    break;
                case "D" :
                    if(max.isEmpty()) break;
                    if(num == 1){
                        int target = max.poll();
                        min.remove(target);
                    }
                    if(num == -1){
                        int target = min.poll();
                        max.remove(target);
                    }
            }
        }
        if(max.isEmpty()){
            return new int[] {0, 0};
        }

        return new int[] {max.peek(), min.peek()};
    }
}

package algo_BFS1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 조세퍼스 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Queue<int[]> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N; i++){
            queue.add(new int[] {i, i}); // 1번 -> key 2번 -> value
        }
        int back = N; // 제일 끝에 있는 숫자
        while(queue.size() > 1){
            int[] now = queue.poll();
            if(now[1] % M == 0){ // M의 배수인 경우
                sb.append(now[0]).append(" ");
            }else{
                int key = now[0];
                back++;
                int value = back;
                queue.add(new int[] {key, value});
            }
        }
        int[] last = queue.poll();
        sb.append(last[0]);
        System.out.print(sb);
    }
}

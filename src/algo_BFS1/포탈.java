package algo_BFS1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 포탈 {
    static int X, Y;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        Queue<Integer> q = new LinkedList<>();
        int[] dist = new int[20001]; // 0~20000
        dist[X] = 1;
        q.offer(X);

        while(!q.isEmpty()){
            int num = q.poll();
            if(num+1<=20000 && dist[num+1]==0){
                dist[num+1] = dist[num]+1;
                q.offer(num+1);
            }
            if(num-1>=0 && dist[num-1]==0){
                dist[num-1] = dist[num]+1;
                q.offer(num-1);
            }
            if(2*num<=20000 && dist[num*2]==0){
                dist[num*2] = dist[num]+1;
                q.offer(num*2);
            }
        }

        System.out.print(dist[17]-1);
    }
}
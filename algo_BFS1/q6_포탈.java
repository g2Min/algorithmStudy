package algo_BFS1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class q6_포탈 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        int X = Integer.parseInt(str.nextToken()); //X좌표
        int Y = Integer.parseInt(str.nextToken()); //Y좌표
        int ans = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(X);
        int[] dist = new int[Y+1];
        dist[X] = 1;

        while(!queue.isEmpty()){
            int x = queue.poll();
            if(x+1 <= Y && dist[x+1] == 0){
                dist[x+1] = dist[x]+1;
                queue.offer(x+1);
            }
            if(x-1 >= 0 && dist[x-1] == 0){
                dist[x-1] = dist[x]+1;
                queue.offer(x-1);
            }
            if(2*x <= Y && dist[2*x] == 0){
                dist[2*x] = dist[x]+1;
                queue.offer(2*x);
            }
        }
        System.out.println(dist[Y]-1);
    }
}

// x => x+1, x-1, 2x 중 하나로 움직임 (포탈 한번당 한번만 움직임)
// 절댓값의 abs가 가장 작은 것으로 움직임 (곱셈 | 덧-뺄셈)
// 5 -> 17 : 5-1*2*2+1
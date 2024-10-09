package algo_BFS1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 직접_만든_큐 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        int back = -1;
        int cnt = 1;

        StringTokenizer st;
        while(cnt <= n){
            String input = br.readLine();
            st = new StringTokenizer(input);
            String command = st.nextToken();

            switch (command){
                case "push":
                    int number = Integer.parseInt(st.nextToken());
                    back = number;
                    queue.add(number);
                    break;
                case "pop":
                    if(!queue.isEmpty()){
                        int top = queue.poll();
                        sb.append(top).append("\n");
                    }else{
                        sb.append("-1").append("\n");
                    }
                    break;
                case "size":
                    int size = queue.size();
                    sb.append(size).append("\n");
                    break;
                case "empty":
                    if(!queue.isEmpty()){
                        sb.append("0").append("\n");
                    }else {
                        sb.append("1").append("\n");
                    }
                    break;
                case "front":
                    if(!queue.isEmpty()){
                        int top = queue.peek();
                        sb.append(top).append("\n");
                    }else{
                        sb.append("-1").append("\n");
                    }
                    break;
                case "back":
                    if(!queue.isEmpty()){
                        sb.append(back).append("\n");
                    }else{
                        sb.append("-1").append("\n");
                    }
                    break;
            }
            cnt++;
        }
        System.out.print(sb);

    }
}

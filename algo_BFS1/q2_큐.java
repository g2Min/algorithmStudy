package algo_BFS1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class q2_큐 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> queue = new LinkedList<>();
        StringTokenizer str1 = new StringTokenizer(br.readLine());
        StringTokenizer str2;
        int N = Integer.parseInt(str1.nextToken()); // 명령어 수
        StringBuilder sb = new StringBuilder();
        String line;
        int back = -1;

        for(int i=0; i<N; i++){
            str2 = new StringTokenizer(br.readLine());
            line = str2.nextToken();

            if(line.equals("size")){
                int x = queue.size();
                sb.append(x+"\n");
            }

            if(line.equals("empty")){
                Boolean isEmpty = queue.isEmpty();
                if(isEmpty) sb.append("1\n");
                else sb.append("0\n");
            }

            if(line.equals("push") && str2.hasMoreTokens()){
                int x = Integer.parseInt(str2.nextToken());
                queue.offer(x);
                back = x;
            }

            if(line.equals("back")){
                if(queue.isEmpty()){
                    sb.append("-1\n");
                    continue;
                }
                sb.append(back+"\n");
            }

            if(line.equals("front")){
                if(queue.isEmpty()){
                    sb.append("-1\n");
                    continue;
                }
                int x = queue.peek();
                sb.append(x+"\n");
            }

            if(line.equals("pop")){
                if(queue.isEmpty()){
                    sb.append("-1\n");
                    continue;
                }
                int x = queue.poll();
                sb.append(x+"\n");
            }
        }
        System.out.print(sb);
    }
}
//큐는 linked list 형태로 만들어야함

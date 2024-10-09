package algo_BFS1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 소수_경로 {
    static int X, Y;
    static boolean[] isPrime = new boolean[10000];
    static Queue<Integer> q;
    static int[] dist;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for(int i=2; i<10000; i++){
            if(isPrime[i]){
                for(int j=i*i; j<10000; j+=i){
                    isPrime[j] = false;
                }
            }
        }

        for(int i=0; i<T; i++){
            st = new StringTokenizer(br.readLine());
            X = Integer.parseInt(st.nextToken());
            Y = Integer.parseInt(st.nextToken());
            q = new LinkedList<>();
            dist = new int[10000];
            q.offer(X);
            dist[X] = 1;
            while(!q.isEmpty()){
                int start = q.poll();
                for(int next: getList(start)){
                    if(dist[next] == 0){
                        dist[next] = dist[start] + 1;
                        q.offer(next);
                    }
                }
            }
            if (dist[Y] == 0) {
                System.out.println("Impossible");  // 도달할 수 없는 경우
            } else {
                System.out.println(dist[Y] - 1);  // 거리에서 1을 뺀 값 출력
            }
        }

    }
    public static ArrayList<Integer> getList(int x){
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=1; i<=9; i++){
            int tmp = i*1000 + (x%1000);
            if(isPrime[tmp] && dist[tmp] == 0){
                list.add(tmp);
            }
        }
        for(int i=0; i<=9; i++){
            int tmp = i*100 + (x/1000)*1000 + (x%100);
            if(isPrime[tmp] && dist[tmp] == 0){
                list.add(tmp);
            }
        }

        for(int i=0; i<=9; i++){
            int tmp = i*10 + (x/100)*100 + (x%10);
            if(isPrime[tmp] && dist[tmp] == 0){
                list.add(tmp);
            }
        }

        for(int i=0; i<=9; i++){
            int tmp = (x/10)*10 + i;
            if(isPrime[tmp] && dist[tmp] == 0){
                list.add(tmp);
            }
        }

        return list;
    }
}

package baekjoon.투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class 소수의_연속합 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N =Integer.parseInt(br.readLine());
        boolean[] isPrime = new boolean[N+1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for(int i=2; i<=N; i++){
            if (isPrime[i]) {
                for(int j=i*i; j<=N; j+=i){
                    isPrime[j] = false;
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<=N; i++){
            if(isPrime[i]){
                list.add(i);
            }
        }

        int l=0, r=0, cnt=0;
        int sum = list.isEmpty() ? 0 : list.getFirst();
        while(l<list.size()){
            if(sum == N){
                cnt++;
                sum -= list.get(l);
                r++;
            }else if(sum > N){
                sum -= list.get(l);
                l++;
            }else{
                if(r>=list.size()-1){ //그냥 남은 가능성을 모두 탐색하고 종료하는 것임
                    sum -= list.get(l);
                    l++;
                }else{
                    r++;
                    sum += list.get(r);
                }
            }
        }
        System.out.print(cnt);
    }
}
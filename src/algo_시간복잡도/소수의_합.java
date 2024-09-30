package algo_시간복잡도;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 소수의_합 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        Boolean[] isPrime = new Boolean[(int)N+1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for(long i=2; i*i<= N; i++){
            if(isPrime[(int)i]){
                for(long j=i*i; j<=N; j+=i){
                    isPrime[(int)j] = false;
                }
            }
        }

        long sum = 0;
        for(long i=1; i<=N; i++){
            if(isPrime[(int)i]){
                sum += i;
            }
        }

        System.out.print(sum);
    }
}

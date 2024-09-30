package algo_시간복잡도;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 약수의_합 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());

        long ans = 0;
        for(long i=1; i*i<=N; i++){
            if(N%i == 0){
                if(i*i != N){
                    ans += i;
                    ans += N/i;
                }else{
                    ans += i;
                }
            }
        }
        System.out.print(ans);
    }
}

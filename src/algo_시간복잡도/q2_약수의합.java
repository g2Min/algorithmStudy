package algo_시간복잡도;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q2_약수의합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        long answer = 0L;

        for(long i=1L; i*i<=n; i++) {
            if(n%i == 0) {
                if(i!=n/i) answer+= i+(n/i);
                else answer += i;
            }
        }
        System.out.println(answer);
    }
}

// 10 => 1, 2, 5, 10
// n의 중간까지만 증가하고


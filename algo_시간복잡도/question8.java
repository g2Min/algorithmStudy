package algo_시간복잡도;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class question8 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
//        ArrayList<Integer> fibo = new ArrayList<>();
        long[] fibo = new long[505];
        fibo[1]=1L;
        fibo[2]=1L;
        for( int i=3; i<=n; i++ ){
            fibo[i]=fibo[i-1]+fibo[i-2];
//            System.out.println(fibo[i]);
        }
        System.out.println(fibo[n]);
    }
}

// 피보나치는 사실 order(log N)으로 알려져 있다.
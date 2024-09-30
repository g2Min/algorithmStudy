package algo_완전탐색1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 방_배정하기 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int ans = 0; // true

        for(int a=N/A; a>=0; a--){
            int bk = N-A*a;
            for(int b=bk/B; b>=0; b--){
                int ck = N-A*a-B*b;
                if(ck%C == 0){
                    ans += 1;
                }
            }
        }

        if(ans > 0){
            System.out.print(1);
        }else{
            System.out.print(0);
        }
    }
}

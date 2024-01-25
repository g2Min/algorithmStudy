package first;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class question6 {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());
            int answer = 0;

            for(int i=1; i<=n; i++) {
                if(n%i == 0) {
                    answer += i;
                }
            }
            System.out.println(answer);
        }
}

// 10 => 1, 2, 5, 10
// n의 중간까지만 증가하고


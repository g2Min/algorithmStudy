package algo_완전탐색1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class question5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(str.nextToken()); // 입력받은 수
//        System.out.println(N);
        br.close();
        int result = 0; // 원하는 값

        //order(n^2)
//        for (int i = 1; i < N; i++) {
//            for (int j = i; j < N-i; j++) {
//                int k = N-i-j;
//                if (k>=j && k < i + j) {
//                    result++;
//                }
//            }
//        }

        //order(n)
        for (int i = 1; i < N; i++) {
            for (int j = i; j < N-i; j++) {
                int k = N-i-j;
                if (k>=j && k < i + j) {
                    result++;
                }
            }
        }


        System.out.println(result);
    }
}

// 삼각형이 만들어지려면 (가장 큰수) < (나머지 두 수의 합)
// 위 조건식을 만족하는 result ++


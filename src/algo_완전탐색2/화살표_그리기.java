package algo_완전탐색2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 화살표_그리기 {
    public static void main(String[] args )throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][2];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            map[i][0] = Integer.parseInt(st.nextToken());
            map[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(map, (a,b) -> Integer.compare(a[0], b[0]));

        int sum = 0;
        for(int i=0; i<N; i++){
            int len = Integer.MAX_VALUE;
            for(int j=0; j<N; j++){
                if(i == j) continue;
                if(map[i][1] != map[j][1]) continue;
                int sub = Math.abs(map[i][0] - map[j][0]);
                len = Math.min(len, sub);
            }
            sum += len;
        }

        System.out.print(sum);

    }
}

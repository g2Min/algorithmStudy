package algo_완전탐색2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 표지 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String output = br.readLine();
        char[] out = output.toCharArray();
        String[] test = new String[N];
        for(int i=0; i<N; i++){
            test[i] = br.readLine();
        }

        int cnt = 0;
        for(int t=0; t<N; t++){
            int idx = 0;
            for(int i=0; i<test[t].length(); i++){
                if(test[t].charAt(i) == out[idx]){
                    idx++;
                    continue;
                }
                if(idx == out.length-1){
                    cnt ++;
                    break;
                }
            }
        }

        System.out.print(cnt);
    }
}

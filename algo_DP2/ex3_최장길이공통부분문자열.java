package algo_DP2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ex3_최장길이공통부분문자열 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine(); // 입력받은 문자열 S
        String T = br.readLine(); // 입력받은 문자열 T
        int[][] LCS = new int[S.length()+1][T.length()+1];
        for(int i=1; i<=S.length(); i++){
            for(int j=1; j<=T.length(); j++){
                if(S.charAt(i-1) == T.charAt(j-1)) LCS[i][j] = LCS[i-1][j-1]+1;
                else LCS[i][j] = Math.max(LCS[i-1][j], LCS[i][j-1]);
            }
        }
        System.out.print(LCS[S.length()][T.length()]);
    }
}

/*
baaababab
ababbbab
공통부분문자열이기 때문에 최대한 동일한 부분을 합치면 됨
* */
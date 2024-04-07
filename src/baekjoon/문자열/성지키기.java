package baekjoon.문자열;

import javax.swing.plaf.synth.SynthLookAndFeel;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 성지키기 {
    static int N, M;
    static int[][] map;
    static boolean[] row, column;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str1 = new StringTokenizer(br.readLine());
        M = Integer.parseInt(str1.nextToken()); // 열
        N = Integer.parseInt(str1.nextToken()); // 행
        map = new int[M][N];
        row = new boolean[M];
        column = new boolean[N];

        for(int i=0; i<M; i++){
            String line = br.readLine();
            for(int j=0; j<N; j++){
                char A = line.charAt(j);
                if(A == 'X'){
                    map[i][j] = 1;
                    row[i] = true;
                    column[j] = true;
                }else{
                    map[i][j] = 0;
                }
            }
        }
        System.out.print(maxAns());
    }
    private static int maxAns(){
        int rowAns = 0;
        for(int i=0; i<row.length; i++){
            if(row[i] == false){
                rowAns++;
            }
        }
        int colAns = 0;
        for(int j=0; j<column.length; j++){
            if(column[j] == false){
                colAns++;
            }
        }
        return Math.max(rowAns, colAns);
    }

}

// map 이랑 row 중 최대
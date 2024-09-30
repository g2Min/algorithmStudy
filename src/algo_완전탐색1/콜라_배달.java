package algo_완전탐색1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 콜라_배달 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int box = Integer.MAX_VALUE;
        for(int a=n/5; a>=0; a--){
            int bK = n - 5*a;
            if( bK%3 == 0){
                box = Math.min(box, a+bK/3);
            }
        }

        if(box == Integer.MAX_VALUE){
            box = -1;
        }
        System.out.print(box);
    }
}

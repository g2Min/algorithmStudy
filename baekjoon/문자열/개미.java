package baekjoon.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 개미 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str1 = new StringTokenizer(br.readLine());
        int W = Integer.parseInt(str1.nextToken()); // 격자점 width
        int H = Integer.parseInt(str1.nextToken()); // 격자점 height
        StringTokenizer str2 = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(str2.nextToken()); // 초기 x
        int y = Integer.parseInt(str2.nextToken()); // 초기 y
        long time = Long.parseLong(br.readLine()); // 주어진 시간동안
        int dx = 1, dy = 1; // 초기값으로 x = +1, y = +1

        for(long i=0; i<time; i++){
            if(x==W || x==0){
                dx = -dx;
                x+=dx;
            }else{
                x+=dx;
            }
            if(y==H || y==0){
                dy = -dy;
                y+=dy;
            }else {
                y+=dy;
            }
        }

        System.out.println(x + " " + y);
    }
}

// 처음엔 (+1, +1) 이다가 x=0 or w => -1로 바뀜 ,y=0 or h => -1로 바뀜

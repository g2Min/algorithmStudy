package algo_정렬과분할정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ex4_분할정복으로별찍기 {
    static int N;
    static boolean[][] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // NxN에서 N
        arr = new boolean[N][N]; // 출력할 배열 arr

        func(0,0, N);
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                System.out.print(arr[i][j] ? "*" : " ");
            }
            System.out.print("\n");
        }
    }
    private static void func(int x, int y, int l){
        if(l==1) {
            arr[x][y] = true;
            return;
        }
        for(int i=x; i<x+l; i+=l/3){
            for(int j=y; j<y+l; j+=l/3){
                if(i==x+l/3 && j ==y+l/3) continue;
                func(i, j, l/3);
            }
        }
    }
}

// 재귀 + 분할mid
// N=9라고 할때 9x9 정사각형은 3x3 정사각형 크기를 3x3으로 둘러쌌다. 그 안에 1x1가운데를 두고 그 주변을 1x1로 둘러쌈
// N=27이라고 할때 27x27 정사각형은 9x9 정사각형을 가운데에 두고 나머지를 9x9로 둘러쌈3
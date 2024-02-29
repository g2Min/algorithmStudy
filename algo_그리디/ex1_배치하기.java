package algo_그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex1_배치하기 {
    static long[] arrayA, arrayB;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N =Integer.parseInt(br.readLine()); // 전체 배열 개수
        arrayA = new long[N];
        arrayB = new long[N];
        StringTokenizer str1 = new StringTokenizer(br.readLine());
        StringTokenizer str2 = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arrayA[i] = Long.parseLong(str1.nextToken());
            arrayB[i] = Long.parseLong(str2.nextToken());
        }
        sortMin(arrayA);
        sortMax(arrayB);
        long ans1 = 0;
        for(int i=0; i<N; i++){
            ans1 += arrayA[i] * arrayB[i];
        }
        sortMax(arrayA);
        sortMin(arrayB);
        long ans2 = 0;
        for(int i=0; i<N; i++){
            ans2 += arrayA[i] * arrayB[i];
        }
        System.out.println(Math.min(ans1, ans2));
    }
    // 작은 값대로 정렬
    private static void sortMin(long[] arr){
        for(int i=0; i<arr.length-1; i++){
            for(int j=i+1; j<arr.length; j++){
                if(arr[i] > arr[j]){
                    long temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    // 큰 값대로 정렬
    private static void sortMax(long[] arr){
        for(int i=0; i<arr.length-1; i++){
            for(int j=i+1; j<arr.length; j++){
                if(arr[i] < arr[j]){
                    long temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}

// 배열 a: 작은 값순서대로
// 배열 b: 큰 값 순서대로 (아니면 반대로 해서 더 작은 값으로 구하기)
package algo_정렬과분할정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex1_수정렬하기 {
    static int N; // 입력받을 개수
    static int[] arr; // 입력받은 배열
    static int[] tmp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        tmp = new int[N];
//        insertSort(arr);
        mergeSort(arr, 0, N);
//        bubbleSort(arr);
        for(int i=0; i<N; i++){
            System.out.println(arr[i]);
        }
    }
    
     // 병합정렬
    private static void mergeSort(int[] arr, int l, int r){
        if(r-l == 1) return;// 연속된 배열인 경우 반환
        int m = (l+r)/2;
        mergeSort(arr, l, m);
        mergeSort(arr, m, r);

        int lp = l, rp = m;
//        tmp = new int[r];
        for(int i=l; i<r; i++){
            if(rp == r || (lp < m && arr[lp] < arr[rp])) tmp[i] = arr[lp++];
            else tmp[i] = arr[rp++];
        }
        for(int i=l; i<r; i++) arr[i] = tmp[i];
    }
    
    // 삽입정렬
    private static void insertSort(int[] arr){
        for(int i=0; i<N; i++){
            for(int j=i; j>0; j--){
                if(arr[j] < arr[j-1]){
                    int tmp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = tmp;
                }
            }
        }
    }
    
    // 버블정렬
    private static void bubbleSort(int[] arr){
        for(int i=0; i<N; i++){
            for(int j=0; j<N-i-1; j++){
                if(arr[j] > arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
    }
}

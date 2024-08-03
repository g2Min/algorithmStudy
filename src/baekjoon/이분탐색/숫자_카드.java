package baekjoon.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 숫자_카드 {
    static int[] cards, test;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 상근이가 가지고있는 카드 개수
        cards = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            cards[i] = Integer.parseInt(st.nextToken());
        }
        int M = Integer.parseInt(br.readLine()); // 테스트 카드 개수
        test = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            test[i] = Integer.parseInt(st.nextToken());
        }
        StringBuilder sb = new StringBuilder();
        Arrays.sort(cards);

        for(int i=0; i<M; i++){
            sb.append(binarySearch(test[i], 0, N)).append(" ");
        }
        System.out.print(sb);
    }
    public static int binarySearch(int key, int low, int high){
        int mid;

        while(low <= high){
            mid = (low + high) / 2;
            if(key == cards[mid]){
                return 1;
            }else if(key < cards[mid]){
                high = mid-1;
            }else {
                low = mid+1;
            }
        }
        return 0;
    }
}

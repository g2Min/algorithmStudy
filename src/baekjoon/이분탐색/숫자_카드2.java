package baekjoon.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class 숫자_카드2 {
    private static int[] cards, test;
    private static HashMap<Integer, Integer> cardMap;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //상근이 가지고 있는 숫자카드 개수
        cards = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            cards[i] = Integer.parseInt(st.nextToken());
        }
        int M = Integer.parseInt(br.readLine()); //테슽트할 숫자 카드 개수
        test = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            test[i] = Integer.parseInt(st.nextToken());
        }
        cardMap = new HashMap<>();
        for(int i=0; i<N; i++){
            if(cardMap.containsKey(cards[i])){
                int value = cardMap.get(cards[i]);
                cardMap.replace(cards[i], value+1);
            }else{
                cardMap.put(cards[i], 1);
            }
        }
        StringBuilder sb = new StringBuilder();
        Set<Integer> keys = cardMap.keySet();
        TreeSet<Integer> sortedKeys = new TreeSet<>(keys);
        int minKey = sortedKeys.first();
        int maxKey = sortedKeys.last();
        for(int i=0; i<M; i++){
            sb.append(binarySearch(test[i], minKey, maxKey)).append(" ");
        }
        System.out.print(sb);
    }
    public static int binarySearch(int key, int low, int high){
        int mid;

        while(low <= high){
            mid = (low + high)/2;
            if(key == mid){
                if(cardMap.containsKey(key)){
                    return cardMap.get(mid);
                }
                break;
            }else if(key < mid){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return 0;
    }
}

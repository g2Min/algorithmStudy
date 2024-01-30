package algo_DFS2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class q2_싸이클_단순재귀 {
    private static int N, P, ans;
//    private static long[] arr;
    private static ArrayList<Integer> list;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        N = Integer.parseInt(str.nextToken());
        P = Integer.parseInt(str.nextToken());
        list = new ArrayList<>();

        dfs(N);
//        System.out.println(ans);
    }
    public static void dfs(int x){
        int value = (x*N) % P;
//        list.add(value);
//        dfs(value);
        int endOfIndex= list.size();
        for(int i=0; i<endOfIndex; i++){
            if(value == list.get(i)){
                ans = endOfIndex - i;
                System.out.println(value + " " + list.get(i));
            }else{
                list.add(value);
                dfs(value);
                value=0;
            }
        }
    }
}

// 싸이클
// 처음 N0 * N0 % P => N1 * N0 % P => ...
// 위에 나온 값들을 배열로 받아서 순회하면서 "반복되는 부분이 연속될경우..?"
// 1) check 배열을 이용해서 이미 나온 값인지를 확인하는것
package algo_그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class ex4_체육대회 {
    static ArrayList<Integer> arrA, arrB;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arrA = new ArrayList<>();
        arrB = new ArrayList<>();

        StringTokenizer str1 = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) arrB.add(Integer.parseInt(str1.nextToken()));

        StringTokenizer str2 = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) arrA.add(Integer.parseInt(str2.nextToken()));

        Collections.sort(arrA);
        Collections.sort(arrB);

        int j=0, cnt=0;
        for(int i=0; i<N; i++){
            while(j<N && arrA.get(j) <= arrB.get(i)) j++;
            if(j==N) break;
            cnt++;
            j++;
        }
        System.out.print(cnt);
    }
}

// 첫째줄 - B 둘째줄 - A
// B중에서 제일 작은 애보다 작은 수가 있는 경우
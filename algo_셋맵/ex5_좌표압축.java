package algo_셋맵;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class ex5_좌표압축 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer str = new StringTokenizer(br.readLine());
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] arr = new int[N];
        int[] sort = new int[N];
        for(int i=0; i<N; i++){
            int x = Integer.parseInt(str.nextToken());
            arr[i] = x;
            sort[i] = x;
        }

        int rank = 0;
        Arrays.sort(sort);
        for(int v: sort){
            if(!map.containsKey(v)){
                map.put(v, rank);
                rank++;
            }
        }

        for(int key: arr){
            System.out.print(map.get(key) + " ");
        }
    }
}

// Xi: 10억이하인 정수
// 주어진 배열 내에서 더 작은 값 그니까 그 아래 값이 몇개 있느냐에 대한 질문
// 배열로 바꿔서 index 값이 나보다 작은 숫자의 개수를 의미함
// set을 두개 만들자.
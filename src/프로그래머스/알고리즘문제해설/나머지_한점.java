package 프로그래머스.알고리즘문제해설;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.SortedMap;
import java.util.StringTokenizer;

public class 나머지_한점 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[][] v = new int[3][2];
        for(int i=0; i<3; i++){
            st = new StringTokenizer(br.readLine());
            v[i][0] = Integer.parseInt(st.nextToken());
            v[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] ans = solution(v);
        System.out.print(ans[0] + " " + ans[1]);

    }
    public static int[] solution(int[][] v) {
        int[] answer = new int[2];
        HashMap<Integer, Integer> xchk = new HashMap<>();
        HashMap<Integer, Integer> ychk = new HashMap<>();
        for(int i=0; i<3; i++){
            if(xchk.containsKey(v[i][0])){
                xchk.replace(v[i][0], xchk.get(v[i][0])+1);
            }else{
                xchk.put(v[i][0], 1);
            }
            if(ychk.containsKey(v[i][1])){
                ychk.replace(v[i][1], ychk.get(v[i][1])+1);
            }else{
                ychk.put(v[i][1], 1);
            }
        }

        for(int key: xchk.keySet()){
            if(xchk.get(key) == 1){
                answer[0] = key;
                break;
            }
        }
        for(int key: ychk.keySet()){
            if(ychk.get(key) == 1){
                answer[1] = key;
                break;
            }
        }

        return answer;
    }
}
/*
1 4
3 4
3 10

1 1
2 2
1 2
* */
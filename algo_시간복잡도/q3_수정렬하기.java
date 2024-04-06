package algo_시간복잡도;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class q3_수정렬하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 몇개의 숫자를 받을 것인지
        ArrayList<Integer> list = new ArrayList<>();
        StringTokenizer st;

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            list.add(Integer.parseInt(st.nextToken()));
        }
        br.close();
        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
//            System.out.println(list.get(i));
            sb.append(list.get(i)).append("/n");
        }

        System.out.println(sb);
    }
}

// 3 1 1 3 4 이런식으로 입력을 받고
//
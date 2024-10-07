package algo_DFS2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 싸이클 {
    static int N, P;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        HashMap<Integer, Integer> map = new HashMap<>();
        int current = N;
        int index = 0;

        while (!map.containsKey(current)) {
            map.put(current, index);  // 숫자와 해당 인덱스 저장
            current = (current * N) % P;
            index++;
        }

        // 반복되는 부분의 길이 계산
        int cycleStartIndex = map.get(current);
        int cycleLength = index - cycleStartIndex;

        System.out.println(cycleLength);
    }
}

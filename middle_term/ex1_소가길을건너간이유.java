package middle_term;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class ex1_소가길을건너간이유 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        String str = br.readLine();

        int pos1[] = new int[26];
        int pos2[] = new int[26];
        int cnt = 0;
        for(int i = 0; i < 52; i++) {
            int idx = str.charAt(i)-'A';
            if(pos1[idx] == 0) pos1[idx] = i+1;
            else pos2[idx] = i+1;
        }

        for(int i = 0; i < 26; i++) {
            for(int j = 0; j < 26; j++) {
                if(pos1[i] < pos1[j] && pos1[j] < pos2[i] && pos2[i] < pos2[j]){
                    cnt ++;
                }
            }
        }

        System.out.println(cnt);
    }
}

// 소가 문이 총 52개이고 -> 스택으로 생각해야하나 (마지막으로 입력된 자료가 가장 먼저 삭제됨)
// 1)연속으로 카운팅되면 만나지 않음
// 2)ABBA 인 경우에도 만나지 않음
// 3)ABCDDBCA 이렇게 되면 B와 C만 만남
// 4)ABCDDABC
// 근데 ABCDDCBA 이러면 안만남
// 즉 push하고 최근껄 뺄때 그 순서가 맞지 않는 경우 스택에 맞지 않는 경우 cnt 시키고 모두 꺼내기
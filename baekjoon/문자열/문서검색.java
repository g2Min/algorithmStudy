package baekjoon.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Watchable;
import java.util.ArrayList;
import java.util.Collections;

public class 문서검색 {
    static int ans = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String want = br.readLine();

        search(0, want.length(), want, line);

        System.out.print(ans);
    }
    public static void search(int index, int wantIndex, String want, String line){
        if(wantIndex>line.length() || index>line.length()) return;

        if(line.substring(index, wantIndex).equals(want)){ // 원하는 범위내에 동일한경우
            ans++;
            index +=want.length();
            wantIndex +=want.length(); // 그 다음 index 건너뛰기
            search(index, wantIndex, want, line); // search 또다시 재귀
        }else{ // 원하는 범위내에 동일하지 않은 경우
            index++;
            wantIndex++;
            search(index, wantIndex, want, line);
        }
    }
}

// 찾으면 index += want길이 , 못찾으면 계속 증가하면서
// 1) 무한재귀는 메소드의 종료 조건이 없어 무한히 호출될 수 있음 => (해결)반복문 사용
// 2) 재귀호출중에 전역변수 초기화는 그동안의 값을 무시하는 원인

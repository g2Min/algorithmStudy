package 프로그래머스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Stack;

public class 하노이의_탑 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.parseInt(br.readLine());
        LinkedList<int[]> result = new LinkedList<>();
    }
    static LinkedList<int[]> result = new LinkedList<>();
    public static int[][] solution(int n){
        int[][] answer = {};
        Hanoi(n, 1, 2, 3);
        answer = linkedListToArray(result);
        return answer;
    }
    public static void Hanoi(int n, int start, int mid, int to){
        // 이동할 원반의 수가 1개인 경우
        if(n == 1){
            result.add(new int[] {start, to});
            return;
        }

        // n-1개의 물건을 A -> B로 이동
        Hanoi(n-1, start, to, mid);

        // 1개의 물건을 A -> C 로 이동
        result.add(new int[] {start, to});

        // n-1개의 물건은 B -> C로 이동
        Hanoi(n-1, mid, start, to);
    }
    public static int[][] linkedListToArray(LinkedList<int[]> linkedList) {
        // LinkedList의 크기로 int[][] 배열을 생성
        int size = linkedList.size();
        int[][] array = new int[size][];

        // LinkedList의 각 int[]를 int[][] 배열에 복사
        for (int i = 0; i < size; i++) {
            array[i] = linkedList.get(i);
        }

        return array;
    }
}

/* 한번에 하나의 원판만 옮김 / 스택으로 생각 / 숫자와 상관없어보임..
1) n개가 있다고 하면 (n-1)까지 1-> 2 로 옮김
2) 마지막 n번째 1 -> 3 으로 옮김
3) 1~(n-1) 까지의 원판들이 잇으면 (n-2)까지 2->1 로 옮김
4) 마지막 (n-1)번째 2 -> 3 으로 옮김
... 이런식으로 empty 가 아닐때까지 반복
* */
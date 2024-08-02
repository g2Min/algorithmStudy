package 프로그래머스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 카드_뭉치 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] cards1 = {"i", "water", "drink"};
        String[] cards2 = {"want", "to"};
        String[] goal = {"i", "want", "to", "drink", "water"};

        System.out.print(solution(cards1, cards2, goal));
    }
    public static String solution(String[] cards1, String[] cards2, String[] goal){
        String answer = "Yes";
        Queue<String> c1 = new LinkedList<>();
        Queue<String> c2 = new LinkedList<>();

        for(int i=0; i< cards1.length; i++){
            c1.offer(cards1[i]);
        }
        for(int i=0; i< cards2.length; i++){
            c2.offer(cards2[i]);
        }
        for(int i=0; i<goal.length; i++){
            if(c1.peek() != null && c1.peek().equals(goal[i])){
                c1.poll();
            } else if(c2.peek() != null && c2.peek().equals(goal[i])){
                c2.poll();
            } else {
                answer = "No";
                break;
            }
        }

        return answer;
    }
}

/* 카드뭉치 2개 중 1개에서 1장의 카드 선택 -> 사용된 카드는 폐기
* 카드뭉치에서는 무조건 순서대로 => 큐로만 해서 되는일이 아닌듯
* */
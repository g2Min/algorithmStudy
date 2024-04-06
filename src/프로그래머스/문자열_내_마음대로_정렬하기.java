package 프로그래머스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class 문자열_내_마음대로_정렬하기 {
        static String[] answer = new String[3];
        public static void solution(String[] strings, int n) {
            int len = answer.length;
            String[][] words = new String[len][len];
            //answer배열에서 n번째 인덱스들만 2차원배열[0] + 나머지단어 2차원배열[1]
            for(int i=0; i<len; i++){
                char[] cha = answer[i].toCharArray(); //단어를 배열로
                words[i][0] = Character.toString(cha[n]);
                words[i][1] = answer[i];
            }

            Arrays.sort(words, new Comparator<String[]>(){
                @Override
                public int compare(String[] o1, String[] o2){
                    if(o1[0].toString().contentEquals(o2[0].toString())){ //0번 인덱스가 동일한 경우 -> 1번인덱스끼리 비교
                        return o1[1].toString().compareTo(o2[1].toString());
                    }else{ // 아닌 경우 0번인덱스끼리 비교
                        return o1[0].toString().compareTo(o2[0].toString());
                    }
                }
            });

            //words에 맞춰 answer재배열
            for(int i=0; i<len; i++){
                answer[i] = words[i][1];
            }
//            return answer;
        }
        public static void main(String[] args)throws IOException{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            for(int i=0; i<3; i++){
                answer[i] = br.readLine();
            }
            int N = Integer.parseInt(br.readLine()); // n번째 인덱스
            solution(answer, N);

            for(int i=0; i<3; i++){
                System.out.println(answer[i]);
            }
        }
// n: 몇번째 인덱스
// 2차원배열로 만들어서 1번 인덱스는 n번째 인덱스 애들만 넣음
// 2번 인덱스는 word전체
}


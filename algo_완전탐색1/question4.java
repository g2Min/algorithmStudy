package algo_완전탐색1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class question4 {
    public  static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str;
        ArrayList<Integer> list = new ArrayList<>();
        // list에는 입력받은 10명의 난쟁이 키가 들어있음
        for(int i=0; i<10; i++){
            str = new StringTokenizer(br.readLine());
            list.add(Integer.parseInt(str.nextToken()));
        }
        // list 순회하면서 7명을 골라 더하면서 100인 경우 continue
//        for(int i=1; i<=10; i++){
//            for(int j=)
//        }



    }
}

// 일곱난쟁이
// 가져온 값들을 모두 담아 또다시 완탐으로 그 합이 100이 되는 경우
// result
// arraylist 로 collections.sort() 진행하자

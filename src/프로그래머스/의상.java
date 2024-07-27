package 프로그래머스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class 의상 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[][] clothes = new String[3][2]; //0번인덱스: 상품명  1번인덱스: 종류
        StringTokenizer str;
        for(int i=0; i<3; i++){
            String lines = br.readLine();
            for(int j=0; j<2; j++){
                str = new StringTokenizer(lines);
                clothes[i][j] = str.nextToken();
            }
        }

    }
    public static int solution(String[][] clothes){
        int answer = 1;
        HashMap<String, List<String>> map = new HashMap<>();

        for(int i=0; i<clothes.length; i++){
            String key = clothes[i][1];
            String value = clothes[i][0];
            if(!map.containsKey(clothes[i][1])){
               map.put(key, new ArrayList<>(List.of(value)));
            }else{
               List<String> values = map.get(key);
               values.add(value);
               map.replace(key, values);
            }
        }

        for(String key: map.keySet()){
            int size = map.get(key).size();
            answer *= (size+1);
        }
        answer -= 1;
        return answer;
    }
}

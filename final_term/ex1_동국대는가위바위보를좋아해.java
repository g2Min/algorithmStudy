package final_term;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class ex1_동국대는가위바위보를좋아해 {
    static TreeMap<String, Integer> map;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str;
        str = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(str.nextToken());// 학생수
        int M = Integer.parseInt(str.nextToken());// 가위바위보를 한 횟수
        map = new TreeMap<>();
        // 학생별 입력받은 좋아하는 가위바위보
        for(int i=0; i<N; i++){
            str = new StringTokenizer(br.readLine());
            String name = str.nextToken(); // 학생이름
            String valueName = str.nextToken(); // 학생이 좋아하는 가위바위보
            if(!map.containsKey(name)) map.put(name, 0);
            if(valueName.equals("rock")){
                map.replace(name, 0);
            }else if(valueName.equals("paper")){
                map.replace(name, 1);
            }else{
                map.replace(name, 2);
            }
        }
        //수업도중 가위바위보를 해서 바뀐 애들
        for(int j=0; j<M; j++){
            str = new StringTokenizer(br.readLine());
            String A = str.nextToken(); //첫번째 학생
            String B = str.nextToken(); //두번째 학생
            func(A, B);
        }

        for(String key:map.keySet()){
            String value = "rock";
            if(map.get(key)==0){
                value = "rock";
            }else if(map.get(key)==1){
                value = "paper";
            }else{
                value = "scissors";
            }
            System.out.println(key + " " + value);
        }
    }
    public static void func(String A1, String B1){
        int A = map.get(A1);
        int B = map.get(B1);

        if(A == 0){
            if(B == 1){
                map.replace(A1, 2);
            } else if(B == 2){
                map.replace(B1, 1);
            }
        }
        if(A == 1){
            if(B == 0){
                map.replace(B1, 2);
            }else if(B == 2){
                map.replace(A1, 0);
            }
        }
        if(A == 2){
            if(B == 0){
                map.replace(A1, 1);
            }else if(B == 1){
                map.replace(B1, 0);
            }
        }
    }
}

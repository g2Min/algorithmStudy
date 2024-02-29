package algo_셋맵;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class ex2_출퇴근 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 입력될 명령줄 개수
        StringTokenizer str;
        TreeSet<String> hset = new TreeSet<>();
        for(int i=0; i<N; i++){
            str = new StringTokenizer(br.readLine());
            String X = str.nextToken();
            String line = str.nextToken();
            if(line.equals("enter")){
                hset.add(X);
            }else{
                hset.remove(X);
            }
        }
        int x = hset.size();
        System.out.println(x);
        for(String name: hset){
            System.out.println(name);
        }
    }
}

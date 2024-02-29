package algo_셋맵;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class ex3_도서관 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 대여한 횟수
        TreeMap<String, Integer> map = new TreeMap<>();
        for(int i=0; i<N; i++){
            String bookLine = br.readLine();
            if(!map.containsKey(bookLine)) map.put(bookLine, 0);
            map.replace(bookLine, map.get(bookLine)+1);
        }

        int max = 0;
        String ans = new String();
        for(String book: map.keySet()){
            if(max < map.get(book)){
                max = map.get(book);
                ans = book;
            }
        }
        System.out.println(ans);
    }
}

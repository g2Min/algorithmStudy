package algo_셋맵;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class ex1_서로다른수 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer str = new StringTokenizer(br.readLine());
        HashSet<Integer> hset = new HashSet<>();
        for(int i=0; i<N; i++){
            hset.add(Integer.parseInt(str.nextToken()));
        }
        System.out.print(hset.size());

    }
}

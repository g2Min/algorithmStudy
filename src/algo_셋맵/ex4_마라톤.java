package algo_셋맵;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;

public class ex4_마라톤 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=1; i<=N; i++){
            String name = br.readLine();
            if(!map.containsKey(name)) map.put(name, 0);
            map.replace(name, map.get(name)+1);
        }
        for(int i=1; i<=N-1; i++){
            String name = br.readLine();
            if(map.containsKey(name)) map.replace(name, map.get(name)-1);
        }

        for(String key:map.keySet()){
            if(map.get(key) == 1){
                System.out.println(key);
            }
        }
    }
}

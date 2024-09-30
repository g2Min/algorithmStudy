package algo_완전탐색1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class 일곱_난쟁이 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> arr = new ArrayList<>();
        int sum = 0;
        for(int i=0; i<9; i++){
            int num = Integer.parseInt(br.readLine());
            arr.add(num);
            sum += num;
        }
        Collections.sort(arr);
        int diff = sum - 100;

        boolean find = false;
        int removeIndex1 = -1;
        int removeIndex2 = -1;
        for(int i=0; i<9; i++){
            for(int j=i+1; j<9; j++){
                int total = arr.get(i) + arr.get(j);
                if(total == diff){
                    removeIndex1 = i;
                    removeIndex2 = j;
                    find = true;
                    break;
                }
            }
            if(find){
                break;
            }
        }

        arr.remove(removeIndex2);
        arr.remove(removeIndex1);
        for(int i=0; i<7; i++){
            System.out.println(arr.get(i));
        }

    }
}

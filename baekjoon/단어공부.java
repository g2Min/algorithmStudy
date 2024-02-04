package baekjoon;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 단어공부 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int[] alphabet = new int[26];
        Arrays.fill(alphabet, 0);
        for(int i=0; i<input.length(); i++){
            int index = 0;
            if(input.charAt(i) >= 'a'){
                index = input.charAt(i) - 'a';
            }else{
                index = input.charAt(i) - 'A';
            }
            alphabet[index]++;
        }

        int max = 0; // max를 가지는 index
        int duplicate = 0;
        for(int i=0; i<26; i++){
            for(int j=0; j<26; j++){
                if(alphabet[max] < alphabet[j]){
                    max = j;
                    duplicate = 0;
                }
                if(max!=j && alphabet[max] == alphabet[j]){
                    duplicate++;
//                    System.out.print(max + " ");
                }
            }
        }

        if(duplicate == 0){
            System.out.print((char)(max+65));
        }else{
            System.out.print("?");
        }
    }
}
// 65(대문자) - 97(소문자) = 32
// 26*2=52
// alphabet = { A, B, C, ... ,Z }
// 오름차순은 필요없고 최댓값을 지닌 부분의 index를 알면됨

// 0 1 9 7 6
// 8 0 1 9 9 2
// 0 0 0 0 1
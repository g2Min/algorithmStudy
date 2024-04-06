package baekjoon.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 단어공부_upgrade {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine().toUpperCase();

        int maxCount = -1;
        char maxAlpha = '?';
        for(char alp = 'A'; alp<='Z'; alp++){
            int count = getAlphabetCount(line, alp);
            if(count > maxCount){
                maxCount = count;
                maxAlpha = alp;
            }else if(count == maxCount){
                maxAlpha = '?';
            }
        }
        System.out.print(maxAlpha);
    }
    public static int getAlphabetCount(String str, char alp){
        int count = 0;
        for(int i=0; i<str.length(); i++){
            if(alp == str.charAt(i)) count++;
        }
        return count;
    }

}

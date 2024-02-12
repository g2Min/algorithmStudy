package baekjoon.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 소금폭탄 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] current = br.readLine().split(":");
        String[] salty = br.readLine().split(":");
        int currentHour = Integer.parseInt(current[0]);
        int currentMinute = Integer.parseInt(current[1]);
        int currentSecond = Integer.parseInt(current[2]);
        int saltHour = Integer.parseInt(salty[0]);
        int saltMinute = Integer.parseInt(salty[1]);
        int saltSecond = Integer.parseInt(salty[2]);
        int cntAmount = currentHour * 3600 + currentMinute * 60 + currentSecond;
        int saltAmount = saltHour * 3600 + saltMinute * 60 + saltSecond ;
        int minus = saltAmount - cntAmount;
        if(minus < 0) {
            minus += 24 * 3600;
        }
        int needHour = minus / 3600;
        int needMinute = (minus % 3600) / 60;
        int needSecond = minus % 60;

        if(minus == 0){
            System.out.print("24:00:00");
        }else{
            System.out.printf("%02d:%02d:%02d", needHour, needMinute, needSecond);
        }
    }
}

// 1) 시간 => 작은 수 - 큰수 인경우 : (작은 수) + 24
// 2) 분/초 => 작은 수 - 큰수 인 경우 : (작은수) + 60
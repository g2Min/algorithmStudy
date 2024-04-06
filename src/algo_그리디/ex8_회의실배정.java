package algo_그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

class Meeting implements Comparable<Meeting>{
    private int start, end;

    public Meeting(int start, int end){
        this.start = start;
        this.end = end;
    }
    public int getStart() {
        return this.start;
    }
    public int getEnd(){
        return this.end;
    }

    public int compareTo(Meeting x){
        return getEnd() - x.getEnd();
    }
}
public class ex8_회의실배정 {
    static ArrayList<Meeting> meetings = new ArrayList<>();
    static int N;
    static int cnt =0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer str;
        for(int i=0; i<N; i++){
            str = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(str.nextToken());
            int end = Integer.parseInt(str.nextToken());
            meetings.add(new Meeting(start, end));
        }
        Collections.sort(meetings);

        int end=0, cnt=0;
        for(int i=0; i<N; i++){
            if(meetings.get(i).getStart() >= end){
                cnt++;
                end = meetings.get(i).getEnd();
            }
        }
        System.out.print(cnt);
    }
}

// 하나를 선택하고 마지막 수보다 큰 애들로 시작하는 경우
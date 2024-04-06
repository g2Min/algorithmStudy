package algo_완전탐색2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class question3 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st1.nextToken()); // 기존표지의 개수
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        String newOne = st2.nextToken(); // 새 표지
        char[] news = newOne.toCharArray();
        int sum=0;

        for(int i=0; i<num; i++){
            String Str = br.readLine();
            char[] str = Str.toCharArray();
            boolean pos = false;
            for(int j=0; j<str.length; j++){
                for(int d=1; d<str.length; d++){
                    if(j + (news.length-1) * d >= str.length) continue;
                    boolean same = true;
                    for(int k=0; k<news.length; k++){
                        if(news[k] != str[ j + k * d]) {
                            same = false;
                        }
                    }
                    if( same == true){
                        pos = true;
                    }
                }
            }
            if(pos == true){
                sum++;
            }
        }

        System.out.println(sum);

    }
}

//표지
// 한칸씩 떨어진 부분에 대해서도 적용이 되어야 함
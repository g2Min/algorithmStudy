package algo_DFS1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _0을_만들자 {
    static StringBuilder sb = new StringBuilder();
    static int N;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dfs(1, 0, 1, "1");
        System.out.print(sb);
    }
    static void dfs(int x, int res, int temp, String form){
        if(x==N){
            int result = res+temp;
            if(result == 0) sb.append(form).append('\n');
            return;
        }

        int newtemp;
        if(temp>0) newtemp = temp*10 + x+1;
        else newtemp = temp*10 - (x+1);

       //마지막에 연산자가 없는 경우
        dfs(x+1, res, newtemp, form+' '+(char)((x+1)+'0'));
        //연산자가 +로 연달아 있는 경우
        dfs(x+1, res+temp, x+1, form+'+'+(char)((x+1)+'0'));
        //연산자가 -로 연달아 있는 경우
        dfs(x+1, res+temp, -(x+1), form+'-'+(char)((x+1)+'0'));
    }
}

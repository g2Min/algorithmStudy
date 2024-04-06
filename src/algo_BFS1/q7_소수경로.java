package algo_BFS1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class q7_소수경로 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str1 = new StringTokenizer(br.readLine());
        int test = Integer.parseInt(str1.nextToken()); // 입력받을 테스트케이스 수
        ArrayList<Integer> list = new ArrayList<>();
        StringTokenizer str2;
        for(int i=0; i<test; i++){
            str2 = new StringTokenizer(br.readLine());
            int prev = Integer.parseInt(str2.nextToken());
            int next = Integer.parseInt(str2.nextToken());


        }
    }

    //에라토스테네스의 체
    public static boolean isPrime(int n){
        if(n<2){
            return false;
        }else{
            for(int i=2; i<n; i++){
                if(n%i == 0) return false;
            }
            return true; // 소수인경우
        }
    }

    // 천-백-십-일의 자리로 만드는법
    public static ArrayList<Integer> getList(int x){
        ArrayList<Integer> arr = new ArrayList<>();
        for(int k=1; k<= 1000; k*=10){
            for(int i=0; i<10; i++){
                int tmp = x - ((x/k)%10)*k + i*k;
                if(isPrime(tmp) == true && x != tmp && tmp>=1000 ) arr.add(tmp);
            }
        }
        return arr;
    }
}

//
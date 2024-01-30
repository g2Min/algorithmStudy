package algo_시간복잡도;

import java.util.*;

public class question4 {
    static String findCharacter(int x){
        String welcom1 = "Hello ";
        String welcom2 = "Algo ";
        int a = welcom1.length();
        int b = welcom1.length() + welcom2.length();

        //x가 원하는 문자열 개수보다 큰경우
        while(x > b){
            int temp = b;
            b += a;
            a = temp;
        }

        //x가 "Hello" 이거나 "Hello Algo"에 도달할때까지
        while( x > welcom1.length()){
            if( x > a ){
                x -= a;
            }else{
                b = a;
                a = b - welcom1.length() - welcom2.length();
            }
        }

        //x번째 문자 찾기
        String result = ( x <= welcom1.length()) ? welcom1 : welcom2;
        char ch = result.charAt((int)x -1 );
        return(ch == ' ') ? "Hello Algo" : Character.toString(ch);
    }
    public static void main( String[] args){
        Scanner sc = new Scanner(System.in);
        int limits = sc.nextInt();
        int[] wants = new int[limits];
        for(int i=0; i<limits; i++){
            wants[i] = sc.nextInt();
        }
        sc.close();
        for(int j=0; j<limits; j++){
            int x = wants[j];
            System.out.println(findCharacter(x));
        }
    }
}

// hello(3) = hello(2) + " " + hello(1)
// hello(N)의 x 번째 글자
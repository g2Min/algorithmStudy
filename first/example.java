package first;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class example {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 입력받은 행에서 공백단위로 구분하여 호출할 수 있음.
        StringTokenizer st = new StringTokenizer(br.readLine());
        String arr[] = br.readLine().split(" ");
        System.out.println(arr);

    }
}

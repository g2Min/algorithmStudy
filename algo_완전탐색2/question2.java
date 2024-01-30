package algo_완전탐색2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class question2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st1.nextToken()); // 앞으로 입력받을 개수
        StringTokenizer st2;
        int[][] arr = new int[num][2]; // 입력받은 변수들

        for(int i=0; i<num; i++){
            st2 = new StringTokenizer(br.readLine());
            for(int j=0; j<2; j++){
                arr[i][j] = Integer.parseInt(st2.nextToken());
            }
        }

        // 각 좌표마다의 길이함수
        int[] length = new int[num];
        for(int i=0; i<num; i++){
            ArrayList<Integer> list = new ArrayList<>();// 각 좌표마다 갖는 길이값
            for(int j=0; j<num; j++){
                if(arr[i][1] == arr[j][1] && i!=j){
                    list.add(Math.abs(arr[i][0] - arr[j][0]));
                }
            }
            Collections.sort(list);
            length[i] = list.get(0);
        }

        // 출력값
        int sum = 0;
        for(int i=0; i<length.length; i++){
            sum+=length[i];
        }
        System.out.println(sum);
    }
}

// (x: 점의 좌표, y: 색깔)
// **가장 가까운 점이 두개이상이면 아무거나 선택한다
// y의 색깔이 동일하고, x끼리의 차가 가장 작은 점 => 이 차이를 저장
package middle_term;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ex2_수강신청 {
    static int[] sub;
    static int num;
    static ArrayList<int[]> friends;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str1 = new StringTokenizer(br.readLine());
        sub = new int[3]; // 지수가 담은 전체 과목
        for (int i = 0; i < 3; i++) {
            sub[i] = Integer.parseInt(str1.nextToken());
        }

        StringTokenizer str2 = new StringTokenizer(br.readLine());
        num = Integer.parseInt(str2.nextToken()); // 친구수
        StringTokenizer str3;
        friends = new ArrayList<>(); // 친구들이 담은 과목들
        for (int i = 0; i < num; i++) {
            str3 = new StringTokenizer(br.readLine());
            friends.add(new int[]{Integer.parseInt(str3.nextToken()), Integer.parseInt(str3.nextToken())});
        }

        ans = 0;
        findCombis();
        System.out.println(ans);
    }
    public static void findCombis() {
        for(int i=0; i<friends.size(); i++){
            for(int j=i+1; j<friends.size(); j++){
                int coverCount = 0;
                for(int k=0; k<3; k++){
                    if(isCovered(friends.get(i), sub[k]) || isCovered(friends.get(j), sub[k])){
                        coverCount ++;
                    }
                }
                if(coverCount == 3){
                    ans++;
                }
            }
        }
    }

    public static boolean isCovered(int[] friendCourses, int course){
        return friendCourses[0] == course || friendCourses[1] == course;
    }

}

//2개씩 순회하면서 -> 전부 방문하면 ans++ + 초기화 -> 나머지 순회
// visited[] 가 있다고 좋은 것은 아니다 => 동일한 재열에 대해 boolean을 참조하는 경우 아래에서 초기화시킨게 위에서는 없을 수 있다.
// 절대 과목을 중복으로 수강신청할 수 없음

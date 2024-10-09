package algo_BFS1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 스택 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Stack<Integer> stack = new Stack<>();

        while (true) {
            String input = br.readLine();
            st = new StringTokenizer(input);
            String command = st.nextToken();

            if (command.equals("end")) {
                break; // 프로그램 종료
            }

            switch (command) {
                case "push":
                    int number = Integer.parseInt(st.nextToken());
                    sb.append(number).append("\n"); // push 명령어는 값을 출력해야 함
                    stack.push(number); // 스택에 숫자 추가
                    break;

                case "pop":
                    if (stack.isEmpty()) {
                        sb.append("-1").append("\n");
                    } else {
                        sb.append(stack.pop()).append("\n"); // 스택의 최상단 값을 제거하고 출력
                    }
                    break;

                case "size":
                    sb.append(stack.size()).append("\n"); // 스택의 크기 출력
                    break;

                case "empty":
                    if (stack.isEmpty()) {
                        sb.append("1").append("\n"); // 스택이 비어 있으면 1
                    } else {
                        sb.append("0").append("\n"); // 비어 있지 않으면 0
                    }
                    break;

                case "top":
                    if (stack.isEmpty()) {
                        sb.append("-1").append("\n"); // 스택이 비어 있으면 -1 출력
                    } else {
                        sb.append(stack.peek()).append("\n"); // 스택의 최상단 값 출력
                    }
                    break;
            }
        }

        System.out.print(sb); // 모든 명령 처리 후 한 번에 출력
    }
}

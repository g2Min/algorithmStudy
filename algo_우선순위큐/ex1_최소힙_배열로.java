package algo_우선순위큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ex1_최소힙_배열로 {
    static int[] tree;
    static int size = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 연산 개수
        tree = new int[3*N];
        for(int i=1; i<=N; i++){
            int num = Integer.parseInt(br.readLine()); // 입력받은 숫자들
            if(num == 0){
                System.out.println(remove());
            }
            if(num != 0){
                add(num);
            }
        }
    }
    private static void add(int x){
        tree[++size] = x;
        int idx = size;
        while(idx > 1){
            if(tree[idx] < tree[idx/2]){
                int temp = tree[idx];
                tree[idx] = tree[idx/2];
                tree[idx/2] = temp;
            }
            else break;
            idx /= 2;
        }
    }

    private static int remove(){
        if(size == 0) return 0;
        int top = tree[1];

        tree[1] = tree[size];
        tree[size--] = 0;
        int idx = 1;
        while(idx*2 <= size){
            int l = idx*2, r= idx*2+1;

            if((r>size || tree[l]<tree[r]) && tree[idx]>tree[l]){
                int temp = tree[l];
                tree[l] = tree[idx];
                tree[idx] = temp;
                idx = l;
            }else if(r<=size && tree[idx]>tree[r]){
                int temp = tree[r];
                tree[r] = tree[idx];
                tree[idx] = temp;
                idx = r;
            }else break;
        }
        return top;
    }
}

// 우선순위 큐일때 가장 작은 값 => tree[1] , 최소 힙 제거 => idx --

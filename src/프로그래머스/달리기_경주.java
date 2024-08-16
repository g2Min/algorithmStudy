package 프로그래머스;

import java.util.HashMap;
import java.util.Map;

public class 달리기_경주 {
    public String[] solution(String[] players, String[] callings) {
        Map<String,Integer> map=new HashMap<>();
        for(int i=0;i<players.length;i++){
            map.put(players[i],i);
        }

        for (String calling : callings) {
            int index=map.get(calling);
            String loser=players[index-1];
            players[index-1]=calling;
            players[index]=loser;
            map.put(calling,index-1);
            map.put(loser,index);
        }
        return players;
    }
}

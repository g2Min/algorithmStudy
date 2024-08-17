package 프로그래머스;

import java.util.HashMap;
import java.util.Map;

public class 할인_행사 {
    private Map<String, Integer> wantProfile;
    //현재 할인 받을 수 있는 물품의 종류와 각 종류의 개수
    private Map<String, Integer> discountProfile;
    //할인 받을 수 있는 물품 목록에 물품을 추가한다.
    private void add(String discountItem) {
        Integer freq = discountProfile.get(discountItem);
        if (freq==null) discountProfile.put(discountItem, 1);
        else discountProfile.put(discountItem, freq+1);
    }
    //할인 받을 수 있는 물품 목록에 물품을 제거한다.
    private void remove(String discountItem) {
        Integer freq = discountProfile.get(discountItem);
        if (freq==null || freq<=1) discountProfile.remove(discountItem);
        else discountProfile.put(discountItem, freq-1);
    }
    //정현이가 할인 받기를 원하는 물품을 전부 할인 받을 수 있는지 여부를 확인한다.
    private boolean checkContainess() {
        for (Map.Entry<String, Integer> entry:wantProfile.entrySet()) {
            if (!discountProfile.containsKey(entry.getKey()) || discountProfile.get(entry.getKey())<entry.getValue())
                return false;
        }
        return true;
    }

    public int solution(String[] want, int[] number, String[] discount) {
        //step a. wantProfile 및 (첫째 날 가입할 때의) discountProfile을 구성한다.
        {
            wantProfile = new HashMap<>();
            final int wantLength = want.length;
            for (int i=0; i<wantLength; i++)
                wantProfile.put(want[i], number[i]);
            discountProfile = new HashMap<>();
            for (int i=0; i<10; i++)
                add(discount[i]);
        }
        //할인 받을 수 있는 날짜 수
        int result = 0;

        int left = 0, right = 9, discountLength = discount.length;
        //가입하는 날짜를 하루 씩 미루면서 할인 받을 수 있는지 여부를 확인한다.
        while (true) {
            if (checkContainess())
                result++;
            right++;
            if (right==discountLength) break;
            add(discount[right]);
            remove(discount[left]);
            left++;
        } //while loop
        return result;
    }
}

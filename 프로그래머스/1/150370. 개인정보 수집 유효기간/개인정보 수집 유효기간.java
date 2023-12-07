import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public static List<Integer> solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();

        // 0. today의 날을 일자로 환산
        String[] todayDateInfo = today.split("\\.");
        int dateCountOfToday = getDate(todayDateInfo);

        // 1. 약관을 map에 저장한다.
        HashMap<String, Integer> typeOfTerms = new HashMap<>();
        for (String term : terms) {
            typeOfTerms.put(term.split(" ")[0], Integer.parseInt(term.split(" ")[1]));
        }

        // 2. 날을 모두 더해서 today와 비교한다.
        for (int i = 0; i < privacies.length; i++) {
            String[] privacy = privacies[i].split(" ");
            String[] privacyDateInfo = privacy[0].split("\\.");
            int termMonthOfPrivacy = typeOfTerms.get(privacy[1]);
            int dateCountOfPrivacy = getDate(privacyDateInfo);
            if (isDestroyed(dateCountOfToday, dateCountOfPrivacy, termMonthOfPrivacy)) {
                answer.add(i + 1);
            }
        }
        return answer;
    }

    private static boolean isDestroyed(int dateCountOfToday, int dateCountOfPrivacy, int termMonthOfPrivacy) {
        if (dateCountOfToday >= getDateWithTerm(dateCountOfPrivacy, termMonthOfPrivacy)) {
            return true;
        }
        return false;
    }

    private static int getDate(String[] dateInfo) {
        int dateOfYear = Integer.parseInt(dateInfo[0]) * 12 * 28;
        int dateOfMonth = Integer.parseInt(dateInfo[1]) * 28;
        int dateOfDay = Integer.parseInt(dateInfo[2]);
        return dateOfYear + dateOfMonth + dateOfDay;
    }

    private static int getDateWithTerm(int dateCountOfPrivacy, int termMonthOfPrivacy) {
        return dateCountOfPrivacy + termMonthOfPrivacy * 28;
    }
}


class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> sCount = new HashMap<>();
        Map<Character, Integer> tCount = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            if (!tCount.containsKey(t.charAt(i))) {
                tCount.put(t.charAt(i), 0);
            }
            tCount.put(t.charAt(i), tCount.get(t.charAt(i))+1);
        }

        int left = 0, have = 0, leftAns = 0, need = tCount.size(), minLen = Integer.MAX_VALUE;


        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            if (!tCount.containsKey(rightChar)) continue;

            sCount.put(rightChar, sCount.getOrDefault(rightChar, 0)+1);

            if (sCount.get((rightChar)).equals(tCount.get(rightChar))) {
                have+=1;
            }

            while (have == need) {
                if (minLen > right - left + 1) {
                    minLen = right - left + 1;
                    leftAns = left;
                }

                char leftChar = s.charAt(left);
                if (tCount.containsKey(leftChar)) {
                    sCount.put(leftChar, sCount.get(leftChar) - 1);

                    if (tCount.get(leftChar) > sCount.get(leftChar)) {
                        have--;
                    }
                }

                left += 1;
            }
        }

        if (minLen < Integer.MAX_VALUE) {
            return s.substring(leftAns, leftAns + minLen);
        }
        return "";
    }
}
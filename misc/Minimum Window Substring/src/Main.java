class Main {
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
            if (!tCount.containsKey(s.charAt(right))) continue;

            sCount.put(s.charAt(right), sCount.getOrDefault(s.charAt(right), 0)+1);

            if (tCount.containsKey(s.charAt(right)) && sCount.get((s.charAt(right))) .equals(  tCount.get(s.charAt(right) ))) {

                have+=1;
            }

            while (have == need) {
                if (minLen > right - left + 1) {
                    minLen = right - left + 1;
                    leftAns = left;
                }

                if (tCount.containsKey(s.charAt(left))) {
                    sCount.put(s.charAt(left), sCount.get(s.charAt(left)) - 1);

                    if (tCount.containsKey(s.charAt(left)) && tCount.get(s.charAt(left)) > sCount.get(s.charAt(left))) {
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
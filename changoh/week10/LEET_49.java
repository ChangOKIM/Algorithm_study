import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);

            String key = new String(chars);

            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }

            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());
    }
}

/*
import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();

        List<Boolean> used = new ArrayList<>();

        for (int i = 0; i < strs.length; i++) {
            used.add(false);
        }

        for (int i = 0; i < strs.length; i++) {
            if (used.get(i)) {
                continue;
            }

            List<String> group = new ArrayList<>();
            group.add(strs[i]);
            used.set(i, true);

            for (int j = i + 1; j < strs.length; j++) {
                if (used.get(j)) {
                    continue;
                }

                if (isAnagram(strs[i], strs[j])) {
                    group.add(strs[j]);
                    used.set(j, true);
                }
            }

            result.add(group);
        }

        return result;
    }

    private boolean isAnagram(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }

        char[] arrA = a.toCharArray();
        char[] arrB = b.toCharArray();

        Arrays.sort(arrA);
        Arrays.sort(arrB);

        return Arrays.equals(arrA, arrB);
    }
}
 */

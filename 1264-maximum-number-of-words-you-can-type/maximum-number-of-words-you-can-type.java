class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        // Convert broken letters into a set for quick lookup
        boolean[] broken = new boolean[26];
        for (char c : brokenLetters.toCharArray()) {
            broken[c - 'a'] = true;
        }

        String[] words = text.split(" ");
        int count = 0;

        // Check each word
        for (String word : words) {
            boolean canType = true;
            for (char c : word.toCharArray()) {
                if (broken[c - 'a']) {
                    canType = false;
                    break;
                }
            }
            if (canType) count++;
        }

        return count;
    }
}

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();

        if (n1 > n2) {
            return false;
        }

        int[] s1Counts = new int[26];
        int[] s2Counts = new int[26];

        // Initialize frequency counts
        for (int i = 0; i < n1; i++) {
            s1Counts[s1.charAt(i) - 'a']++;
            s2Counts[s2.charAt(i) - 'a']++;
        }

        if (areEqual(s1Counts, s2Counts)) {
            return true;
        }

        // Slide the window
        for (int i = n1; i < n2; i++) {
            s2Counts[s2.charAt(i) - 'a']++;         // add new char
            s2Counts[s2.charAt(i - n1) - 'a']--;    // remove old char

            if (areEqual(s1Counts, s2Counts)) {
                return true;
            }
        }

        return false;
    }

    // Helper method to compare two arrays
    private boolean areEqual(int[] arr1, int[] arr2) {
        for (int i = 0; i < 26; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }
}

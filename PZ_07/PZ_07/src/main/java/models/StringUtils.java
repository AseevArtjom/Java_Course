package models;

public class StringUtils {

    public boolean isPalindrome(String str) {
        String cleanStr = str.replaceAll("\\s+", "").toLowerCase();
        return cleanStr.equals(new StringBuilder(cleanStr).reverse().toString());
    }

    public long countVowels(String str) {
        return str.chars()
                .filter(c -> "aeiouAEIOU".indexOf(c) != -1)
                .count();
    }

    public long countConsonants(String str) {
        return str.chars()
                .filter(c -> "bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ".indexOf(c) != -1)
                .count();
    }

    public int countOccurrences(String str, String word) {
        return (str.length() - str.replace(word, "").length()) / word.length();
    }
}

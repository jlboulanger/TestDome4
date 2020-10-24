public class Palindrome {
    public static boolean isPalindrome(String word) {
        final String lcaseWord = word.toLowerCase();
        final int l = word.length();
        for (int i = 0; i < l; ++i)
            if (lcaseWord.charAt(i) != lcaseWord.charAt(l-i-1))
                return false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println(Palindrome.isPalindrome("Deleveled"));
    }
}

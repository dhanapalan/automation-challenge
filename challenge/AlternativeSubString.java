
public class AlternativeSubString {

    public static String longestAlternatingSubstring(String digits) {
        String longestSubstring = "";
        String currentSubstring = "";
        boolean isOdd = (digits.charAt(0) - '0') % 2 != 0;
        
        for (int i = 0; i < digits.length(); i++) {
            boolean digitIsOdd = (digits.charAt(i) - '0') % 2 != 0;
            
            if (digitIsOdd != isOdd || currentSubstring.length() == 0) {
                currentSubstring += digits.charAt(i);
                isOdd = digitIsOdd;
            } else {
                if (currentSubstring.length() > longestSubstring.length()) {
                    longestSubstring = currentSubstring;
                }
                currentSubstring = "" + digits.charAt(i);
                isOdd = digitIsOdd;
            }
        }
        
        if (currentSubstring.length() > longestSubstring.length()) {
            longestSubstring = currentSubstring;
        }
        
        return longestSubstring;
    }
    
    
    public static void main(String[] args) {
        String digits = "246804862024862208460";
        String longestSubstring = longestAlternatingSubstring(digits);
        System.out.println("Longest alternating substring: " + longestSubstring);
    }
}

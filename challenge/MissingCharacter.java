public class MissingCharacter {

    public static void main(String[] args) {
        String input = "_ABAABAABA";
        char missingChar = findMissingCharacter(input);

        if (missingChar == '\0') {
            System.out.println("There is no pattern");
        } else {
            System.out.println("Missing character: " + missingChar);
        }
    }

    public static char findMissingCharacter(String input) {
        if (!input.contains("_")) {
            return '\0';
        }

        String pattern = "";
        int patternLength = 0;

        // Find the pattern starting from the second character, if the first character is an underscore
        if (input.charAt(0) == '_') {
            for (int i = 1; i <= input.length() / 2; i++) {
                pattern = input.substring(1, i + 1);
                patternLength = pattern.length();

                if (input.substring(1 + patternLength).startsWith(pattern)) {
                    break;
                }
            }
        } else {
            // Find the pattern
            for (int i = 1; i <= input.length() / 2; i++) {
                pattern = input.substring(0, i);
                patternLength = pattern.length();

                if (input.startsWith(pattern) && input.substring(patternLength).startsWith(pattern)) {
                    break;
                }
            }
        }

        // Iterate through the input string and compare it to the pattern
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            char expectedChar = pattern.charAt(i % patternLength);

            if (currentChar == '_' || currentChar != expectedChar) {
                return expectedChar;
            }
        }

        // If there's no missing character or pattern, return a null character
        return '\0';
    }
}

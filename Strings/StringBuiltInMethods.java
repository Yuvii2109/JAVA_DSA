public class StringBuiltInMethods {
    public static void main(String[] args) {
        String str1 = "  Yuvraj Sachdeva  ";
        String str2 = "Java Programming Homework";

        // charAt -> Returns the character at the specified index.
        char charAtExample = str1.charAt(6); // O(1)
        System.out.println("Character at index 6 - " + charAtExample);

        // compareTo -> Compares two strings lexicographically.
        int compareToExample = "A".compareTo("Z"); // O(min(n, m))
        System.out.println("Comparison result - " + compareToExample);

        // concat -> Concatenates the specified string to the end of another string.
        String concatExample = str1.concat(str2); // O(n+m)
        System.out.println("Concatenated string - " + concatExample);

        // contains -> Checks if a string contains a specific sequence of characters.
        boolean containsExample = str2.contains("Program"); // O(n.m)
        System.out.println("Contains 'Program' - " + containsExample);

        // indexOf -> Returns the index of the first occurrence of a specific character or substring.
        int indexOfExample = str2.indexOf("a"); // O(n.m)
        System.out.println("Index of 'a' - " + indexOfExample);

        // isEmpty -> Checks if a string is empty.
        boolean isEmptyExample = str1.isEmpty(); // O(1)
        System.out.println("Is the string empty - " + isEmptyExample);

        // length -> Returns the length of the string.
        int lengthExample = str2.length(); // O(1)
        System.out.println("Length of the string - " + lengthExample);

        // toLowerCase -> Converts all characters in the string to lowercase.
        String toLowerCaseExample = str2.toLowerCase(); // O(n)
        System.out.println("Lowercase - " + toLowerCaseExample);

        // replace -> Replaces occurrences of a specific character or substring with another.
        String replaceExample = str2.replace("Java", "Vinay Sir's"); // O(n.m)
        System.out.println("Replaced string - " + replaceExample);

        // startsWith -> Checks if a string starts with a specified prefix.
        boolean startsWithExample = str2.startsWith("Java"); // O(n)
        System.out.println("Starts with 'Java' - " + startsWithExample);

        // toUpperCase -> Converts all characters in the string to uppercase.
        String toUpperCaseExample = str2.toUpperCase(); // O(n)
        System.out.println("Uppercase - " + toUpperCaseExample);

        // equals -> Compares two strings for equality.
        boolean equalsExample = str1.trim().equals("Hello World"); // O(n)
        System.out.println("Equals 'Hello World' - " + equalsExample);

        // endsWith -> Checks if a string ends with a specified suffix.
        boolean endsWithExample = str2.endsWith("ing"); // O(n)
        System.out.println("Ends with 'ing' - " + endsWithExample);

        // trim -> Removes leading and trailing spaces from the string.
        String trimExample = str1.trim(); // O(n)
        System.out.println("Trimmed string - '" + trimExample + "'");
    }
}
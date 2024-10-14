public class RemovingDuplicates {

    public static void removeDuplicates(String str, int index, StringBuilder newString, boolean map[]) {
        if (index == str.length()) {
            System.out.println(newString);  // Print the final string without duplicates
            return;
        }

        char currentChar = str.charAt(index);

        // Check if the character has been encountered before
        if (map[currentChar - 'a'] == true) {
            // If true, skip adding this character to the new string
            removeDuplicates(str, index + 1, newString, map);
        } else {
            // If false, mark this character as encountered and add it to the new string
            map[currentChar - 'a'] = true;
            removeDuplicates(str, index + 1, newString.append(currentChar), map);
        }
    }

    public static void main(String[] args) {
        String str = "yyyyuuuuvvvvrrrraaaajjjj";
        removeDuplicates(str, 0, new StringBuilder(), new boolean[26]);  // Call the removeDuplicates function
    }
}

// Duplicate Found: If map[currentChar - 'a'] is true, 
// it means currentChar has already been added to newString, 
// so skip adding it again and move to the next character (index + 1).
// Condition: map[currentChar - 'a'] == true ->
// currentChar is the character at the index position in the string. 
// The expression currentChar - 'a' converts the character into an 
// integer index in the range 0-25. This is because 'a' in ASCII is 97, 
// and 'b' is 98, so subtracting 'a' from any character gives us a zero-based index.
// What this does:
// If the value in map[] at that index is true, it means that 
// the character has already been added to the newString.
// Map array jb construct hota hai toh uske saare free spaces boolean main false
// hote hain. Jab hum pehle character ko add karte hain, toh hum
// uske index ko true karte hain. Isliye, jab hum doosre
// character ko check karte hain, toh hum dekhate hain ki uska index
// true hai ya nahi. Agar true hai, toh hum skip karte hain.
// Agar false hai, toh hum uska index true karte hain aur usko add karte hain.

// New Character: If map[currentChar - 'a'] is false, 
// mark currentChar as encountered by setting map[currentChar - 'a'] to true.
// Append currentChar to newString and recursively call removeDuplicates with incremented index.
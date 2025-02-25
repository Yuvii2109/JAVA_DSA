public class ValidAnagram {
    // public boolean isAnagram(String s, String t) {
    //     if(s.length() == t.length()){
    //         char[] arr1 = s.toLowerCase().toCharArray();
    //         char[] arr2 = t.toLowerCase().toCharArray();
    //         Arrays.sort(arr1);
    //         Arrays.sort(arr2);
    //         if(Arrays.equals(arr1, arr2)){
    //             return true;
    //         }
    //     }
    //     return false;
    // }
    // Yeh toh theek hai... but iski time complexity due to sorting becomes O(nlogn)
    // public boolean isAnagram(String s, String t) {
    //     HashMap<Character, Integer> map = new HashMap<>();
    //     for(int i = 0; i < s.length(); i++){
    //         char ch = s.toLowerCase().charAt(i);
    //         map.put(ch, map.getOrDefault(ch, 0) + 1);
    //     }
    //     for(int j = 0; j < t.length(); j++){
    //         char ch = t.toLowerCase().charAt(j);
    //         if(map.containsKey(ch)){
    //             if(map.get(ch) == 1){
    //                 map.remove(ch);
    //             }else{
    //                 map.put(ch, map.get(ch)-1);
    //             }
    //         }else{
    //             return false;
    //         }
    //     }
    //     return map.isEmpty();
    // }
    // Kisi bhai ne aisa test case daal diya hai jisse time hi exceed hogya :')
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        int count[] = new int[26];
        for(int i = 0; i < s.length(); i++){
            count[s.toLowerCase().charAt(i) - 'a']++;
            count[t.toLowerCase().charAt(i) - 'a']--;
        }
        for(int c : count){
            if(c != 0){
                return false;
            }
        }
        return true;
    }
}
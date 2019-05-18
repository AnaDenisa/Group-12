import java.util.HashMap;
import java.util.Map;

final class Anagrams {

  public static boolean checkAnagrams(String s1, String s2) {
    Map<Character, Integer> map = new HashMap<>();
    int len;

    /* anagram strings have to be of the same length */
    if (s1.length() != s2.length()) return false;

    /*
     * two equal strings are anagrams; by checking it in the beginning
     * some computations are saved and the efficiency is improved
     * This check includes the case of empty strings and one character
     * strings as well
     */
    if (s1.equals(s2)) return true;

    /* compute the length of the strings just once */
    len = s1.length();

    for (int i = 0; i < len; i++) {
      char c = s1.charAt(i);

      if (map.containsKey(c)) {
        /* get the number of aparitions of the charcater c that far */
        int val = map.get(c);

        /* increment and update the number of occurances of c in map */
        map.put(c, val + 1);
      } else {
        /* first occurance of c in map */
        map.put(c, 1);
      }
    }

    for (int i = 0; i < len; i++) {
      char c = s2.charAt(i);

      /* a character in s2 did not appear in s1 previously */
      if (!map.containsKey(c)) {
        return false;
      }

      int val = map.get(c);

      /* c occurs in s2 more times than in s1 */
      if (val <= 0) {
        return false;
      }

      map.put(c, val - 1);
    }

    /*
     * if all characters in s2 were enountered in s1 previously and
     * none of them occured more than it occured in s1 and having processed
     * all the characters in s2, s2 is an anagram of s1
     */
    return true;
  }
}

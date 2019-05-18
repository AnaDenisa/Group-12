import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AnagramsTest {

  /** Test of checkAnagrams method, of class Anagrams. */
  @Test
  public void testCheckAnagrams() {
    assertEquals(Anagrams.checkAnagrams("", ""), true);
    assertEquals(Anagrams.checkAnagrams("", "1"), false);
    assertEquals(Anagrams.checkAnagrams("banana", "banan"), false);
    assertEquals(Anagrams.checkAnagrams("b", "a"), false);
    assertEquals(Anagrams.checkAnagrams("a", "a"), true);
    assertEquals(Anagrams.checkAnagrams("11 9;als", "a;91ls 1"), true);
    assertEquals(Anagrams.checkAnagrams("aaa", "aab"), false);
  }
}

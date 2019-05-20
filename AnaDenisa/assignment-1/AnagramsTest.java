import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AnagramsTest {

  /** Test of checkAnagrams method, of class Anagrams. */
  @Test
  public void testEmptyStrings() {
    assertEquals(AnagramCheckUtil.checkAnagrams("", ""), true);
  }

  @Test
  public void testOneEmptyString() {
    assertEquals(AnagramCheckUtil.checkAnagrams("", "1"), false);
  }

  @Test
  public void testOneLetterDifferentStrings() {
    assertEquals(AnagramCheckUtil.checkAnagrams("b", "a"), false);
  }

  @Test
  public void testOneLetterEqualStrings() {
    assertEquals(AnagramCheckUtil.checkAnagrams("a", "a"), true);
  }

  @Test
  public void testStringsSpecialCharacters() {
    assertEquals(AnagramCheckUtil.checkAnagrams("11 9;als", "a;91ls 1"), true);
  }

  @Test
  public void testNonAnagramsEqualLength() {
    assertEquals(AnagramCheckUtil.checkAnagrams("aaa", "aab"), false);
  }

  @Test
  public void testDifferentLength() {
    assertEquals(AnagramCheckUtil.checkAnagrams("banana", "banan"), false);
  }
}

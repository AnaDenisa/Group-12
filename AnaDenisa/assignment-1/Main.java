public final class Main {
  public static void main(String... args) {
    int countArgs;
    boolean anagrams;
    String s1 = null;
    String s2 = null;

    countArgs = args.length;

    if (countArgs != 2) {
      System.out.println("Please provide 2 input strings");
      return;
    }

    anagrams = AnagramCheckUtil.checkAnagrams(s1, s2);

    if (anagrams) System.out.println("Strings are anagrams");
    else System.out.println("Strings are NOT anagrams");
  }

  private Main() {}
}

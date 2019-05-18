package anagrams;

public final class Main {
	public static void main(String... args) {
		int countArgs;
		boolean anagrams;
		String s1 = null;
		String s2 = null;
		
		countArgs = 0;
		for (String input : args) {
			switch (countArgs) {
				case 0:
					s1 = input;
					break;
				case 1:
					s2 = input;
					break;
				default:
					System.out.println("Please provide just 2 strings");
					return;
			}
			countArgs++;
		}
		
		/* check if 2 strings have been provided as input */
		if (countArgs == 0 || countArgs == 1) {
			System.out.println("Please provide at least 2 input strings");
			return;
		}
		
		anagrams = Anagrams.checkAnagrams(s1, s2);
		
		if (anagrams)
			System.out.println("Strings are anagrams");
		else
			System.out.println("Strings are NOT anagrams");
	   
	}
}

package _00_Intro_To_String_Methods;

import java.util.Base64;

/*
 * Visit the JavaDocs for the String class to view everything you can do with a String.
 * https://docs.oracle.com/javase/7/docs/api/java/lang/String.html
 * https://docs.oracle.com/javase/7/docs/api/java/lang/Character.html
 *
 * HINT:  Here are some String methods you might find useful 
 * contains
 * replace
 * trim
 * length
 * getBytes
 * endsWith
 * split 
 * indexOf
 * lastIndexOf
 * compareTo(IgnoreCase)
 * substring
 * toUpperCase/toLowerCase
 * valueOf
 *
 * Here are some Character methods you might find useful:
 * Character.toLowerCase(char c);
 * Character.toUpperCase(char c);
 * Character.isLetter(char c);
 * Character.isDigit(char c);
 * Character.getNumericValue(char c);
 */

public class _01_StringMethods {

	// Given Strings s1 and s2, return the longer String
	public static String longerString(String s1, String s2) {
		if (s1.length() > s2.length()) {
			return s1;
		} else {

			return s2;
		}
	}

	// If String s contains the word "underscores", change all of the spaces
	// to underscores
	public static String formatSpaces(String s) {
		if (s.contains("underscores")) {
			s = s.replace(' ', '_');
		}
		return s;
	}

	// Return the name of the person whose LAST name would appear first if they
	// were in alphabetical order.
	// You cannot assume there are no extra spaces around the name, but you can
	// assume there is only one space between the first and last name
	public static String lineLeader(String s1, String s2, String s3) {
		String s1modified = s1.trim();
		String s2modified = s2.trim();
		String s3modified = s3.trim();
		String s1LastName = s1modified.split(" ")[1];
		String s2LastName = s2modified.split(" ")[1];
		String s3LastName = s3modified.split(" ")[1];
		String currentFirst = "null";
		if (s1LastName.compareTo(s2LastName) < 0) {
			if (s1LastName.compareTo(s3LastName) < 0) {
				currentFirst = s1modified;
			} else {
				currentFirst = s3modified;
			}
		} else {
			if (s2LastName.compareTo(s3LastName) < 0) {
				currentFirst = s2modified;
			} else {
				currentFirst = s3modified;
			}
		}
		return currentFirst;
	}

	// Return the sum of all numerical digits in the String
	public static int numeralSum(String s) {
		int sum = 0;
		int x = 0;
		for (int i = 0; i < s.length(); i++) {
			if (Character.isDigit(s.charAt(i)) == true) {
				x = Integer.parseInt(s.charAt(i) + "");
				sum = sum + x;
			}
		}
		return sum;
	}

	// Return the number of times String substring appears in String s
	public static int substringCount(String s, String substring) {
		int numberOfAppearances = 0;
		int index = s.indexOf(substring);
		while (index != -1) {
			numberOfAppearances++;
			index = s.indexOf(substring, index + substring.length());
		}
		return numberOfAppearances;
	}

	// Call Utilities.encrypt at the bottom of this file to encrypt String s
	public static String encrypt(String s, char key) {
		String encryptedString = Utilities.encrypt(s.getBytes(), (byte) key);
		return encryptedString;
	}

	// Call Utilities.decrypt at the bottom of this file to decrypt the
	// cyphertext (encrypted text)
	public static String decrypt(String s, char key) {
		String decryptedString = Utilities.decrypt(s, (byte) key);
		return decryptedString;
	}

	// Return the number of words in String s that end with String substring
	// You can assume there are no punctuation marks between words
	public static int wordsEndsWithSubstring(String s, String substring) {
		int numberOfWords = 0;
		String[] words = s.split(" ");
		for (int i = 0; i < words.length; i++) {
			if (words[i].endsWith(substring)) {
				numberOfWords += 1;
			}
		}
		return numberOfWords;
	}

	// Given String s, return the number of characters between the first
	// occurrence of String substring and the final occurrence
	// You can assume that substring will appear at least twice
	public static int distance(String s, String substring) {

		int indexStart = s.indexOf(substring);
		int indexEnd = 0;
		for (int i = indexStart; i < s.length(); i++) {
			int indexTemp = s.indexOf(substring, i);
			if (indexTemp != -1) {
				indexEnd = indexTemp;
			}
		}

		return (indexEnd - indexStart) - substring.length();
	}

	// Return true if String s is a palindrome
	// palindromes are words or phrases are read the same forward as backward.
	// HINT: ignore/remove all punctuation and spaces in the String
	public static boolean palindrome(String s) {
		String palindrome = s.trim();
		// String palindrome = s.replace(" ", "").replace("!", "");
		boolean isPalindrome = false;
		double lengthOfInput = (palindrome.length() / 2) + 0.5;

		for (int i = 0; i < lengthOfInput; i++) {
			if (palindrome.charAt(i) == palindrome.charAt(palindrome.length() - (i + 1))) {
				isPalindrome = true;
			} else {
				isPalindrome = false;
				break;
			}
		}
		return true;
	}
}

class Utilities {
	// This basic encryption scheme is called single-byte xor. It takes a
	// single byte and uses exclusive-or on every character in the String.
	public static String encrypt(byte[] plaintext, byte key) {
		for (int i = 0; i < plaintext.length; i++) {
			plaintext[i] = (byte) (plaintext[i] ^ key);
		}
		return Base64.getEncoder().encodeToString(plaintext);
	}

	public static String decrypt(String cyphertext, byte key) {
		byte[] b = Base64.getDecoder().decode(cyphertext);
		for (int i = 0; i < b.length; i++) {
			b[i] = (byte) (b[i] ^ key);
		}
		return new String(b);
	}
}

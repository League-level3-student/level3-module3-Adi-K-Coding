package _01_StringBuilder;

public class _03_StringBuilder {

	public static String append(String str, char[] characters) {
		StringBuilder sb = new StringBuilder();
		sb.append(str);
		String s = sb.append(characters).toString();
		return s;
	}

	public static String reverse(String str) {
		StringBuilder sbReverse = new StringBuilder();
		sbReverse.append(str);
		String sReverse = sbReverse.reverse().toString();
		return sReverse;
	}

	public static String insert(String str, int index, char newChar) {
		StringBuilder sbInsert = new StringBuilder();
		sbInsert.append(str);
		String sInsert = sbInsert.insert(index, newChar).toString();
		return sInsert;
	}

	public static String delete(String str, int startIndex, int endIndex) {
		StringBuilder sbDelete = new StringBuilder();
		sbDelete.append(str);
		String sDelete = sbDelete.delete(startIndex, endIndex).toString();
		return sDelete;
	}
}
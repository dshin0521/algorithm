package utils;

public class ArrayUtil {
	private static final String EMPTY_SPACE = " ";
	private static final String EMPTY = "empty";
	private static final String OPENING_BRACKET = "[";
	private static final String CLOSING_BRACKET = "]";

	public static void printCharArray(char[] charArr) {
		if (charArr == null || charArr.length == 0) {
			System.out.println(EMPTY);
			return;
		}
		System.out.print(OPENING_BRACKET + EMPTY_SPACE);
		for (char c : charArr) {
			System.out.print(c + EMPTY_SPACE);
		}
		System.out.println(CLOSING_BRACKET);
	}

	public static void printIntArray(int[] intArr) {
		if (intArr == null || intArr.length == 0) {
			System.out.println(EMPTY);
			return;
		}
		System.out.print(OPENING_BRACKET + EMPTY_SPACE);
		for (int i : intArr) {
			System.out.print(i + EMPTY_SPACE);
		}
		System.out.println(CLOSING_BRACKET);
	}
}

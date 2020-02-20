package utils;


import java.util.List;

public class ListUtil {
    private static final String EMPTY_SPACE = " ";
    private static final String EMPTY = "empty";
    private static final String OPENING_BRACKET = "[";
    private static final String CLOSING_BRACKET = "]";

    public static void printList(List<Integer> list) {
        if (list == null || list.isEmpty()) {
            System.out.println(EMPTY);
            return;
        }
        System.out.print(OPENING_BRACKET + EMPTY_SPACE);
        for (Integer elem : list) {
            System.out.print(String.valueOf(elem) + EMPTY_SPACE);
        }
        System.out.println(CLOSING_BRACKET);
    }

    public static void printListOfList(List<List<Integer>> listOfList) {
        if (listOfList == null || listOfList.isEmpty()) {
            System.out.println(EMPTY);
            return;
        }
        System.out.print(OPENING_BRACKET + EMPTY_SPACE);
        for (List<Integer> list : listOfList) {
            System.out.print(OPENING_BRACKET + EMPTY_SPACE);
            for (Integer elem : list) {
                System.out.print(String.valueOf(elem) + EMPTY_SPACE);
            }
            System.out.print(CLOSING_BRACKET + EMPTY_SPACE);
        }
        System.out.println(CLOSING_BRACKET);
    }
}

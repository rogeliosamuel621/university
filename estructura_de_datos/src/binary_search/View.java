package binary_search;

public class View {
    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();

        int[] list = new int[]{ 0,1,2,3,4,5,6,7,8,9,10 };
        boolean result = binarySearch.binarySearch(list, 0, list.length, 10);

        System.out.println(result);
    }
}

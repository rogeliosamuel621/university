package binary_search;

public class BinarySearch {
    public boolean binarySearch(int[] list, int left, int right, int objective) {
        if (left > right) return false;

        int middle = (int)((left + right) / 2);
        System.out.println("left: " + left + " right: " + right +  " middle: " + middle);

        if (middle >= list.length) return false;

        if (list[middle] == objective) return true;

        System.out.println("iteracion");
        if (objective > list[middle]) return binarySearch(list, middle + 1, right, objective);

        return binarySearch(list, left, middle - 1, objective);
    }
}

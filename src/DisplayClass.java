import java.util.Comparator;

public class DisplayClass {
    public void quickSort(Orders[] arr, int start, int end, Comparator<Orders> ordersComparator) {
        if (end <= start) return; // base case
        int pivot = partition(arr, start, end, ordersComparator);

        //recursive method
        quickSort(arr, start, pivot - 1, ordersComparator);
        quickSort(arr, pivot + 1, end, ordersComparator);
    }

    private int partition(Orders[] arr, int start, int end, Comparator<Orders> ordersComparator) {
        Orders pivot = arr[end];
        int i = start - 1;
        for (int j = start; j <= end - 1; j++) {
            //Set condition for if statement to compare and sort in descending manner
            if (ordersComparator.compare(arr[j], pivot) > 0) {
                i++;
                Orders temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        i++;
        Orders temp = arr[i];
        arr[i] = arr[end];
        arr[end] = temp;
        return i;
    }
    public static class NameCompare implements Comparator<Orders> {
        @Override
        public int compare (Orders n1, Orders n2) {
            return n1.getLastName().compareToIgnoreCase(n2.getLastName());
            /*
             a negative integer, zero, or a positive integer as the first argument
             is less than, equal to, or greater than the second.
             */
        }
    }
    public static class OrderNumberCompare implements Comparator<Orders> {
        @Override
        public int compare (Orders n1, Orders n2) {
            return n1.getOrderNumber() - (n2.getOrderNumber());
            /*
             a negative integer, zero, or a positive integer as the first argument
             is less than, equal to, or greater than the second.
             */
        }
    }
    public void displaySort(Orders[] arr) {
        System.out.println("Sorted Queue:");
        for (Orders order : arr) {
            System.out.println(order);
        }
    }
}

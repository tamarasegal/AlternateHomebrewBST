public class CallByValue {
    public static void printArray(int[] data) {
        for (int item : data) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
    public static void changeArray(int[] data) {
        data[0] = 0;
    }

    public static void main(String[] args) {
        int [] a = {4, 5, 6};
        printArray(a);
        changeArray(a);
        printArray(a);
    }
}

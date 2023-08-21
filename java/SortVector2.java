import java.util.Arrays;
import java.util.Collections;

public class SortVector2 {
  public static void main(String[] args) {
    int[] v = { 5, -2, 23, 7, 87, -42, 509 };
    //int[] v = new int[]{1,4,3};
    Arrays.sort(v);
    for (int x : v) {
      System.out.println(x);
    }
    Integer[] arr = { 13, 7, 6, 45, 21, 9, 2, 100 };
    Arrays.sort(arr, Collections.reverseOrder());
  
        // Printing the array as generated above
    System.out.println("Modified arr[] : "
                           + Arrays.toString(arr));
  }
}


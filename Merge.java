public class Merge {
  private static  int [] original;

  public static void mergesort(int[]data) {
    int[] temp = new int[data.length];
    for (int x = 0; x < temp.length; x++) {
      temp[x] = data[x];
    }

    mergeHelper(data, temp, 0, data.length - 1);
  }

  private static void mergeHelper(int[] data, int[] temp, int low, int high) {
    if (low >= high) {
      return;
    }
    int mid = low + (high - low) / 2;
    mergeHelper(temp, data, low, mid);
    mergeHelper(temp, data, mid + 1, high);
    merge(data, temp, low, mid, high);
  }

  private static void merge(int[] data, int[] temp, int low, int mid, int high) {
    int x = 0;
    int y = 0;
    while (x < mid-low+1 && y < high-mid) {
      if (temp[low+x] < temp[mid+y+1]) {
        data[low+x+y] = temp[low+x];
        x++;
      } else {
        data[low+x+y] = temp[mid+y+1];
        y++;
      }
    }

    while (x < mid-low+1) {
      data[low+x+y] = temp[low+x];
      x++;
    }
    while (y < high-mid) {
      data[low+x+y] = temp[mid+y+1];
      y++;
    }

  }
}

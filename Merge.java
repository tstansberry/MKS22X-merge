public class Merge {
  private static  int [] original;

  public static void mergesort(int[]data) {
    int [] dataHelper = new int [data.length];
  	for (int x = 0; x < data.length; x ++){
  		dataHelper[x] = data[x];
  	}
  	mergeHelper(dataHelper, 0, data.length - 1);

  	for (int x = 0; x < original.length; x ++){
  		data[x] = original[x];
  	}
  }

  private static void mergeHelper(int[] data, int low, int high) {
    int mid = (high + low) / 2;
  	if (low >= high || data.length < 2){
  		return;
  	}
  	int [] left = new int [mid + 1 - low];
  	for (int y = 0; y <= mid - low; y ++){
  		left [y] = data [y];
  	}
   	int [] right = new int [high - mid];

  	for (int y = 1 + mid - low; y <= high- low; y ++){
  		right [y - mid - 1 + low] = data [y];
  	}

  	mergeHelper(left, low, mid);
  	mergeHelper(right, mid + 1, high);
  	merge(left, right);

     for (int x = 0; x < data.length; x ++){
  		data [x] = original[x];
  	}

  }

  private static void merge(int[] left, int[] right) {
    //System.out.println("SLFKJSDFLKJSD");
    original = new int [left.length + right.length];
  	int l = 0;
  	int r = 0;
  	int i = 0;
  	while(l < left.length && r < right.length && i < original.length){
  			if (left [l] <= right [r]){
  	             original [i] = left [l];
  	             l ++;
  				 i ++;
  	        }
  			if ( l < left.length && r < right.length && i < original.length && left [l] > right [r]){
  	             original [i] = right [r];
  	             r ++;
  				 i ++;
  	        }
  		}
  	while (r < right.length && i < original.length){
  			original [i] = right [r];
  		   	r ++;
  			i ++;
  	  	}
  	while (l < left.length && i < original.length){
  			original [i] = left [l];
  		   	l ++;
  			i ++;
  	  	}
  		}
  }

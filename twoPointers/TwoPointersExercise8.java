public class TwoPointersExercise8 {

  public static List<List<Integer>> findSubarrays(int[] arr, int target) {
    List<List<Integer>> result = new ArrayList<>();
    int product = 1, left = 0;
    for (int right = 0; right < arr.length; right++) {
      product *= arr[right];
      while (product >= target && left < arr.length) {
          product /= arr[left++];
      }
      // since the product of all numbers from left to right is less than the target therefore,
      // all subArrays from lef to right will have a product less than the target too; to avoid
      // duplicates, we will start with a subarray containing only arr[right] and then extend it
      LinkedList<Integer> tempList = new LinkedList<>();
      for (int i = right; i >= left; i--) {
        tempList.addFirst(arr[i]);
        result.add(new ArrayList<>(tempList));
      }
    }
    return result;
  }

  public static void main(String[] args) {
    System.out.println(TwoPointersExercise8.findSubarrays(new int[] { 2, 5, 3, 10 }, 30));
    System.out.println(TwoPointersExercise8.findSubarrays(new int[] { 8, 2, 6, 5 }, 50));
  }
}

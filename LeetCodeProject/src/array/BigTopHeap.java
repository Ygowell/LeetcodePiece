package array;

public class BigTopHeap {
    private int[] nums;
    private int max;
    private int count;

    public BigTopHeap(int capacity) {
        nums = new int[capacity + 1];
        max = capacity;
        count = 0;
    }

    public void insert(int data) {
        if (count == max) {
            System.out.print("The heap is full");
            return;
        }
        count++;
        nums[count] = data;
        int index = count;
        while (index > 1) {
            int parentIndex = index / 2;
            if (nums[index] > nums[parentIndex]) {
                int temp = nums[index];
                nums[index] = nums[parentIndex];
                nums[parentIndex] = temp;
                index = parentIndex;
            } else {
                break;
            }
        }

        printLeftNums("Insert");
    }

    public void deleteTop() {
        if (count == 0) {
            System.out.println("The heap is empty");
            return;
        }

        nums[1] = nums[count];
        nums[count] = 0;
        count--;

        heapify(nums, count, 1);

        printLeftNums("Delete ");
    }

    private void heapify(int[] a, int n, int i) {
        while (true) {
            int maxPos = i;
            if (i * 2 <= n && a[i] < a[i * 2]) maxPos = i * 2;
            if ((i * 2 + 1) <= n && a[maxPos] < a[i * 2 + 1]) maxPos = i * 2 + 1;
            if (maxPos == i) break;
            swap(a, i, maxPos);
            i = maxPos;
        }
    }

    private void swap(int[] nums, int m, int n) {
        int temp = nums[m];
        nums[m] = nums[n];
        nums[n] = temp;
    }

    private void printLeftNums(String action) {
        System.out.println("******" + action + "******");
        for (int n : nums) {
            System.out.print(n + ", ");
        }
        System.out.println(" ===> " + count);
        System.out.println("************");
    }
}

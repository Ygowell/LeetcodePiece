package array;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        BigTopHeap topHeap = new BigTopHeap(10);

        for (int i = 0; i < 10; i++) {
            Random random = new Random();
            topHeap.insert(random.nextInt(50) + 1);
        }

        for (int i = 0; i < 10; i++) {
            topHeap.deleteTop();
        }
    }
}

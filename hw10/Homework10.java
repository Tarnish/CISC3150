/* Ryan Gadalkin : HW10
   Reference/Citation - https://docs.oracle.com/javase/7/docs/api/java/lang/Thread.html
                      - https://stackoverflow.com/questions/12989397/running-3-threads-in-sequence-java
                      - https://stackoverflow.com/questions/18926238/java-multithreading-make-threads-end-in-same-order-they-started-but-run-at-same
**/

public class Homework10 {

    public static void main(String[] args) {
        CustomThread[] threads = new CustomThread[4];
        char[][] threadContents = new char[][] {{'A', 'E', 'I', 'M', 'Q', 'U', 'Y'}, // 7
                                                {'B', 'F', 'J', 'N', 'R', 'V', 'Z'}, // 7
                                                {'C', 'G', 'K', 'O', 'S', 'W'},      // 6
                                                {'D', 'H', 'L', 'P', 'T', 'X'}};     // 6

        for (int i = 0; i < 4; i++) {
            threads[i] = new CustomThread(threadContents[i]);
            threads[i].start();
        }
    }
}

class CustomThread extends Thread {

    private static int tCounter = -1;
    private static int tCurrentOrder;
    private int threadDefiniteOrder;
    private char[] letters;

    CustomThread() {}

    CustomThread(char[] letters) {
        tCounter++;
        threadDefiniteOrder = tCounter;
        this.letters = letters;
    }

    public void run() {
        try {
            for (char letter : letters) {
                while (tCurrentOrder != threadDefiniteOrder) { // Wait until order matches threads original order
                    sleep(50);
                }
                System.out.print(letter + " ");

                if (tCurrentOrder >= tCounter) { // Reached final thread, set back to beginning
                    tCurrentOrder = 0;
                } else {
                    tCurrentOrder++; // Proceed to next thread
                }
            }
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
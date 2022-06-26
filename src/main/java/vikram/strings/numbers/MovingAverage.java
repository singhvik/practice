package vikram.strings.numbers;

/**
 * Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.
 * <p>
 * Implement the MovingAverage class:
 * <p>
 * MovingAverage(int size) Initializes the object with the size of the window size.
 * double next(int val) Returns the moving average of the last size values of the stream.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input
 * ["MovingAverage", "next", "next", "next", "next"]
 * [[3], [1], [10], [3], [5]]
 * Output
 * [null, 1.0, 5.5, 4.66667, 6.0]
 * <p>
 * Explanation
 * MovingAverage movingAverage = new MovingAverage(3);
 * movingAverage.next(1); // return 1.0 = 1 / 1
 * movingAverage.next(10); // return 5.5 = (1 + 10) / 2
 * movingAverage.next(3); // return 4.66667 = (1 + 10 + 3) / 3
 * movingAverage.next(5); // return 6.0 = (10 + 3 + 5) / 3
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= size <= 1000
 * -105 <= val <= 105
 * At most 104 calls will be made to next.
 */

public class MovingAverage {
    private int size;
    private int[] currentStream;
    private int currentSize;
    private double sum;
    private int nextIndex;

    public MovingAverage(int size) {
        this.size = size;
        currentStream = new int[size];
        nextIndex=0;
        currentSize =0;
    }

    public double next(int val) {
        sum += val;
        if(currentSize<size){
            currentSize++;
        }
        if (currentSize == size) {
            sum -= currentStream[nextIndex];
        }
        currentStream[nextIndex] = val;
        nextIndex = (nextIndex + 1) % size;

        return sum/currentSize;
    }
}

package vikram.strings;

/**
 * We want to make a row of bricks that is goal inches long.
 * We have a number of small bricks (1 inch each) and big bricks (5 inches each).
 * Return true if it is possible to make the goal by choosing from the given bricks.
 * This is a little harder than it looks and can be done without any loops.
 * https://codingbat.com/prob/p183562
 */
public class MakeBricks {

    public static void main(String[] args) {
        System.out.println(makeBricks(3,2,10));
    }
    public static boolean makeBricks(int small, int big, int goal) {

        int availableLength = small + big * 5;
        if(availableLength == goal){
            return true;
        }
        if(availableLength < goal){
            return false;
        }

        int requiredBigBricks = Math.min(goal/5,big);

        int remainingGoal = goal - requiredBigBricks*5;
        if(remainingGoal>small){
            return false;
        }
        return true;
    }

}

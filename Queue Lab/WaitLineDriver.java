/**
 * @author Collin Chiang
 * @date 9/19/2022
 */



public class WaitLineDriver {
    public static void main(String[] args) throws EmptyQueueException {
        WaitLine waitLine = new WaitLine();

        waitLine.simulate(10, 0.5, 3);
    }
}

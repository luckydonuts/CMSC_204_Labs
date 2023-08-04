/**
 * @author Collin Chiang
 * @date 9/19/2022
 */



public class Customer {
    public int arrivalTime;
    public int transactionTime;
    public int numberOfArrivals;

    public Customer(int arrivalTime, int transactionTime, int numberOfArrivals) {
        this.arrivalTime = arrivalTime;
        this.transactionTime = transactionTime;
        this.numberOfArrivals = numberOfArrivals;
    }

    public int getArrivalTime() {
        return this.arrivalTime;
    }

    public int getTransactionTime() {
        return this.transactionTime;
    }

    public int getCustomerNumber() {
        return this.numberOfArrivals;
    }

}

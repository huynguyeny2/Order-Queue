public class Orders {

    private int orderNumber;
    private double totalCost;
    private String lastName;


    public Orders(int orderNumber, double totalCost, String lastName) {
        this.orderNumber = orderNumber;
        this.lastName = lastName;
        this.totalCost = totalCost;
    }

    public String getLastName() { return lastName; }

    public int getOrderNumber() { return orderNumber; }

    @Override
    public String toString() {
        return String.format("\tOrder Number: %d\n\tLast Name   : %s\n\tTotal Cost  : $ %s\n"
                ,orderNumber, lastName, totalCost);
    }
}



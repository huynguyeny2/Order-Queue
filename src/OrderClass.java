import java.util.*;


class OrderClass {
    private ArrayList<Orders> myQueue = new ArrayList<>();
    private int frontIndex, backIndex, numberOfItems;
    private final int MAX_CAPACITY;

    public OrderClass(int MAX_CAPACITY) {
        this.MAX_CAPACITY = MAX_CAPACITY;
    }
    public void enqueue(Orders newEntry) {
        /*
        adds a new entry to the back of the queue
        Input: newEntry
        Output: None
         */
//        if (uniqueOrder(newEntry.getOrderNumber())){
            if (myQueue.size() == MAX_CAPACITY) {
                System.out.println("Overflow");
            } else {
                myQueue.add(newEntry);
            }
//        }
    }

    public boolean uniqueOrder(int value) {
        for (int i = 0; i < myQueue.size(); i++) {
                if (value == myQueue.get(i).getOrderNumber()) {
                    System.out.println("Order number already in queue.\n" +
                            "Please enter a different order number.");
                    return false;
                }

        }
        return true;
    }
    public Orders dequeue() {
        Orders removeItem = null;
        try {
            if (!isEmpty()) {
                removeItem = myQueue.remove(0);
            } else {
                System.out.println("Operation 'Dequeue' cannot be perform on an empty queue");
            }
            /*
            Method to remove, ArrayList.java - remvove() will
                remove the item at the 0 index and shift
                everything to the left.
             */
        }
        catch(IndexOutOfBoundsException e){
                System.out.println("Operation 'Dequeue' cannot be perform on an empty queue");
        }
        return removeItem;
    }

    public boolean isEmpty() {
        /*
        detects whether the queue is empty
        Input: None
        Output: Return true if empty, false otherwise
         */
        return myQueue.isEmpty();
    }

    public boolean isFull() {
        return (myQueue.size() == MAX_CAPACITY);
    }
    public int getSize() {
        if (myQueue.isEmpty()) {
            System.out.println("The bag is empty.");
        } else {
            System.out.println("Orders in queues: " + myQueue.size());
        }
        return myQueue.size();
    }

    public void clear(){
        while(!isEmpty()) {
            dequeue();
        }
    }
    
    public void viewOrder() {
        if (isEmpty()){
            System.out.println("Order Queue is empty.");
        } else{
            System.out.println("Queue Content");
            for (Orders order : myQueue) {
                System.out.println(order);
            }
        }
    }
    public Orders[] getQueue() {
        Orders[] queueMy = new Orders[myQueue.size()];
        return myQueue.toArray(queueMy);
    }
}

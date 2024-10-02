import java.util.ArrayList;

class BakeryOrder {
    private String name;
    private int time;

    public BakeryOrder(String name, int time) {
        this.name = name;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}

public class Bakery {
    public static void main(String[] args) {
        ArrayList<BakeryOrder> orders = new ArrayList<>();
        orders.add(new BakeryOrder("C1", 60));
        orders.add(new BakeryOrder("C2", 20));
        orders.add(new BakeryOrder("C3", 40));
        orders.add(new BakeryOrder("C4", 80));

        int timeSlot = 1;
        int currentOrderIndex = 0;
        while (true) {
            boolean allOrdersCompleted = true;
            for (int i = 0; i < orders.size(); i++)
            {
                int orderIndex = (currentOrderIndex + i) % orders.size();
                BakeryOrder order = orders.get(orderIndex);
                if (order.getTime() > 0)
                { // check if the order has not been completed
                    allOrdersCompleted = false;
                    int remainingTime = order.getTime();
                    while (remainingTime > 0)
                    {
                        System.out.printf("Time slot %d: working on %s. The remaining time: %d\n", timeSlot, order.getName(), remainingTime);
                        timeSlot += 1;
                        remainingTime -= 20;
                    }
                    System.out.printf("Time slot %d: %s is finished.\n", timeSlot, order.getName());
                    timeSlot += 1;
                    order.setTime(0); // mark the order as completed
                    currentOrderIndex = (currentOrderIndex + 1) % orders.size();
                    break;
                }
            }
            if (allOrdersCompleted) { // check if all orders are completed
                break;
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList<Order> orders = new SinglyLinkedList<>();
        orders.addLast(new Order("C1", "Banana cake", 60));
        orders.addLast(new Order("C2", "Cheesecake", 20));
        orders.addLast(new Order("C3", "Chocolate coconut cake", 40));
        orders.addLast(new Order("C4", "Carrot and walnut cake", 80));

        printOrders(orders);

        try {
            SinglyLinkedList<Order> emptyOrders = new SinglyLinkedList<>();
            emptyOrders.rotate();
        } catch (Exception e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }

    public static void printOrders(SinglyLinkedList<Order> orders) {
        SinglyLinkedList.Node<Order> current = orders.getHead();
        while (current != null) {
            Order order = current.getData();
            System.out.println(order.getClientName() + ", " + order.getCakeName() + ", " + order.getPrepTime());
            current = current.getNext();
        }
    }
}

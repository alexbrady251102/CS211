public class SinglyLinkedList {
    private Node head;

    private static class Node {
        private String data;
        private Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    public void add(String data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }
                                    //Method to get second last element
    public String getSecondLast() {
        if (head == null || head.next == null) {
            return null;
        } else {
            Node current = head;
            while (current.next.next != null) {
                current = current.next;
            }
            return current.data;
        }
    }
                                    //Adding names to list
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.add("John");
        list.add("Olivia");
        list.add("Emma");
        list.add("Tom");
        list.add("Stephen");

        System.out.println("Second last element: " + list.getSecondLast());
    }
}

public class SinglyLinkedList<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size;

    public SinglyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void addLast(E data) {
        Node<E> node = new Node<>(data);
        if (tail == null) {
            head = node;
            tail = node;
        } else {
            tail.setNext(node);
            tail = node;
        }
        size++;
    }

    public E removeFirst() {
        if (head == null) {
            return null;
        }
        E data = head.getData();
        head = head.getNext();
        size--;
        if (size == 0) {
            tail = null;
        }
        return data;
    }

    public int size() {
        return size;
    }

    public Node<E> getHead() {
        return head;
    }

    public void rotate() {
        if (head != null && head.getNext() != null) {
            Node<E> oldHead = head;
            head = oldHead.getNext();
            tail.setNext(oldHead);
            oldHead.setNext(null);
            tail = oldHead;
        }
    }


    public static class Node<E> {
        private E data;
        private Node<E> next;

        public Node(E data) {
            this.data = data;
            next = null;
        }

        public E getData() {
            return data;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }
}

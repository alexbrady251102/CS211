public class MySinglyLinkedList<E> extends SinglyLinkedList<E> {
    // Override the addLast method to link the tail node to the head node
    @Override
    public void addLast(E data)
    {
        Node<E> newNode = new Node<>(data);
        if (isEmpty())
        {
            head = newNode;
            tail = newNode;
        }
        else
        {
            tail.setNext(newNode);
            tail = newNode;
        }
        tail.setNext(head);
        size++;
    }
}

import java.util.EmptyStackException;

public class MyStack<E> extends SinglyLinkedList<E> {

    private boolean isEmpty;

    public MyStack() {
        isEmpty = true;
        head = null;
    }

    public boolean push(E obj) {
        if (obj == null) {
            return false;
        }
        isEmpty = false;
        ListNode<E> newNode = new ListNode<E>(obj);
        newNode.setNext(head);
        head = newNode;
        return true;

    }

    public E pop() {
        if (isEmpty) {
            throw new EmptyStackException();
        }
        head = head.getNext();
        ListNode<E> newNode = head;
        return newNode.getValue();
    }

    public E peek() {
        if (isEmpty) {
            throw new EmptyStackException();
        }
        return head.getValue();
    }
}

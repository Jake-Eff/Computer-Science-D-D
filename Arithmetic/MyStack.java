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
        if (empty()) {
            throw new EmptyStackException();
        }
        ListNode<E> newNode = head;
        if (head.getNext() == null) {
            isEmpty = true;
        }
        head = head.getNext();
        return newNode.getValue();
    }

    public E peek() {
        if (empty()) {
            throw new EmptyStackException();
        }
        return head.getValue();
    }

    public boolean empty() {
        return isEmpty;
    }
}

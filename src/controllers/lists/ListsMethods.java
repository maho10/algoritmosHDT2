package controllers.lists;

public abstract class ListsMethods<E> {

    class Node{
        E data;
        Node next;
        Node previous;

        public Node(E data) {
            this.data = data;
        }
    }

    Node head = null;

    public void setHead(Node head) {
        this.head = head;
    }

    public E get() {
        if(this.head != null) {
            if(this.head.next == null) {
                return this.head.data;
            } else {
                Node temp = this.head;
                while(temp.next.next != null)
                    temp = temp.next;
                return temp.next.data;
            }
        } else {
            return null;
        }
    }

    public void remove() {
        if(this.head != null) {

            if(this.head.next == null) {
                this.head = null;
            } else {

                Node temp = this.head;
                while(temp.next.next != null)
                    temp = temp.next;

                Node lastNode = temp.next;
                temp.next = null;
                lastNode = null;
            }
        }
    }

    public int size() {
        Node current = head;
        int size = 0;

        if(head == null) {
            return 0;
        }
        while(current != null) {
            size += 1;
            current = current.next;
        }
        return size;
    }

}

/**
 * Used references:
 * https://www.alphacodingskills.com/java/ds/java-delete-the-last-node-of-the-doubly-linked-list.php#:~:text=Deleting%20the%20last%20node%20of,and%20delete%20the%20last%20node.
 * https://www.softwaretestinghelp.com/doubly-linked-list-in-java/#:~:text=Answer%3A%20You%20can%20create%20a,and%20to%20traverse%20the%20list.
 */

package controllers.lists;

public class DoublyList<E> implements Lists<E>{

    class Node{
        E data;
        Node previous;
        Node next;

        public Node(E data) {
            this.data = data;
        }
    }

    Node head, tail = null;

    @Override
    public void add(E data) {
        Node newNode = new Node(data);
        newNode.next = null;
        newNode.previous = null;
        if(head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while(temp.next != null)
                temp = temp.next;
            temp.next = newNode;
            newNode.previous = temp;
        }
    }

    @Override
    public E get(int position) {
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

    @Override
    public void remove(int position) {
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

    @Override
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

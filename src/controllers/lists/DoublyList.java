/**
 * Used references:
 * https://www.alphacodingskills.com/java/ds/java-delete-the-last-node-of-the-doubly-linked-list.php#:~:text=Deleting%20the%20last%20node%20of,and%20delete%20the%20last%20node.
 * https://www.softwaretestinghelp.com/doubly-linked-list-in-java/#:~:text=Answer%3A%20You%20can%20create%20a,and%20to%20traverse%20the%20list.
 */

package controllers.lists;

public class DoublyList<E> extends ListsMethods<E> implements Lists<E>{

    class Node{
        E data;
        Node previous;
        Node next;

        public Node(E data) {
            this.data = data;
        }
    }

    private Node head, tail = null;

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
}

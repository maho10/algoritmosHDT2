/**
 * Used references:
 * https://www.alphacodingskills.com/ds/notes/linked-list-delete-the-last-node.php#:~:text=Deleting%20the%20last%20node%20of,and%20delete%20the%20last%20node.
 * javatpoint.com/java-program-to-create-and-display-a-singly-linked-list#:~:text=The%20singly%20linked%20list%20is,next%20node%20in%20the%20list.
 */

package controllers.lists;

public class SinglyList<E> extends ListsMethods<E> implements Lists<E>{

    class Node{
        private E data;
        private Node next;

        public Node(E data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head, tail = null;

    @Override
    public void add(E data) {
        Node newNode = new Node(data);
        newNode.next = null;
        if(head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while(temp.next != null)
                temp = temp.next;
            temp.next = newNode;
        }
    }
}
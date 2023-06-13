package prob4;

public class DoublyLinkedList {

    Node header;

    DoublyLinkedList() {
        header = new Node();
    }

    //adds to the end of the list
    public void addLast(String item) {
        //implement
        Node n = new Node();
        n.value = item;
        n.next = null;
        Node cur = header;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = n;
        n.previous = cur;
    }

    public boolean remove(String item) {
        //Implement
        if (header.next == null) return false;
        Node cur = header.next;
        while (cur != null && !cur.value.equals(item)) {
            cur = cur.next;
        }
        if (cur == null) {
            return false;
        }
        if (cur.next != null) {
            cur.next.previous = cur.previous;
        }
        cur.previous.next = cur.next;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        toString(sb, header);
        return sb.toString();
    }

    private void toString(StringBuilder sb, Node n) {
        if (n == null) return;
        if (n.value != null) sb.append(" " + n.value);
        toString(sb, n.next);
    }

    class Node {
        String value;
        Node next;
        Node previous;

        public String toString() {
            return value == null ? "null" : value;
        }
    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.addLast("Bob");
        list.addLast("Harry");
        list.addLast("Steve");
        list.addLast("Dulmaa");
        System.out.println(list);
        System.out.println(list.remove("Dulmaa"));
        System.out.println(list);
    }
}

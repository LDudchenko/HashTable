public class LinkedList {
    private Node start;

    public Node getStart(){
        return  start;
    }

    public void printList() {
        Node element = start;
        while (element != null) {
            System.out.print(element.key+": "+element.data + ";   ");
            element = element.next;
        }
        System.out.println();
    }

    public int removeElement(int key) {
        Node previous = new Node();
        Node element = start;
        while (element != null) {
            if (element.key == key) {
                if(previous.next == null){
                    start = start.next;
                    return 0;
                }else {
                    previous.next = element.next;
                    return 0;
                }
            }
            previous = element;
            element = element.next;
        }
        return -1;
    }

    public int getLength() {
        Node element = start;
        int length = 0;
        while (element != null) {
            element = element.next;
            length++;
        }
        return length;
    }

    public Node findElement(int key) {
        Node element = start;
        while (element != null) {
            if (element.key == key) {
                return element;
            }
            element = element.next;
        }
        return null;
    }

    public void insertEnd(int key, String data) {
        Node element = new Node(key, data);
        if(start==null){
            start = element;
            return;
        }
        Node current = start;
        while(current.next!=null){
            current = current.next;
        }
        current.next = element;
    }
}

class Node {
    String data;
    int key;
    Node next;

    public Node() {
        data = "";
        key = 0;
        next = null;
    }

    public Node(int key, String data) {
        this.data = data;
        this.key = key;
        next = null;
    }

    public void printNode(){
        System.out.println("Ключ: "+this.key +" \nДанные: "+this.data+";");
    }
}
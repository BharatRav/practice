// vishal kumar
// 19m ago
public class LinkedList {

public static Node createNode(int x) {

Node node = new Node();

node.x = x;

node.next = null;

return node;

}

public static void main(String[] args) {

Node head = createNode(1);

head.next = createNode(2);

head.next.next = createNode(3);

Node temp = head;

while(temp.next != null) {

System.out.println(temp.x); // 1, 2, 3

temp = temp.next;

}

System.out.println(temp);

System.out.println(head);

}

}

class Node {

int x;

Node prev;

Node next;

}

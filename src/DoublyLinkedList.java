class DoublyLinkedList<E> {
    Node<E> head; // head of list
    Node<E> tail;
    
    /* Linked list Node*/
    class Node<E> {
        E data;
        Node next;
        Node prev;
  
        // Constructor to create a new node
        // Next is by default initialized
        // as null
        Node(E d) { 
        data = d; 
        }
    }
    
    public DoublyLinkedList<E> add(DoublyLinkedList<E> list, E data){
        Node<E> new_node = new Node<E>(data);
        new_node.next = null;
        new_node.prev = null;
        if (list.head == null) {
            list.head = new_node;
            list.tail = new_node;
        }
        else {
            Node<E> last = list.tail;
            new_node.prev = last;
            last.next = new_node;
            list.tail = new_node;
        }
        return list;
    }
    
    public DoublyLinkedList<E> insert(DoublyLinkedList<E> list, E data, int index){
    	if(index < 0 || index > list.size(list)) {
    		System.out.print("\nIndex Out of Bounds");
    		return list;
    	}
    	Node<E> new_node = new Node<E>(data);
    	if(index == 0) {
    		Node<E> first = list.head;
    		first.prev = new_node;
    		new_node.next = first;
    		list.head = new_node;
    		return list;
    	}
    	if(index == list.size(list)) {
    		Node<E> last = list.tail;
    		last.next = new_node;
    		new_node.prev = last;
    		list.tail = new_node;
    		return list;
    	}
    	Node<E> curr = list.head;
    	for(int i = 1; i <= index; i++) {
    		curr = curr.next;
    	}
    	new_node.next = curr;
    	new_node.prev = curr.prev;
    	curr.prev.next = new_node;
    	curr.prev = curr.prev.next;
    	
//        new_node.next = null;
//        new_node.prev = null;
//        if (list.head == null) {
//            list.head = new_node;
//            list.tail = new_node;
//        }
//        else {
//            Node<E> last = list.tail;
//            new_node.prev = last;
//            last.next = new_node;
//            list.tail = new_node;
//        }
        return list;
    }
//    
//    public LinkedList remove(LinkedList list, int index){
//    	if(list.head == null) {
//    		System.out.println("List Empty");
//    	}
//    	Node current = list.head;
//    	if(index == 0) {
//    		list.head = current.next;
//    		return list;
//    	}
//    	int i = 1;
//    	while(current.next != null) {
//    		if(index == i) {
//    			current.next = current.next.next;
//    			return list;
//    		}
//    		current = current.next;
//    		i++;
//    	}
//    	System.out.print("\nIndex Out of Bounds");
//    	return list;
//    }
//    
    public void printList(DoublyLinkedList<E> list){
        Node<E> currNode = list.head;
   
        System.out.print("\nForwards: ");
   
        // Traverse through the LinkedList
        while (currNode != null) {
            // Print the data at current node
            System.out.print(currNode.data + " ");
   
            // Go to next node
            currNode = currNode.next;
        }
        
        currNode = list.tail;
        
        System.out.print(" Backwards: ");
   
        // Traverse through the LinkedList
        while (currNode != null) {
            // Print the data at current node
            System.out.print(currNode.data + " ");
   
            // Go to next node
            currNode = currNode.prev;
        }
        
    }
    
    public int size(DoublyLinkedList<E> list){
        Node<E> currNode = list.head;
        int i = 0;
        while (currNode != null) {
            currNode = currNode.next;
            i++;
        }
        return i;
    }
    
    public static void main(String[] args) {
		DoublyLinkedList<String> l = new DoublyLinkedList<>();
		l.add(l, "A");
		l.printList(l);
		l.add(l, "B");
		l.printList(l);
		l.insert(l, "C", 1);
		l.printList(l);
		l.insert(l, "D", 3);
		l.printList(l);
		l.insert(l, "E", 2);
		l.printList(l);
//		l.add(l, "C");
//		l.add(l, "B");
		l.printList(l);
		System.out.print("\nSize: " + l.size(l));
//		l.remove(l, 1);
//
//		l.printList(l);
//		l.size(l);
	}


}

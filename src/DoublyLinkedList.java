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
    
    public DoublyLinkedList add(DoublyLinkedList list, E data){
        // Create a new node with given data
        Node new_node = new Node(data);
        new_node.next = null;
        new_node.prev = null;
  
        // If the Linked List is empty,
        // then make the new node as head
        if (list.head == null) {
            list.head = new_node;
            list.tail = new_node;
        }
        else {
            // Else traverse till the last node
            // and insert the new_node there
            Node last = list.head;
            while (last.next != null) {
                last = last.next;
            }
  
            // Insert the new_node at last node
            last.next = new_node;
        }
  
        // Return the list by head
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
    public void printList(DoublyLinkedList list){
        Node currNode = list.head;
   
        System.out.print("\nForwardsLinkedList: ");
   
        // Traverse through the LinkedList
        while (currNode != null) {
            // Print the data at current node
            System.out.print(currNode.data + " ");
   
            // Go to next node
            currNode = currNode.next;
        }
        
        currNode = list.tail;
        
        System.out.print("\nBackwardsLinkedList: ");
   
        // Traverse through the LinkedList
        while (currNode != null) {
            // Print the data at current node
            System.out.print(currNode.data + " ");
   
            // Go to next node
            currNode = currNode.prev;
        }
        
    }
//    
//    public int size(LinkedList list){
//        Node currNode = list.head;
//        int i = 0;
//        while (currNode != null) {
//            currNode = currNode.next;
//            i++;
//        }
//        System.out.print("\nSize: " + i);
//        return i;
//    }
    
    public static void main(String[] args) {
		DoublyLinkedList<String> l = new DoublyLinkedList<>();
		l.add(l, "A");
//		l.add(l, "D");
//		l.add(l, "C");
//		l.add(l, "B");
		l.printList(l);
//		l.size(l);
//		l.remove(l, 1);
//
//		l.printList(l);
//		l.size(l);
	}


}

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

class DoublyLinkedList<E> implements Iterable<E>{
	Node<E> head, tail;

	class Node<E> {
		E data;
		Node<E> next;
		Node<E> prev;
		Node(E d) { 
			data = d; 
		}
	}
// https://www.geeksforgeeks.org/java-implementing-iterator-and-iterable-interface/
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
		return list;
	}

	public DoublyLinkedList<E> remove(DoublyLinkedList<E> list, int index){
		if(index < 0 || index >= list.size(list)) {
			System.out.print("\nIndex Out of Bounds");
			return list;
		}
		if(index == 0) {
			list.head = list.head.next;
			list.head.prev = null;
			return list;
		}
		if(index == list.size(list) - 1) {
			list.tail = list.tail.prev;
			list.tail.next = null;
			return list;
		}
		Node<E> curr = list.head;
		for(int i = 1; i <= index; i++) {
			curr = curr.next;
		}
		curr.next.prev = curr.prev;
		curr.prev.next = curr.next;
		return list;
	}

	public void printList(DoublyLinkedList<E> list){
		Node<E> currNode = list.head;
		System.out.print("\nForwards: ");
		while (currNode != null) {
			System.out.print(currNode.data + " ");
			currNode = currNode.next;
		}
		currNode = list.tail;
		System.out.print(" Backwards: ");
		while (currNode != null) {
			System.out.print(currNode.data + " ");
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
		l.add(l, "B");
		l.add(l, "C");
		l.add(l, "D");
		l.printList(l);
		l.insert(l, "E", 2);
		l.printList(l);
		l.remove(l, 3);
		l.printList(l);
		System.out.print("\nSize: " + l.size(l));
	}

	public Iterator<E> iterator() {
		return new Iterator<E>();
	}
	
	class Iterator<E> implements ListIterator<E> {
		DoublyLinkedList<E>.Node<E> cur;
		
		Iterator() {
			cur = (DoublyLinkedList<E>.Node<E>) head;
		}
		
		public boolean hasNext() {
			return cur != null;
		}

		public E next() {
			if(cur == null) {
				throw new NoSuchElementException();
			}
			E data = cur.data;
			cur = cur.next;
			return data;
		}

		public boolean hasPrevious() {
			return cur != null;
		}

		@Override
		public E previous() {
			if(cur == null) {
				throw new NoSuchElementException();
			}
			E data = cur.data;
			cur = cur.prev;
			return data;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			if(cur == null) {
				throw new NoSuchElementException();
			}
			if(cur == head) { 
				head = cur.next;
				cur = cur.next;
				cur.prev = null;
			} else if (cur == tail) {
				tail = cur.prev;
				cur = cur.prev;
				cur.next = null;
			} else {
				cur.next.prev = cur.prev;
				cur.prev.next = cur.next;
				
			}
		}

		@Override
		public void set(E e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void add(E e) {
			// TODO Auto-generated method stub
			
		}
		
	}
}

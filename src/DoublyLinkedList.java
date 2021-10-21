import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class DoublyLinkedList<E> implements Iterable<E>{
	private Node<E> head = null; 
	private Node<E> tail = null; 
	
	private class Node<E> {
		E data;
		Node<E> next;
		Node<E> prev;
		Node(E d) { 
			data = d; 
		}
		
		Node(E d, Node<E> next){
			data = d;
			this.next = next;
		}
	}
	
	public void add(E data){
		Node<E> new_node = new Node<E>(data);
		new_node.next = null;
		new_node.prev = null;
		if (head == null) {
			head = new_node;
			tail = new_node;
		}
		else {
			Node<E> last = tail;
			new_node.prev = last;
			last.next = new_node;
			tail = new_node;
		}
	}
	
	public Node<E> getHead() {
		return head;
	}
	
	public Node<E> getTail() {
		return tail;
	}

//	public DoublyLinkedList<E> insert(DoublyLinkedList<E> list, E data, int index){
//		if(index < 0 || index > list.size(list)) {
//			System.out.print("\nIndex Out of Bounds");
//			return list;
//		}
//		Node<E> new_node = new Node<E>(data);
//		if(index == 0) {
//			Node<E> first = list.head;
//			first.prev = new_node;
//			new_node.next = first;
//			list.head = new_node;
//			return list;
//		}
//		if(index == list.size(list)) {
//			Node<E> last = list.tail;
//			last.next = new_node;
//			new_node.prev = last;
//			list.tail = new_node;
//			return list;
//		}
//		Node<E> curr = list.head;
//		for(int i = 1; i <= index; i++) {
//			curr = curr.next;
//		}
//		new_node.next = curr;
//		new_node.prev = curr.prev;
//		curr.prev.next = new_node;
//		curr.prev = curr.prev.next;
//		return list;
//	}

//	public DoublyLinkedList<E> remove(DoublyLinkedList<E> list, int index){
//		if(index < 0 || index >= list.size(list)) {
//			System.out.print("\nIndex Out of Bounds");
//			return list;
//		}
//		if(index == 0) {
//			list.head = list.head.next;
//			list.head.prev = null;
//			return list;
//		}
//		if(index == list.size(list) - 1) {
//			list.tail = list.tail.prev;
//			list.tail.next = null;
//			return list;
//		}
//		Node<E> curr = list.head;
//		for(int i = 1; i <= index; i++) {
//			curr = curr.next;
//		}
//		curr.next.prev = curr.prev;
//		curr.prev.next = curr.next;
//		return list;
//	}

	public void printList(){
		Node<E> currNode = head;
		System.out.print("\nForwards: ");
		while (currNode != null) {
			System.out.print(currNode.data + " ");
			currNode = currNode.next;
		}
		currNode = tail;
		System.out.print(" Backwards: ");
		while (currNode != null) {
			System.out.print(currNode.data + " ");
			currNode = currNode.prev;
		}
	}

	public int size(){
		Node<E> currNode = head;
		int i = 0;
		while (currNode != null) {
			currNode = currNode.next;
			i++;
		}
		return i;
	}

//	public static void main(String[] args) {
//		DoublyLinkedList<Employee> l = new DoublyLinkedList<>();
//		l.add(new Employee("e", "math", 20));
//		l.add(new Employee("a", "english", 200));
//		l.add(new Employee("n", "science", 60));
//		l.printList();
//		ListIterator<Employee> it = l.iterator();
//		System.out.println("");
//		while(it.hasNext()) {
//			System.out.println(it.next());
//		}
//		while(it.hasPrevious()) {
//			System.out.println(it.previous());
//		}
//	}

	public ListIterator<E> iterator() {
		return new DoublyLinkedListIterator();
	}
	
	private class DoublyLinkedListIterator implements ListIterator<E> {
		private Node<E> initial = new Node<E>(null, head);
		private Node<E> cur = initial;
		
		public boolean hasNext() {
			return cur.next != null;
		}

		public E next() {
			if(!hasNext()) {
				throw new NoSuchElementException();
			}
			cur = cur.next;
			return cur.data;
		}

		public boolean hasPrevious() {
			return cur.prev != null;
		}

		@Override
		public E previous() {
			if(!hasPrevious()) {
				throw new NoSuchElementException();
			}
			cur = cur.prev;
			return cur.data;
		}
		
		@Override
		public void set(E e) {
			if(cur == null) {
				throw new NoSuchElementException();
			}
			cur.data = e;
			
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			if(cur == null) {
				throw new NoSuchElementException();
			}
			if(cur == head && cur == tail) {
				head = null;
				tail = null;
				cur = head;
			} else if(cur == head) { 
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
		public void add(E e) {
			Node<E> new_node = new Node<E>(e);
			new_node.next = null;
			new_node.prev = null;
			if (head == null) {
				head = new_node;
				tail = new_node;
				return;
			}
			if(cur == head) {
				Node<E> first = head;
				first.prev = new_node;
				new_node.next = first;
				head = new_node;
				return;
			}
			new_node.next = cur;
			new_node.prev = cur.prev;
			cur.prev.next = new_node;
			cur.prev = cur.prev.next;
			// TODO Auto-generated method stub
			
		}

		@Override
		public int nextIndex() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int previousIndex() {
			// TODO Auto-generated method stub
			return 0;
		}
		
	}
}

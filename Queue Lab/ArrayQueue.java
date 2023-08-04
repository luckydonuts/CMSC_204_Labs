/**
 * @author Michael Bushman
 */
public class ArrayQueue <T> implements QueueInterface<T>{
	
	private Node frontNode;
	private Node lastNode;
	
	public ArrayQueue() {
		frontNode = null;
		lastNode = null;
	}
	
	
	/** Adds a new entry to the back of this queue.
    @param newEntry  An object to be added. */
	public void enqueue(T newEntry) {
		
		Node newNode = new Node(newEntry);
		
		if(isEmpty()) 
			frontNode = newNode;
		
		else
			lastNode.setNextNode(newNode);
		
		lastNode = newNode;
	}
		
	/** Removes and returns the entry at the front of this queue.
    @return  The object at the front of the queue. 
    @throws  EmptyQueueException if the queue is empty before the operation. */
	public T dequeue() throws EmptyQueueException {
		
		T front = getFront();
		frontNode.setData(null);
		frontNode = frontNode.getNextNode();
		
		if (frontNode == null)
			lastNode = null;
		
		return front;
	}

	/**  Retrieves the entry at the front of this queue.
    @return  The object at the front of the queue.
    @throws  EmptyQueueException if the queue is empty. */
	public T getFront() throws EmptyQueueException {
		if (isEmpty())
			throw new EmptyQueueException();
		else
			return frontNode.info;
	}

	/** Detects whether this queue is empty.
    @return  True if the queue is empty, or false otherwise. */
	public boolean isEmpty() {
		if (frontNode == null && lastNode == null)
			return true;
		else
			return false;
	}

	/** Removes all entries from this queue. */
	public void clear() {
		frontNode = null;
		lastNode = null;
	}
	
	/**
	 * Queue Node class
	 */
	private class Node {
		//Variables
		 T info = null;
		 Node next = null;
		
		 /**
		  * Creates new node
		  * @param newNode
		  */
		 public Node(T newNode) {
			 info = newNode;
		 }
		 
		 /**
		  * Sets the node reference
		  * @param nextNode
		  */
		 public void setNextNode(Node nextNode) {
			 next = nextNode;
		 }
		 
		 /**
		  * Sets the node data
		  * @param newData
		  */
		 public void setData(T newData) {
			 info = newData;
		 }
		 
		 /**
		  * Returns the next node
		  * @return next node
		  */
		 public Node getNextNode() {
			 return next;
		 }
	}
}

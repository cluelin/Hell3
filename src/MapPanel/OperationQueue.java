package MapPanel;

import java.util.LinkedList;
import java.util.Queue;

import Operation.Operation;

public class OperationQueue {
	Queue<Operation> operationQueue;
	
	public OperationQueue()
	{
		operationQueue = new LinkedList();
	}
	
	public boolean add(Operation e)
	{
		try {
			operationQueue.add(e);
		} catch (Exception ex) {
			return false;
		}
		
		return true;
	}
	
	public Operation remove() 
	{
		Operation _return = null;
		try {
			_return = operationQueue.remove();
		} catch (Exception ex) {
			return null;
		}
		
		return _return;
	}

	public void clear()
	{
		operationQueue.clear();
	}
	
	// getter & setter
	public Queue<Operation> getOperationQueue() {
		return operationQueue;
	}
}

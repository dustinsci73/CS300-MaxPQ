///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Title:            (p1)
// Files:            (MaxPQ.java, TestMaxPQ.java, EmptyQueueException.java, PriorityQueueADT.java)
// Semester:         (Spring 2018)
// Due Date:         2/5/18
// Class:            CS400
// Author:           (Dustin Li)
// Email:            (dli284@wisc.edu)
// Lecturer's Name:  (Deb Deppeler)
///////////////////////////////////////////////////////////////////////////////

/**
 * Creates a array based priority queue in the form of a max-heap.
 *
 * @author Dustin Li
 */
public class MaxPQ<E extends Comparable<E>> implements PriorityQueueADT<E>
{
    private E[] items;
    private int num; //number of objects in the heap
    private static final int INITIAL_SIZE = 10;

    // start of constructor to demonstrate how to 
    // initialize an array for a generic type.
    public MaxPQ()
    {
        this.items = (E[]) new Comparable[INITIAL_SIZE];
        num = 0;
    }
    // ... implement all operations of the PriorityQueueADT
   
    /**
     * Returns the index of the parent object
     *
     * @param childIndex - index of the child object
     * @return index of the parent object
     */
    private int getParent(int childIndex) 
    {
	    // return the parent index of the given child index 
	    return (childIndex - 1) / 2;
	}
	
    /**
     * Returns the index of the left child object
     *
     * @param parentIndex - index of the parent object
     * @return index of the left child object
     */
	private int getLeftChild(int parentIndex) 
	{
	    // return the left child index of the given parent index
	    return 2 * parentIndex + 1;
	}
	
	/**
     * Returns the index of the right child object
     *
     * @param parentIndex - index of the parent object
     * @return index of the right child object
     */
	private int getRightChild(int parentIndex) {
	    // return the right child index of the given parent index
	    return 2 * parentIndex + 2;
	}
	
	/**
     * Iterates through the max-heap, starting at the index node, up 
     * through its parent nodes to maintain the order of the max-heap property.
     * Swaps the nodes when one is found in violation of the max-heap order property.
     *
     * @param index - index of the starting node
     */
	private void addHelper(int index) 
	{
		int i = index;
		if (items[getParent(i)] != null && items[i] != null)
		{
			if (i > 0 && items[getParent(i)].compareTo(items[i]) < 0)
			{
				swap(i, getParent(i));
				addHelper(getParent(i));
			}
		}
	}
	
	/**
     * Iterates through the max-heap, starting at the top node, down 
     * through its child nodes to maintain the order of the max-heap property.
     * Swaps the nodes when one is found in violation of the max-heap order property.
     *
     * @param index - index of the starting node
     */
	private void removeHelper(int index) 
	{
		int i = index;
		if (getLeftChild(i) < items.length && getRightChild(i) < items.length)
		{
			int larger = i;
			int templ = 0;
			int tempr = 0;
			int left = getLeftChild(i);
			int right = getRightChild(i);
			if (items[left] != null)
			{
				if (items[left].compareTo(items[i]) > 0)
				{
					templ = left;
				}
			}
			if (items[right] != null)	
			{
				if (items[right].compareTo(items[i]) > 0)
				{
					tempr = right;
				}
			}
			if (tempr > templ)	
			{
				larger = right;
			}
			else if (templ > tempr)	
			{
				larger = left;
			}
			if (larger != i)
			{
				swap(i, larger);
				removeHelper(larger);
			}
			else 
			{
				removeHelper(i+1);
			}
		}
	}
	
	/**
     * Checks to see if the priority queue is empty
     *
     * @return true or false
     */
	public boolean isEmpty() 
    {
        return num == 0;
    }
	
	/**
     * Checks to see if the priority queue is full
     *
     * @return true or false
     */
    public boolean isFull()
    {
    		return num == items.length;
    }
    
    /**
     * Checks number of objects in the priority queue
     *
     * @return number of objects in the priority queue
     */
    public int size() 
    {
        return num;
    }

	@Override
	/**
     * Inserts an item into the priority queue and calls the addHelper method
     * to maintain the max-heap order property
     *
     * @param item - object that is being inserted into the priority queue
     */
	public void insert(E item) 
	{
		// TODO Auto-generated method stub
		if (isFull())
		{
			E[] temp = (E[]) new Comparable[(items.length)*2];
			for (int i = 0; i < items.length; i++)
			{
				temp[i] = items[i];
			}
			items = temp;
		}
		items[num] = item;
		num++;
		addHelper(num-1);	
	}
	
	/**
     * Swaps the positions of the two nodes
     *
     * @param posOne - position of first node
     * @param posTwo - position of second node
     */
	public void swap(int posOne, int posTwo) 
	{
		E temp = items[posOne];
		items[posOne] = items[posTwo];
		items[posTwo] = temp;
	}
	
	@Override
	/**
     * Returns the object at the top of the max heap
     *
     * @return object at the top of the priority queue
     * @throws EmptyQueueException when the priority queue is empty
     */
	public E getMax() 
	{
		// TODO Auto-generated method stub
		if (isEmpty())
		{
			throw new EmptyQueueException("Priority Queue is empty.");
		}
		else
		{
			return items[0];
		}
	}

	@Override
	/**
     * Removes and returns the object at the top of the max heap
     *
     * @return object at the top of the priority queue
     * @throws EmptyQueueException when the priority queue is empty
     */
	public E removeMax() throws EmptyQueueException 
	{
		// TODO Auto-generated method stub
		if (isEmpty())
		{
			throw new EmptyQueueException("Priority Queue is empty.");
		}
		else 
		{
			E tempVar = items[0];
			E[] temp = (E[]) new Comparable[items.length];
			for (int i = 0; i < items.length-1; i++)
			{
				temp[i] = items[i+1];
			}
			items = temp;
			num--;
			removeHelper(0);
			return tempVar;	
		}
	}
//	public void print() 
//	{
//		for (int i = 0; i < items.length; i++)
//		{
//			System.out.print(items[i] + " ");
//		}
//	}
}

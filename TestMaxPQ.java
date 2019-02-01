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
 * Tests the methods of the MaxPQ class
 * 
 * @author Dustin Li
 */
public class TestMaxPQ 
{
	/**
     * Calls and runs the methods of the class
     */
	public static void main (String[] args) 
	{
		TestMaxPQ test = new TestMaxPQ();
		test.isEmpty();
		test.getMax_Exception();
		test.removeMax_Exception();
		test.insert_many_remove_1();
		test.insert_remove_1();
		test.dups_allowed();
		test.big_data();
	}
	
	/**
     * Tests the isEmpty method of the MaxPQ class. 
     */
	public static void isEmpty() 
	{
		//- fails if a newly constructed PQ does not return true for isEmpty
		MaxPQ<Integer> test = new MaxPQ<Integer>();
		if (test.isEmpty() == false)
		{
			System.out.println("Test FAILED. PQ is not empty");
		}
		else	
		{
			System.out.println("isEmpty Test PASSED.");
		}
	}
	
	/**
     * Tests the getMax method of the MaxPQ class. 
     */
	public static void getMax_Exception() 
	{
	//- fails if getMax on a newly constructed PQ does not throw EmptyQueueException
		MaxPQ<Integer> test = new MaxPQ<Integer>();
		try
		{
			test.getMax();
		}
		catch(EmptyQueueException e)
		{
			System.out.println("GetMax_Exception Test PASSED.");
			return;
		}
		System.out.println("Test FAILED. EmptyQueueException was not thrown.");
	}

	/**
     * Tests the removeMax method of the MaxPQ class. 
     */
	public static void removeMax_Exception()
	{
		//- fails if removeMax on a newly constructed PQ does not throw EmptyQueueException
		MaxPQ<Integer> test = new MaxPQ<Integer>();
		try
		{
			test.removeMax();
		}
		catch(EmptyQueueException e)
		{
			System.out.println("RemoveMax_Exception Test PASSED.");
			return;
		}
		System.out.println("Test FAILED. EmptyQueueException was not thrown.");
	}

	/**
     * Tests the insert and removeMax methods of the MaxPQ class. 
     */
	public static void insert_remove_1()
	{
		//- inserts one item and fails if removeMax is not the same value as was inserted
		MaxPQ<Integer> test = new MaxPQ<Integer>();
		Integer insert = new Integer("5");
		test.insert(insert);
		Integer ret = test.removeMax();
		if (ret != insert)
		{
			System.out.println("Test FAILED. Item inserted was not the item removed.");
		}
		else
		{
			System.out.println("Insert_Remove_1 Test PASSED.");
		}
	}
	
	/**
     * Tests the the insert and removeMax methods of the MaxPQ class. 
     */
	public static void insert_many_remove_1()
	{
		//- inserts many items and fails if removeMax is not the max value as was inserted
		MaxPQ<Integer> test = new MaxPQ<Integer>();
		Integer insertOne = new Integer("5");
		Integer insertTwo = new Integer("3");
		Integer insertThree = new Integer("1");
		Integer max = new Integer("7");
		test.insert(insertOne);
		test.insert(insertTwo);
		test.insert(insertThree);
		test.insert(max);
		Integer ret = test.removeMax();
		if (ret != max)
		{
			System.out.println("Test FAILED. Max integer was not removed.");
		}
		else
		{
			System.out.println("Insert_Many_Remove_1 Test PASSED.");
		}
	}
	
	/**
     * Tests to make sure duplicate objects are allowed to be inserted and removed into the heap
     */
	public static void dups_allowed()
	{
		//- fails if duplicate values are not able to be inserted (and then removed)
		MaxPQ<Integer> test = new MaxPQ<Integer>();
		Integer nine = new Integer("9");
		try {
			test.insert(nine);
			test.insert(nine);
			test.removeMax();
			test.removeMax();
		}
		catch (Exception e)
		{
			System.out.println("Test FAILED. Duplicates could not be inserted");
		}
		System.out.println("Dups_Allowed Test PASSED.");
	}
	
	/**
     * Tests to make sure the array containing the max heap is properly expanding when it is full. 
     */
	public static void big_data() 
	{
		//- fails if the internal data structure does not expand properly to allow many items to be added and removed in max to min order
		MaxPQ<Integer> test = new MaxPQ<Integer>();
		test.insert(new Integer("1"));
		test.insert(new Integer("2"));
		test.insert(new Integer("3"));
		test.insert(new Integer("4"));
		test.insert(new Integer("5"));
		test.insert(new Integer("6"));
		test.insert(new Integer("7"));
		test.insert(new Integer("8"));
		test.insert(new Integer("9"));
		test.insert(new Integer("10"));
		try
		{
			test.insert(new Integer("11"));
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println("Test FAILED. The array was not expanded properly");
		}
		System.out.println("Big_Data Test PASSED.");
	}
}

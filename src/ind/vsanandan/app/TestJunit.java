package ind.vsanandan.app;

import org.junit.Test;
import static org.junit.Assert.*;


public class TestJunit {

	public void addUsers(){
	// Add 4 different types of users to UsersList
			//User 1: Employee type
			User user1 = new User("John Smith");
			user1.setAsEmployee();
			user1.addToUserList();
			
			//User 2: Affiliate type
			User user2 = new User("Williams David");
			user2.setAsAffiliate();
			user2.addToUserList();
			
			//User 3: Long term user, by setting the joining date before 2 years
			User user3 = new User("James Derek");
			user3.setJoinDate(01, 01, 2016, 1, 1, 0);
			user3.addToUserList();
			
			//User 4: Recent user
			User user4 = new User("Lawrence Prit");
			user4.addToUserList();
			
	}
		
	/*Test case 1: Employee bill with only groceries and total bill amount < 100
	 *  Generate a bill with user-id 1 (an Employee)
	 * amount of non-groceries is 0. Total amount (95 < 100)
	 * The percentage discount is 0
	 */
	@Test
	public void testEmployeeNoPercentageDiscount(){
		//Add all the 4 types of users only once in this test case
		addUsers();
		//Generate a bill for user1, an employee with userid 1
		Bill bill1 = new Bill(1, 0, 95);
		bill1.computeAmountAfterDiscount();
		bill1.displayBillDetails();
		assertTrue(bill1.getPercentageDiscount() == 0);
	}
	
	/*Test case 2: Employee bill with only non-groceries and total bill amount = 100
	 *  Hence percentage discount $30
	 */
	@Test
	public void testEmployeePercentageDiscount(){
		//Generate a bill for user1, an employee with userid 1
		Bill bill2 = new Bill(1, 100, 100);
		bill2.computeAmountAfterDiscount();
		bill2.displayBillDetails();
		assertTrue(bill2.getPercentageDiscount() == 30);
	}
	
	/*Test case 3: Employee bill with only groceries and total bill amount < 100
	 *  Hence no hundreds based discount
	 *  Only groceries and hence no percent based discount also
	 */
	@Test
	public void testEmployeeNoHundredsDiscount(){
		Bill bill3 = new Bill(1, 0, 99);
		bill3.computeAmountAfterDiscount();
		bill3.displayBillDetails();
		assertTrue(bill3.getHundredsBasedDiscount() == 0);
	}
	
	/*Test case 4: Employee bill with non-groceries for $100 and total bill amount $200
	 *  Hence Percentage discount $30 and for the remaining amount $170, 
	 *  100s based Discount $5; 
	 *  Hence the total discount $35
	 */
	@Test
	public void testEmployeeTotalDiscount(){
		Bill bill4 = new Bill(1, 100, 200);
		bill4.computeAmountAfterDiscount();
		bill4.displayBillDetails();
		assertTrue(bill4.getTotalDiscountAmount() == 35);
	}
	
	/*Test case 5: Affiliate bill with only groceries and total bill amount < 100
	 *  Generate a bill with user-id 2 (an affiliate)
	 * amount of non-groceries is 0. Total amount (95 < 100)
	 * The percentage discount is 0
	 */
	@Test
	public void testAffiliateNoPercentageDiscount(){
		Bill bill5 = new Bill(2, 0, 95);
		bill5.computeAmountAfterDiscount();
		bill5.displayBillDetails();
		assertTrue(bill5.getPercentageDiscount() == 0);
	}
	
	/*Test case 6: Affiliate bill with only non-groceries and total bill amount = 100
	 *  Hence percentage discount $10
	 */
	@Test
	public void testAffiliatePercentageDiscount(){
		Bill bill6 = new Bill(2, 100, 100);
		bill6.computeAmountAfterDiscount();
		bill6.displayBillDetails();
		assertTrue(bill6.getPercentageDiscount() == 10);
	}
	
	/*Test case 7: Affiliate bill with only groceries and total bill amount < 100
	 *  Hence no hundreds based discount
	 *  Only groceries and hence no percent based discount also
	 */
	@Test
	public void testAffiliateNoHundredsDiscount(){
		Bill bill7 = new Bill(2, 0, 99);
		bill7.computeAmountAfterDiscount();
		bill7.displayBillDetails();
		assertTrue(bill7.getHundredsBasedDiscount() == 0);
	}
	
	/*Test case 8: Affiliate bill with non-groceries for $100 and total bill amount $200
	 *  Hence Percentage discount $10 
	 *  and for the remaining amount $190, 100s based Discount $5; 
	 *  Hence the total discount $15
	 */
	@Test
	public void testAffiliateTotalDiscount(){
		Bill bill8 = new Bill(2, 100, 200);
		bill8.computeAmountAfterDiscount();
		bill8.displayBillDetails();
		assertTrue(bill8.getTotalDiscountAmount() == 15);
	}
	
	/*Test case 9: Long term user bill with only groceries and total bill amount < 100
	 *  Generate a bill with user-id 3 (a long term user)
	 * amount of non-groceries is 0. Total amount (95 < 100)
	 * The percentage discount is 0
	 */
	@Test
	public void testLongTermUserNoPercentageDiscount(){
		Bill bill9 = new Bill(3, 0, 95);
		bill9.computeAmountAfterDiscount();
		bill9.displayBillDetails();
		assertTrue(bill9.getPercentageDiscount() == 0);
	}
	
	/*Test case 10: Long term user bill with only non-groceries and total bill amount $100
	 *  Hence percentage discount $5
	 *  As the bill amount reduces below 100, there is no 100 based discount
	 */
	@Test
	public void testLongTermUserPercentageDiscount(){
		Bill bill10 = new Bill(3, 100, 100);
		bill10.computeAmountAfterDiscount();
		bill10.displayBillDetails();
		assertTrue(bill10.getPercentageDiscount() == 5);
	}
	
	/*Test case 11: Long term user bill with only groceries and total bill amount < 100
	 *  Hence no hundreds based discount
	 *  Only groceries and hence no percent based discount also
	 */
	@Test
	public void testLongTermUserNoHundredsDiscount(){
		Bill bill11 = new Bill(3, 0, 99);
		bill11.computeAmountAfterDiscount();
		bill11.displayBillDetails();
		assertTrue(bill11.getHundredsBasedDiscount() == 0);
	}
	
	/*Test case 12: Long term user bill with non-groceries for $100 and total bill amount $200
	 *  Hence Percentage discount $5 
	 *  and for the remaining amount $195, 100s based Discount $5; 
	 *  Hence the total discount $10
	 */
	@Test
	public void testLongTermUserTotalDiscount(){
		Bill bill12 = new Bill(3, 100, 200);
		bill12.computeAmountAfterDiscount();
		bill12.displayBillDetails();
		assertTrue(bill12.getTotalDiscountAmount() == 10);
	}
	
	/*Test case 13: Recent user bill with only groceries and total bill amount < 100
	 *  Generate a bill with user-id 4 (a recent user)
	 * amount of non-groceries is 0. Total amount (95 < 100)
	 * The percentage discount is 0
	 */
	@Test
	public void testRecentUserNoPercentageDiscount(){
		Bill bill13 = new Bill(4, 0, 95);
		bill13.computeAmountAfterDiscount();
		bill13.displayBillDetails();
		assertTrue(bill13.getPercentageDiscount() == 0);
	}
	
	/*Test case 14: Recent user bill with only non-groceries and total bill amount $100
	 *  Hence no percentage discount
	 */
	@Test
	public void testRecentUserPercentageDiscount(){
		Bill bill14 = new Bill(4, 100, 100);
		bill14.computeAmountAfterDiscount();
		bill14.displayBillDetails();
		assertTrue(bill14.getPercentageDiscount() == 0);
	}
	
	/*Test case 15: Recent user bill with only groceries and total bill amount < 100
	 *  Hence no hundreds based discount
	 */
	@Test
	public void testRecentUserNoHundredsDiscount(){
		Bill bill15 = new Bill(4, 0, 99);
		bill15.computeAmountAfterDiscount();
		bill15.displayBillDetails();
		assertTrue(bill15.getHundredsBasedDiscount() == 0);
	}
	
	/*Test case 16: Recent user bill with non-groceries for $100 and total bill amount $200
	 *  No Percentage discount for a Recent user
	 *  100s based Discount $10 for the total amount $200
	 *  Hence the total discount $10
	 */
	@Test
	public void testRecentUserTotalDiscount(){
		Bill bill16 = new Bill(4, 100, 200);
		bill16.computeAmountAfterDiscount();
		bill16.displayBillDetails();
		assertTrue(bill16.getTotalDiscountAmount() == 10);
	}

}

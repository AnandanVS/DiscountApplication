package ind.vsanandan.app;


/* Bill class is used to indicate the bill generated whenever a user purchases
 * an item. This class has parameters giving billNo, userId, 
 * no. of non grocery items, total number of items, amount for non-groceries, 
 * total amount, total discounts etc.
 */
public class Bill {
	
	//Class PropertY: billCount
	private static long billCount = 0;
	
	//Object property: billNo, userId, billAmount, amountForNongroceries etc.
	private long billNo, userId;
	private double billAmount, amountForNonGroceries, percentageDiscount, hundredsBasedDiscount, amountAfterDiscount;
	
	//Bill constructor requires userId, amountForNonGroceries, billAmount before discount
	public Bill(long userId,  double amountForNonGroceries, double billAmount){
		Bill.billCount++;
		this.billNo = Bill.billCount;
		this.userId = userId;
		this.amountForNonGroceries = amountForNonGroceries;
		this.billAmount = billAmount;
	}
	
	//computes the amount to be paid after all discounts
	public void computeAmountAfterDiscount(){
		float discountPercent = computeDiscountPercentage();
		this.percentageDiscount = amountForNonGroceries * discountPercent / 100.0;
		double amountAfterPercentageDiscount = this.billAmount - this.percentageDiscount;
		int noOfHundreds = (int) amountAfterPercentageDiscount / 100;
		this.hundredsBasedDiscount = noOfHundreds * 5;
		this.amountAfterDiscount = amountAfterPercentageDiscount - this.hundredsBasedDiscount;
	}
	
	/* Computes the discount percentage based on user type. 
	 * User type is obtained based on userId from user list stored in User class.
	 */
	private float computeDiscountPercentage(){
		UserType userType = User.getUserType(userId);
		float discountPercentage = 0;
		switch(userType){
			case Employee:
				discountPercentage = 30;
				break;
			case Affiliate:
				discountPercentage = 10;
				break;
			case LongTermUser:
				discountPercentage = 5;
				break;
			default:
				discountPercentage = 0;
				break;
		}
		return discountPercentage;
	}
	
	
	//getter for percentageDiscount
	public double getPercentageDiscount(){
		return this.percentageDiscount;
	}
	
	//getter for hundredsBasedDiscount
	public double getHundredsBasedDiscount(){
		return this.hundredsBasedDiscount;
	}
	
	//getter for totalDiscount i.e, the sum of percentage discount and hundreds discount
	public double getTotalDiscountAmount(){
		return this.percentageDiscount + this.hundredsBasedDiscount;
	}
	
	//display the bill details
	public void displayBillDetails(){
		System.out.println("---------------------------------------------------------------");
		System.out.println("Bill no: " + this.billNo);
		System.out.println("User id: " + this.userId);
		String userName = User.getUserName(this.userId);
		if(userName != null){
			System.out.println("User name: " + userName);
		}
		System.out.println("User type: " + User.getUserType(userId));
		//System.out.println("Total items: " + this.totalItems);
		System.out.println("Bill amount: " + this.billAmount);
		System.out.println("Amount for non-groceries: $" + this.amountForNonGroceries);
		System.out.println("Percentage discount amount: $" + this.percentageDiscount);
		System.out.println("Hundreds based discount: $" + this.hundredsBasedDiscount);
		System.out.println("Total discount: $" + (this.percentageDiscount + this.hundredsBasedDiscount));
		System.out.println("Bill amount after discount: $" + this.amountAfterDiscount);
		System.out.println("---------------------------------------------------------------");
		System.out.println();
	}
	
	


}

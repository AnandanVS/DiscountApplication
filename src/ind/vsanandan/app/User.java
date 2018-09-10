package ind.vsanandan.app;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

public class User {
	//class variable id to generate userId
	private static long id = 0;
	
	//class variable userList to store the users generated
	public static ArrayList<User> userList = new ArrayList<User>();
	private long userId;
	private String userName;
	private Date joinDate;
	private UserType userType;
	private boolean isEmployee, isAffiliate;
	
	//Default constructor
	public User(){
		User.id++;
		this.userId = User.id;
		this.joinDate = new Date();
	}
	
	//Constructor with userName
	public User(String userName){
		User.id++;
		this.userId = User.id;
		this.userName = userName;
		this.joinDate = new Date();
	}
		
	//Class method to return the userType when userId is given
	public static UserType getUserType(long userId){
		Iterator<User> userIt = User.userList.iterator();
		UserType userType = UserType.RecentUser;
		while(userIt.hasNext()){
			User user = userIt.next();
			if(user.userId == userId){
				userType = user.getUserType();
			}
		}
		return userType;
	}
	
	public static String getUserName(long userId){
		Iterator<User> userIt = User.userList.iterator();
		String name = null;
		while(userIt.hasNext()){
			User user = userIt.next();
			if(user.userId == userId){
				name = user.getUserName();
			}
		}
		return name;
	}
	
	public void setUserName(String userName){
		this.userName = userName;
	}
	
	public String getUserName(){
		return this.userName;
	}
	
	//Current user is added to userlist
	public void addToUserList(){
		User.userList.add(this);
	}
	
	//method to give userId
	public long getUserId(){
		return this.userId;
	}
	
	//To set the join date to an user so that he can be made long term or recent user
	public void setJoinDate(int day, int month, int year, int hour, int min, int sec){
		try{
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			String joinDateInFormat = day + "/" + month + "/" + year + " " + hour + ":" + min + ":" + sec;
			this.joinDate = format.parse(joinDateInFormat);	
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//A user is set as an employee
	public void setAsEmployee(){
		this.isEmployee = true;
	}
	
	//A user is set as an affiliate
	public void setAsAffiliate(){
		this.isAffiliate = true;
	}
	
	//based on the boolean variable user type is set
	private void setUserType(){
		if(isEmployee){
			userType = UserType.Employee;
		}
		else if(isAffiliate){
			userType = UserType.Affiliate;
		}
		//Check user has been a User for more than 2 years
		else if(this.numberOfYearsFromJoining() >= 2){
				userType = UserType.LongTermUser;
		}
		else{
			userType = UserType.RecentUser;
		}
	}
	
	//getter for userType
	public UserType getUserType(){
		this.setUserType();
		return userType;
	}
	
	//To decide whether user is long term or recent user
	private int numberOfYearsFromJoining(){
		Date currentDate = new Date();
		Calendar currentCal = Calendar.getInstance();
		Calendar joinCal = Calendar.getInstance(); 
		currentCal.setTime(currentDate);
		joinCal.setTime(joinDate);
		int diffInYear = currentCal.get(Calendar.YEAR) - joinCal.get(Calendar.YEAR);
		if((diffInYear > 0) && (currentCal.get(Calendar.MONTH) < joinCal.get(Calendar.MONTH))){
			diffInYear--;
		}
		return diffInYear;
	}
}

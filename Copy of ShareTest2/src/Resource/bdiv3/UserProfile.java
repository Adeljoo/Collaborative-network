package Resource.bdiv3;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

import jadex.bdiv3.annotation.Goal;
import jadex.bdiv3.annotation.GoalParameter;
import jadex.bdiv3.annotation.GoalResult;

/**
 * 
 */

public class UserProfile
{
	/** The name. */
	protected String name;
	
	/** The age. */
	protected int sample;
	
	/** The gender. */
	protected String company;
	protected String status;
	
	/** The description. */
	protected String description;
	//protected String file;
	 protected String date;
	 protected Integer Credibility;
	//private Dateformat //format2;
	//-------- constructors --------

	/**
	 *  Create a new user profile.
	 */
	

	/**
	 *  Create a new user profile.
	 * @param string 
	 * 
	 */
	public UserProfile(String name, int sample, String company, String string, String date, String description)
	{
		this.name = name;
		this.sample = sample;
		
		this.company = company;
		this.status= status;
		//format2 = format;
		this.date = date;
		this.description = description;
		
	}






	/**
	 *  Get the name.
	 *  @return The name.
	 */
	public String getName()
	{
		return name;
	}

	/**
	 *  Set the name.
	 *  @param name The name to set.
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 *  Get the age.
	 *  @return The age.
	 */
	public int getSample()
	{
		if ( sample == 1000 )
				
		return sample; 
		else { return (1000 - sample)
				;}
	}

	/**
	 *  Set the age.
	 *  @param age The age to set.
	 */
	public void setSample(int sample)
	{ 
		this.sample = sample;
	}

	/**
	 *  Get the company.
	 *  @return The gender.
	 */
	public String getCompany()
	{
		return company;
	}

	/**
	 *  Set the gender.
	 *  @param gender The gender to set.
	 */
	public void setCompany(String company)
	{
		this.company = company;
	}

//staus 
	public String getStatus()
	{   if (sample==1000)
		
		return status="No cheating"; 	{return status = "Cheating happend";}
	
	}

	/**
	 *  Set the gender.
	 *  @param gender The gender to set.
	 */
	public void setStatus(String status)
	{
		this.status = status;
	}

	
	/**
	 * Set file
	 * @return 
	 */
	public String getDate()
	{
		Date date = new Date();
	    SimpleDateFormat simpDate;

	    simpDate = new SimpleDateFormat("hh:mm:ss a");
	    System.out.println(simpDate.format(date));
		return simpDate.format(date);
		
	}
	
	

	/**
	 *  Set the file.
	 *  @param file to set.
	 */
	public void setDate(String date)
	{
		this.date = date;
	}
	/**
	 *  Get the description.
	 *  @return The description.
	 */
	public String getDescription()
	{
		
		
		//If description = 
		return description;
	}
	
	

	/**
	 *  Set the description.
	 *  @param description The description to set.
	 */
	public void setDescription(String description)
	{
		this.description = description;
	}


	/**
	 *  Get the string representation.
	 */
	public String toString()
	{
		return "UserProfile(name=" + name + ", sample=" + sample + ", company="
			+ company + ", status=" + status + ", date=" + date + ", description=" + description + ")";
	}

	/*public String message(String name2) {
		// TODO Auto-generated method stub
		return "UserProfile(name=" + name + ", sample=" + sample + ", company="
		+ company + ", description=" + description + ")";
	}*/
	
}

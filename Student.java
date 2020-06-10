import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Student
{
	String firstName = null;	// String variable declaration firstName to hold student's First Name
	String lastName = null;		// String variable declaration lastName to hold student's Last Name
	String studentID = null;	// String variable declaration studentID to hold student's ID
	
	byte idLength = 0;			// Byte variable declaration idLegth for checking student id length against
	char [] nameArray = null;	// Declaring and array of characters
	byte nameLength = 0;		// Byte variable declaration nameLegth for checking first and last name length against
	Scanner myScanner = null;	// Declaring Scanner which scans text allowing a program to perform different
								// 	action with an input.
	
	/*
	 * Below validation pattern
	 * was seen implemented
	 * and posted right here: https://howtodoinjava.com/regex/java-regex-validate-email-address/
	 * https://www.regextester.com/ -- regex testing
	 */
	String idValidator = "^[T]0{2}6{1}\\d{5}";
	String nameValidator = "^[\\p{Digit}\\p{Punct}]*$";
	Pattern idPattern = Pattern.compile(idValidator);
	Pattern namePattern = Pattern.compile(nameValidator);
	Matcher validationMatcher = null;
	
	Student()
	{
	try
	{		
		myScanner = new Scanner(System.in);
		System.out.println(" \r Enter your first name: ");
		firstName = myScanner.nextLine();
		
		nameLength = (byte) firstName.length();
		validationMatcher = namePattern.matcher(firstName);
		
		while (nameLength == 0 | nameLength > 15|validationMatcher.matches())
		{
		if (nameLength > 15)
		{
			System.out.println(" \r First name provided is long."
					+ " \n Use 15 characters or less."
					+ " \n Enter your first name again: ");
		firstName = myScanner.nextLine();
		
		nameLength = (byte) firstName.length();
		validationMatcher = namePattern.matcher(firstName);
		}
		if (nameLength == 0)
		{
			System.out.println(" \r First name provided is short."
					+ " \n Use 15 characters or less."
					+ " \n Enter your first name again: ");
			firstName = myScanner.nextLine();
			
			nameLength = (byte) firstName.length();
			validationMatcher = namePattern.matcher(firstName);
		}
		if(validationMatcher.matches())
		{
			System.out.println(" \r Only characters are accepted."
					+ " \n Enter your first name again:");
			firstName = myScanner.nextLine();
			
			nameLength = (byte) firstName.length();
			validationMatcher = namePattern.matcher(firstName);
		}
		} //End of While
		
		
		nameArray = firstName.toCharArray();				// turning a string into array of characters
		nameArray[0] = Character.toUpperCase(nameArray[0]);	// in order to capitalize first letter
		firstName = new String(nameArray);
		
		System.out.println(" \r Enter your last name: ");
		lastName = myScanner.nextLine();
		
		nameLength = (byte) lastName.length();
		validationMatcher = namePattern.matcher(lastName);
		
		while (nameLength == 0 | nameLength > 15|validationMatcher.matches())
		{
		if (nameLength > 15)
		{
		System.out.println(" \r Last name provided is long."
				+ " \n Use 15 characters or less."
				+ " \n for your last name."
				+ "\n Enter it again: ");
		lastName = myScanner.nextLine();
		
		nameLength = (byte) lastName.length();
		validationMatcher = namePattern.matcher(lastName);
		} // end of if statement
		if (nameLength == 0)
		{
			System.out.println(" \r Last name provided is short."
					+ " \n Use 15 characters or less."
					+ " \n Enter your last name again: ");
			lastName = myScanner.nextLine();
			
			nameLength = (byte) lastName.length();
			validationMatcher = namePattern.matcher(lastName);
		}
		if(validationMatcher.matches())
		{
			System.out.println(" \r Only characters are accepted."
					+ " \n Enter your last name again:");
			lastName = myScanner.nextLine();
			
			nameLength = (byte) lastName.length();
			validationMatcher = namePattern.matcher(lastName);
		}
		} // End of While
	
	nameArray = lastName.toCharArray();	
	nameArray[0] = Character.toUpperCase(nameArray[0]);
	lastName = new String(nameArray);
	/*
	* above logic for
	* capitalizing a first letter of string input 
	* was seen posted here:
	* https://stackoverflow.com/questions/34538000/uppercase-or-lowercase-a-specific-character-in-a-word-java
	* by:	Abdelhak
	*/
		
	System.out.println(" \r Enter your student I.D.:");
	studentID = myScanner.nextLine();
	idLength = (byte) studentID.length();
	validationMatcher = idPattern.matcher(studentID);
	
	while (idLength == 0 | nameLength > 9|validationMatcher.matches())
	{
	if (idLength > 9)
	{
	System.out.println(" \r Wrong format."
			+ " \n Use T006***** format."
			+ " \n Enter your ID again: ");
	studentID = myScanner.nextLine();
	idLength = (byte) studentID.length();
	validationMatcher = idPattern.matcher(studentID);
	} // end of if statement
	else if(idLength == 0)
	{
	System.out.println(" \r Wrong format."
			+ " \n Use T006***** format."
			+ " \n Enter your ID again: ");
	studentID = myScanner.nextLine();
	idLength = (byte) studentID.length();
	validationMatcher = idPattern.matcher(studentID);
	}
	else if(idLength<9)
	{
	System.out.println(" \r Wrong format."
			+ " \n Use T006***** format."
			+ " \n Enter your ID again: ");
	studentID = myScanner.nextLine();
	idLength = (byte) studentID.length();
	validationMatcher = idPattern.matcher(studentID);
	}
	else if(validationMatcher.matches())
	{
		System.out.println(" \r Only characters are accepted."
				+ " \n Enter ID again:");
		studentID = myScanner.nextLine();
		
		idLength = (byte) studentID.length();
		validationMatcher = idPattern.matcher(studentID);
	}
	} // End of While
	
	nameArray = studentID.toCharArray();	
	nameArray[0] = Character.toUpperCase(nameArray[0]);
	studentID = new String(nameArray);

	System.out.println("\n\r Hello " + firstName +" " + lastName + ","
			+ " \n welcome to T.R.U."
			+ " \n Your I.D. is : " + studentID);
	} // End of try statement
	finally
	{
		if (myScanner!=null)
		myScanner.close();
	}	
} // End of Student() constructor
} // End of Student class

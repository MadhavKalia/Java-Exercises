import java.io.*;//FileReader is found in this class
public class ReadFiles {
	

	public static double CalcAvg (String marks){ //this method receives a string of marks and converts them into doubles and returns the average of the row
		
		double avg=0; //create variable for average of each row 
		double mark;//create variable to store mark
		int y=0;//variable to read characters of the string
		double place2=100;//variable to round to two decimal places
		int invalid=0;//variable to check is mark is negative
	
		if((marks.length()!=8)) { //checks if there are 4 marks in the row or if mark is valid (00-99)
			
			avg=-1; //if there not 4 marks or invalid marks then avg equals -1
		}
		
		else { //runs code if there are 4 marks in the row
			
			for (int z=0; z<4; z++) { // runs until all marks are read in the row
				mark=Double.parseDouble(marks.substring(y,y+2));//converts string to double 
		
				if(mark<0) { //if mark is negative then invalid is 1 
					
					invalid=1; //sets invalid=1 which is checked later on in the code
				}
				
				y=y+2;//increases by 2 to read the next set of string values to convert to a double
				avg=avg+mark; // adds up all the marks in the row
				
			}
			
			avg=avg/4;//divides total by number of marks
			avg=Math.round(avg*place2)/place2;//rounds average to two decimal places
			
			if (invalid==1) { //if mark was negative in the code then returns -1
				
				avg=-1; //sets avg=-1 
			}
			
		}
		
		return avg; //returns average of the row back to the main program
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String x; //creating variable used to store data from file
		double average_row; //creating variable for storing average of each row
		double average_class=0; //creating variable for storing average of class
		int z=0; //creating variable to keep track of the amount of rows in file
		double place=100; //variable for rounding to two decimal places
		
		try {
			FileReader fr = new FileReader("/Users/neelkalia/Desktop/markset.txt"); //1) FileReader
			BufferedReader br = new BufferedReader(fr); // 2) BufferedReader
			
			while ((x = br.readLine()) != null) { // 3) reads data into x and then compares x to null
				
				average_row=CalcAvg(x); //sends the string to method and receives average of the row
				System.out.println("Average of row: "+ average_row+ "%"); //prints the average of the row
				
				if (average_row>0) {//checks to see if -1 was returned, doesn't include row average in class average then if -1 is returned
					
					z++; //increases by 1 for each row
					average_class=average_class+average_row; //adds the row averages up for class average 
				}
			}
		br.close(); //close br (close the file)

		average_class=average_class/z; //divides the sum of all rows by the number of rows there are for class average
		average_class=Math.round(average_class*place)/place; //rounds to two decimal places
		
		
		System.out.println("Average of class: "+ average_class+ "%"); //prints the average of the class 
			
		}catch (IOException e) {} //
		catch (NumberFormatException e){}  //catches formatting errors in the text and ignores them
		
	}

}

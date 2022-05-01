public class Team {
	
	player head;
	
	public class player {
		
		private String lname; // Last name of Player
		private int [] points = new int[3];
		// index 0 in points is the goals scored
		// index 1 in points is the assists made
		// index 2 in points is the total points scored.
		private player link;
		
		player(String x, int g, int a, player p) {
			// constructor to create player sets lname to x, goals to g and assists a if valid
			lname=x;
			
			if (g<0) { //if invalid goals then goals is set to 0
				points [0]=0;
			}
			
			if (a<0) { //if invalid assists then assists is set to 0
				points[1]=0;
			}
			
			if (g>=0 && a>=0) { // if index 0 and 1 are set to goals and assists if they are valid
				points[0]=g;
				points[1]=a;
			}
			
			points [2]=points[0]+points[1]; //points is set to goals+assists
			link=p; 
		}
		
		public void putgoals (int g) {
			if (g>=0) { //sets goals to g if valid
				points[0]=g;
			}
			//changes points with new goals
			points[2]=points[0]+points[1];
		}
		
		public void printplayer() { //prints all fields 
			System.out.println("name: "+lname);
			System.out.println("goals: "+ points[0]);
			System.out.println("assits: "+ points[1]);
			System.out.println("points: "+ points[2]);
		}
		
		
	}
	
	public void insert(String ln, int g, int a) { //inserts player alphabetically
		player current = head; // current points to the current Node
		player previous = null; // previous points to the previous Node
		// The new Node will we inserted between previous and current

		boolean located = false; // Once the location is found, located will be true
		while (located==false && current != null){
			if (ln.compareTo(current.lname)<0 ) //using compareTo() function to check alphabetically
				located = true;
			else
			{
				previous = current; // moves along the list	
				current = current.link;
			}	
	
		}
		player newNode = new player(ln,g,a, current);
		// creates a new Node with ln, g and a as the fields and points to ‘current’
	
		if (current == head)
			head = newNode; // if new Node was inserted into an empty list
		else
			previous.link=newNode;
	}
	
	public void remove(String x) { //removes player of name x
		
		player current = head; // current points to the current Node
		player previous = null; // previous points to the previous Node

		boolean found = false; // Once the location is found, located will be true
		while (found==false && current != null){
			if (x.equals(current.lname))
				found = true; //player found
			else
			{
				previous = current; // moves along the list	
				current = current.link;
			}	
	
		}
		if (found==true) {
			if (current == head)
				head = head.link; // if Node being removed is first node, there is no previous node
			else
				previous.link=current.link;
			
		}
		
	}
	
	public void remove() { //removes players with 0 points 
		boolean a=true; // if points is 0 then a will be false
		do {
			player current = head; // current points to the current Node
			player previous = null; // previous points to the previous Node
	
			boolean found = false; // Once the location is found, located will be true
			while (found==false && current != null){
				if (current.points[2]==0)
					found = true; //player found
				else
				{
					previous = current; // moves along the list	
					current = current.link;
				}	
		
			}
			if (found==true) {
				if (current == head)
					head = head.link; // if Node being removed is first node, there is no previous node
				else
					previous.link=current.link;
			}
			
			for (player temp=head; temp!=null; temp=temp.link) {
				if (temp.points[2]==0) {
					a=false; // array contains 0 points, a is set to false and goes back to start of loop
					break; 
				}
				else {
					a=true; //array does not contain 0 points then a is set to true and exits loop
				}
			}
			
		}while(a==false); // loops while the list has points 0
	}
	
	public void print() { //prints all the players in the list
		for (player temp=head; temp!=null; temp=temp.link) {
			temp.printplayer();
		}
	}
	
}

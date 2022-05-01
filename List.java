
public class List {
	
	private fraction head;
	
	public class fraction{
		
		private int num;
		private int den;
		private fraction link;
		
		fraction (){
			num=1;
			den=1;
			link=null;
		}
		
		fraction (int n, int d, fraction f){
			num=n;
			den=d;
			link=f;
		}

	}
	
	public void insertFirst(int n, int d) {
		head=new fraction(n,d,null);
	}
	
	public void insertSecond(int n, int d) {
		head.link=new fraction(n,d,null);
	}
	
	public void insertThird(int n, int d) {
		head.link.link=new fraction(n,d,null);
	}
	
	public void addatEnd(int n, int d) {
		fraction current = head; // current points to the current Node
		boolean located = false; // Once the location is found, located will be tr
		while(located==false) {
			if (current.link==null) {
				located=true;
				
			}
			else {// moves along the list	
				current = current.link;
			}
			
		}
		
		fraction newNode = new fraction(n,d, null);
		// creates a new Node with item as info and points to ‘current’
		current.link=newNode;
	
		
	}
	
	public void addatFront() {
		head= new fraction(1,1,head);
	}
	
	public void addatFront(int n, int d) {
		head= new fraction(n,d,head);
	}
	
	
	public void printList() {
		for (fraction temp=head; temp!=null; temp=temp.link) {
			System.out.println(temp.num);
			System.out.println(temp.den);
		}
		
	}
	
	
	
	public void insert (int n,int d){

		fraction current = head; // current points to the current Node
		fraction previous = null; // previous points to the previous Node
		// The new Node will we inserted between previous and current

		boolean located = false; // Once the location is found, located will be true
		while (located==false && current != null){
			if (n < current.num&&d<current.den)
				located = true;
			else
			{
				previous = current; // moves along the list	
				current = current.link;
			}	
	
		}
		fraction newNode = new fraction(n,d, current);
		// creates a new Node with item as info and points to ‘current’
	
		if (current == head)
			head = newNode; // if new Node was inserted into an empty list
		else
			previous.link=newNode;
	}
	
	public void delete(int n, int d) {
		
		fraction current = head; // current points to the current Node
		fraction previous = null; // previous points to the previous Node
		// The new Node will we inserted between previous and current

		boolean found = false; // Once the location is found, located will be true
		while (found==false && current != null){
			if ((n == current.num)&&(d==current.den))
				found = true;
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

	public int sumNum() {
		int sum=0;
		for (fraction temp=head; temp!=null; temp=temp.link) {
			sum=sum+temp.num;
		}
		return sum;
	}
	
	public int getNum (int x) {
		int a=0;
		return a;
	}
	

	public int getDen (int x) {
		int a=0;
		return a;
	}
	
	

}

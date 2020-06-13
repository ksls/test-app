import java.util.List;


public class Main {

	public static void main(String[] args) {
		
		
		DatingRecoAlgo datingAlgo = new DatingRecoAlgo();
		
		
		Person pA = new Person("UserA",25,"Female", "Cricket", null);
		
		//Person p1 = new Person("UserA",25,"Female", "Cricket", null);
		
		
		Person pB = new Person("UserB",27,"Male", "Cricket,Football,Movies,", null);
		Person pC = new Person("UserC",26,"Male", "Movies,Tennis,Football,Cricket", null);
		Person pD = new Person("UserD",24,"Female", "Cricket", null);
		Person pE = new Person("UserE",32,"Female", "Cricket", null);
		
		
		datingAlgo.addUser(pA);
		
		datingAlgo.addUser(pB);
		
		datingAlgo.addUser(pC);
		datingAlgo.addUser(pD);
		datingAlgo.addUser(pE);
	
		
		List<Person> plist=  datingAlgo.findTopMatch("UserB", 2);
		
		for(Person p:plist){
			System.out.println(p);
			
		}
		

	}

}

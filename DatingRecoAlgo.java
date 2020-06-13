import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DatingRecoAlgo {
	
	
	private List<Person> maledb = new ArrayList<>();
	
	private List<Person> femaledb = new ArrayList<>();
	
	
	private HashMap<String, Person> allpersondb = new HashMap<>();
	
	//private List<Person> pp = new ArrayList<>();
	
	private static final String MALE= "Male";
	private static final String FEMALE = "Female";
	
	
	public DatingRecoAlgo(){
		
	}
	
	
public void addUser(Person person){
		addUser(person.getName(),person.getAge(),person.getGender(),person.getInterests(),person.getAttr());
	}
	public void addUser(String name, int age,  String gender, String interests, Map<String, String> attr){// initialize user data set
		
		Person p = new Person(name, age, gender, interests, attr);
		
		if(MALE.equalsIgnoreCase(gender)){
			
			maledb.add(p);
			
		}else if(FEMALE.equalsIgnoreCase(gender)){
			femaledb.add(p);
			
		}
		
		allpersondb.put(name, p);
	}
	
	/**
	 * find top match and return n list
	 * @param num
	 * @return
	 */
	public List<Person> findTopMatch(String user,int n){
		List<Person> matchList = new ArrayList<>(n);
		
		boolean find = false;
		Person person= allpersondb.get(user);
		
		
		if(null == person){
			
				// user is not in database
				
				throw new IllegalArgumentException(user+" is not present in database");
			
		}
		
		
		String [] pintlist = null;
		String pinteresets= person.getInterests();
		
		
		//if male
		if(person.getGender().equalsIgnoreCase(MALE)){
		
			
			
			matchList =  findmatch(femaledb, person, n);
			
			
			
		}else if(person.getGender().equalsIgnoreCase(FEMALE)){
			
			matchList =  findmatch(femaledb, person, n);
			
		}
		
		
		//if female
		
	
		
		
		
		return matchList;
		
		
	}
	

	private List<Person> findmatch(List<Person> pdb, Person person, int n){
		
		List<Person> matchList = new ArrayList<>(n);
		String pinteresets= person.getInterests();
		pdb.sort(new Comparator<Person>() {
			

			@Override
			public int compare(Person p1, Person p2) {
				
				int agediff1 = Math.abs(p1.getAge() - person.getAge());
				int agediff2 = Math.abs(p2.getAge() - person.getAge());
				
				String [] p1intlist = new String[0];
				String [] p2intlist = new String[0];	
				
				
				int countmatch1 = 0;
				int countmatch2 =0;
				
				if(null != pinteresets){
				if(null != p1.getInterests()){
					
					p1intlist = person.getInterests().split(",");
				}
				
				for(String str:p1intlist){
					if(pinteresets.contains(str)){
						countmatch1++;
					}
				}
				
				
				if(null != p2.getInterests()){
					p2intlist = person.getInterests().split(",");
				}
				
				
				for(String str:p2intlist){
					if(pinteresets.contains(str)){
						countmatch2++;
					}
				}
				
				}
				
				
				
				
				
				if(agediff2 == agediff1 ){
					
					if(countmatch2>countmatch1){
						return 1;
					}else if(countmatch2< countmatch1){
						return -1;
					}
					
					return 0;
					
			 
					
				}else if(agediff2> agediff1){
					return -1;
				}
				return 1;
			}
		});
		
		
		int count = 0;
		
		//femaledb.
		for(Person p:pdb){
			
			
			matchList.add(p);
			
			++count;
			
			
			
            if(count==n){
				break;
			}
			
			
			
			
		}
		
		if(count == 0){
			return new ArrayList<Person>();
		}
		
		
		return matchList;
	}
	
	
	public List<Map<String, Map<String, String>>> findTopMatch(String user,
			String criteria, 
			String prefernce, int n){
		List<Map<String, Map<String, String>>> matchList = new ArrayList<>();
		
		
		
		return matchList;
		
		
	}
	
	
	
	
	

}

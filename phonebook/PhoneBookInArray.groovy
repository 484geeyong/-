package phonebook

import java.util.List

class PhoneBookInArray implements IPhoneBook{


	private List<Entry> PhoneBookInArray;
	PhoneBookInArray(){
		PhoneBookInArray = [];
	}

	public int findLoc(String name){
		for (int i=0; i<PhoneBookInArray.size(); ++i){
			if (PhoneBookInArray[i].phoneName == name)
				return i;
		}
		return -1; // not found
	}
	public int findLoc2(int number){
		for (int i=0; i<PhoneBookInArray.size(); ++i){
			if (PhoneBookInArray[i].phoneNumber == number)
				return i;
		}
		return -1; // not found
	}

	public int find(String name){
		int loc = findLoc(name);
		if (loc == -1)
			return -1; // not found
		return PhoneBookInArray[loc].phoneNumber;


	}

	static int findPhoneNumber(String name){
		int loc = findLoc(name);
		if (loc == -1)
			return -1; // not found
		return PhoneBookInArray[loc].phoneNumber;
	}

	public boolean insert(String name, int number){
		int loc = findLoc(name);
		if (loc == -1){
			PhoneBookInArray.add(new Entry(name, number));
			//PhoneBookInArray[loc]=new Entry(name, number);
			//PhoneBookInArray[loc].phoneNumber=Number;
			return true;

		}
		else {
			println "***Error -- Duplicated Name";
			return false;
		}
	}
	public boolean remove(String name){
		int loc = findLoc(name);
		if (loc != -1){
			PhoneBookInArray.remove(loc);
			return true;
		}


		else {
			println "***Error -- Name not found";
			return false;
		}
	}
	public boolean update(String name, int number){
		if (remove(name)) {
			insert(name, number);
			return true;
		}
		else {
			return false;
		}
	}
//		int loc = findLoc(name);
//		if (loc != -1){
//			
//			PhoneBookInArray[loc].phoneNumber=number
//			return true;
//		}
//
//
//		else {
//			return false;
//		}
	

	public void listAll(){
		println "Name\tNumber";
		for (int i=0; i<PhoneBookInArray.size(); ++i){
			println "${PhoneBookInArray[i].phoneName}\t" +
					"${PhoneBookInArray[i].phoneNumber}"
		}
	}
	static main (args) {
		//int incount = 10;
		String[] nameData = ["Park SH", "Kang JH",
			"Kim KS", "Lee YH", "Kang SH","Bae JM",
			"Lee DI", "Lee BH", "Jang WH", "Chun WY"];
		int[] numberData = [5023, 5002, 5008,
			5067, 5038, 5381, 5125, 5165, 5684, 5752];

		PhoneBookInArray pbook = new PhoneBookInArray();

		for (int i=0; i < nameData.length; ++i){
			pbook.insert(nameData[i], numberData[i]);
		}
		println "List All Inserted Entry";
		pbook.listAll();

		pbook.remove("Kim KS");
		pbook.insert("Kim CS", 5555);
		pbook.update("Kang JH", 5999);
		pbook.insert("Yoon GY", 7077);
		
		pbook.remove("Lee YH");
		pbook.update("Park SH", 8282);

	


		println "Find Phone Number of Kim CS";
		if (pbook.find("Kim CS") != -1) {
			
			println "${pbook.find("Kim CS")}";
		}
		else {
			println "\t***Error -- Name not found";
		}

		println "List All Updated Entry";
		pbook.listAll();



	}

}

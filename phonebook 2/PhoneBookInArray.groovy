package phonebook

import java.util.List

class ListPhoneBook {


	private List<Entry> ListPhoneBook;
	ListPhoneBook(){
		ListPhoneBook = [];
	}

	public int findLoc(String name){
		for (int i=0; i<ListPhoneBook.size(); ++i){
			if (ListPhoneBook[i].phoneName == name)
				return i;
		}
		return -1; // not found
	}
	public int findLoc2(int number){
		for (int i=0; i<ListPhoneBook.size(); ++i){
			if (ListPhoneBook[i].phoneNumber == number)
				return i;
		}
		return -1; // not found
	}

	public String find(int number){
		int loc = findLoc2(number);
		if (loc == -1)
			return null; // not found
		return ListPhoneBook[loc].phoneName;


	}

	static int findPhoneNumber(String name){
		int loc = findLoc(name);
		if (loc == -1)
			return -1; // not found
		return ListPhoneBook[loc].phoneNumber;
	}

	public boolean insert(String name, int number){
		int loc = findLoc(name);
		if (loc == -1){
			ListPhoneBook.add(new Entry(name, number));
			//ListPhoneBook[loc]=new Entry(name, number);
			//ListPhoneBook[loc].phoneNumber=Number;
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
			ListPhoneBook.remove(loc);
			return true;
		}


		else {
			println "***Error -- Name not found";
			return false;
		}
	}
	public boolean update(String name, int number){
		int loc = findLoc(name);
		if (loc != -1){
			//ListPhoneBook.add(new Entry(name, number));
			ListPhoneBook[loc].phoneNumber=number
			return true;
		}


		else {
			return false;
		}
	}

	public void listAll(){
		println "Name\tNumber";
		for (int i=0; i<ListPhoneBook.size(); ++i){
			println "${ListPhoneBook[i].phoneName}\t" +
					"${ListPhoneBook[i].phoneNumber}"
		}
	}
	static main (args) {
		//int incount = 10;
		String[] nameData = ["Park SH", "Kang JH",
			"Kim KS", "Lee YH", "Kang SH","Bae JM",
			"Lee DI", "Lee BH", "Jang WH", "Chun WY"];
		int[] numberData = [5023, 5002, 5008,
			5067, 5038, 5381, 5125, 5165, 5684, 5752];

		ListPhoneBook p = new ListPhoneBook();

		for (int i=0; i < nameData.length; ++i){
			p.insert(nameData[i], numberData[i]);
		}
		println "List All Inserted Entry";
		p.listAll();

		p.remove("Kim KS");
		p.insert("Kim CS", 5555);
		p.update("Kang JH", 5999);
		p.insert("Yoon GY", 7077);
		p.remove("Lee YH");
		p.update("Park SH", 8282);

	



		if (p.find(5125) != null) {
			println "Find Phone Name By Number -- 5125 : ${p.find(5125)}";
		}
		else {
			println "\t***Error -- Name not found";
		}

		println "List All Updated Entry";
		p.listAll();



	}

}

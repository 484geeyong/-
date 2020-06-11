package phonebook

class PhoneBookPolyTest {

	static void testPhoneBook(IPhoneBook pbook) {

		println "***Test ${pbook.class} PhoneBook***";

		String[] nameData = ["Park SH", "Kang JH",
			"Kim KS", "Lee YH", "Kang SH","Bae JM",
			"Lee DI", "Lee BH", "Jang WH", "Chun WY"];
		int[] numberData = [5023, 5002, 5008,
			5067, 5038, 5381, 5125, 5165, 5684, 5752];

		for (int i=0; i < nameData.length; ++i){
			pbook.insert(nameData[i], numberData[i]);
		}
		println "List All Inserted Entry";
		pbook.listAll();

		if (!pbook.insert(nameData[9], numberData[9])){
			println "***Error in Insert -- ${nameData[9]} ***";
		};
		if (!pbook.remove("Kim KS")){
			println "***Error in Remove -- Kim KS ***";
		};
		if (!pbook.insert("Kim CS", 5555)){
			println "***Error in Insert -- Kim CS ***";
		};
		if (!pbook.update("Kang JH", 8088)){
			println "***Error in Update -- Kang JH ***";
		};// 아래 이전 데이터 그래도 테스트 데이터사용 
		if (!pbook.insert("Yoon GY", 7077)){
			println "***Error in Insert -- Yoon GY ***";
		};
		if (!pbook.remove("Lee YH")){
			println "***Error in Remove -- Lee YH ***";
		};
		if (!pbook.update("Park SH", 8282)){
			println "***Error in Update -- Park SH ***";
		};
		println "Find Phone Number By Name -- Kim CS	${pbook.find("Kim CS")}";

		println "***List All Updated Entry";
		pbook.listAll();
	}
	static main(args) {
		testPhoneBook(new PhoneBookInArray());
		testPhoneBook(new PhoneBookList());
		testPhoneBook(new PhoneBookMap());
	}

}

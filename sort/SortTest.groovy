package sort

class SortTest {


	static main(args) {

		List<Card> deck = new ArrayList<Card>();
		// Make a Card Deck
		for (int s=Card.CLUB; s<=Card.SPADE; s++) {
			for (int r=Card.ACE; r<=Card.KING; r++){
				deck.add(new Card(s,r));
			}
		}
		sortTest(new SelSort(deck));

		sortTest(new MergeSort(deck));

		sortTest(new QuickSort(deck));
	}
	static void sortTest(ISorter sorter) {
		println "List before ${sorter.class.getName()}";
		printList(sorter.getList());
		println "List after ${sorter.class.getName()}"
		printList(sorter.sort());

	}
	static void printList(List list) {
		final int  LINE_MAX = 13;
		int i = 0;
		for (Card c:list) {
			print "$c ";
			i++;
			if (i % LINE_MAX == 0) println();
		}
		println();
	}

}

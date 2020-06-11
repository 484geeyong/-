package sort

import java.util.ArrayList
import java.util.List

class SelSort<T> implements ISorter<T> {

	ArrayList<T> list = null;

	public SelSort(ArrayList<T> list) {
		this.list = list.clone();
	}

	@Override
	public List<T> getList() {
		return list;
	}
	@Override
	public List<T> sort() {

		int lsize = list.size();
		for (int i=0; i<lsize; ++i){
			int minit = getMinIndex(i);
			swapNode(i, minit);
		}
		return list;
	}
	private void swapNode(int p, int q) {
		T tempNode = list.get(p);
		list.set(p, list.get(q));
		list.set(q, tempNode);
	}
	private int getMinIndex(int rest) {
		assert rest >= 0 && rest < list.size();
		int minInd = rest;
		for (int i=rest+1; i<list.size(); ++i) {
			if (list.get(i).toString() < list.get(minInd).toString()) {
				minInd = i
			}
		}
		return minInd;
	}
	static main(args) {

		List<Card> deck = new ArrayList<Card>();
		// Make a Card Deck
		for (int s=Card.CLUB; s<=Card.SPADE; s++) {
			for (int r=Card.ACE; r<=Card.KING; r++){
				deck.add(new Card(s,r));
			}
		}
		SelSort sorter = new SelSort(deck);
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

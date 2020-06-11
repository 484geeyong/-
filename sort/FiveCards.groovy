package sort

class FiveCards implements Comparable<FiveCards> {

	Card[] fiveCards = new Card[5];
	
	FiveCards (Card[] cards) {
		assert cards.length == 5;
		for (int i=0; i<5; ++i) {
			fiveCards[i] = cards[i];
		}
	}
	@Override
	public int compareTo(FiveCards right) {
		return fiveCards[0].compareTo(right.fiveCards[0]);
		
	}
	@Override
	public String toString() {
		String result = "[";
		for(int i=0; i<5; ++i) {
			 if ( i != 0 ) result+=", ";
			 result += fiveCards[i].toString();
		}
		result += "]";
		return result;	
	}
}

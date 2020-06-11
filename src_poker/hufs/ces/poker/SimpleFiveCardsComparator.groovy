package hufs.ces.poker

import java.util.Comparator

class SimpleFiveCardsComparator implements Comparator<FiveCards> {
	//	int gee,gee1,gee2,gee3,gee4,sum;

	public int compare(FiveCards left, FiveCards right) {
		if(left.fiveCards[0].compareTo(right.fiveCards[0]) != 0)
			return left.fiveCards[0].compareTo(right.fiveCards[0]);
		else if(left.fiveCards[1].compareTo(right.fiveCards[1]) !=0)
			return left.fiveCards[1].compareTo(right.fiveCards[1])
		else if(left.fiveCards[2].compareTo(right.fiveCards[2]) !=0)
			return left.fiveCards[2].compareTo(right.fiveCards[2])
		else if(left.fiveCards[3].compareTo(right.fiveCards[3]) !=0)
			return left.fiveCards[3].compareTo(right.fiveCards[3])
		else if(left.fiveCards[4].compareTo(right.fiveCards[4]) !=0)
			return left.fiveCards[4].compareTo(right.fiveCards[4])
		return 0;
	}

}

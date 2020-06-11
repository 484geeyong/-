package sort

import java.util.ArrayList
import java.util.List

class MergeSort<T> implements ISorter<T> {

	ArrayList<T> list = null;

	public MergeSort(ArrayList<T> list) {
		this.list = list.clone();
	}

	@Override
	public List<T> getList() {
		return list;
	}

	@Override
	public List<T> sort() {

		mergeSort(list);

		return list;
	}
	public void mergeSort(ArrayList<T> list) {

		int n = list.size();
		if (n < 2)
			return;

		ArrayList<T> list1 = new ArrayList<T>();
		ArrayList<T> list2 = new ArrayList<T>();

		for (int i=0; i<list.size(); ++i) {
			if (i < n/2) {
				list1.add(list.get(i));
			}
			else {
				list2.add(list.get(i));
			}
		}

		list.clear();
		mergeSort(list1);
		mergeSort(list2);

		merge1(list1, list2, list);

	}
	public void merge (ArrayList<T> list1, ArrayList<T> list2, ArrayList<T> list) {
		int ind1 = 0;
		int ind2 = 0;
		while (ind1<list1.size() && ind2<list2.size()) {
			if (list1.get(ind1) < list2.get(ind2)) {
				list.add(list1.get(ind1));
				ind1++;
			}
			else {
				list.add(list2.get(ind2));
				ind2++;
			}
		}
		while (ind1<list1.size()) {
			list.add(list1.get(ind1));
			ind1++;
		}
		while (ind2<list2.size()) {
			list.add(list2.get(ind2));
			ind2++;
		}
	}
	public void merge1 (ArrayList<T> list1, ArrayList<T> list2, ArrayList<T> list) {
		final Card HIGH_VALUE = new Card(1, 15); // Highest value for toCompare()

		int ind1 = 0;
		int ind2 = 0;
		list1.add(HIGH_VALUE);
		list2.add(HIGH_VALUE);
		while (!(list1.get(ind1)==HIGH_VALUE && list2.get(ind2)==HIGH_VALUE)) {
			if (list1.get(ind1) < list2.get(ind2)) {
				list.add(list1.get(ind1));
				ind1++;
			}
			else {
				list.add(list2.get(ind2));
				ind2++;
			}
		}
	}

}

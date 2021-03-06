package sort

import java.util.ArrayList
import java.util.List

class QuickSort<T> implements ISorter<T> {

	ArrayList<T> list = null;

	public QuickSort(ArrayList<T> list) {
		this.list = list.clone();
	}
	
	@Override
	public List<T> getList() {
		return list;
	}

	@Override
	public List<T> sort() {

		quickSort(list);

		return list;
	}
	public void quickSort(ArrayList<T> list) {
		int n = list.size();
		if (n < 2)
			return;

		ArrayList<T> list1 = new ArrayList<T>();
		ArrayList<T> list2 = new ArrayList<T>();
		ArrayList<T> listEq = new ArrayList<T>();

		T pivot = list.get(0);

		while (!list.isEmpty()) {
			if (list.get(0).toString() < pivot.toString()) {
				list1.add(list.get(0));
			}
			else if (list.get(0).toString() == pivot.toString()) {
				listEq.add(list.get(0));
			}
			else {
				list2.add(list.get(0));
			}
			list.remove(0);
		}
		quickSort(list1);
		quickSort(list2);

		list.addAll(list1);
		list.addAll(listEq);
		list.addAll(list2);
	}
}

import java.lang.Comparable;

public class SortingAlgorithms {
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void bubblesort(Object[] data) {
		for (int i = 0; i < data.length-1; i++)
			for (int j = data.length-1; j > i; --j)
				if (((Comparable)data[j]).compareTo(data[j-1]) < 0)
					swap(data,j,j-1);
	}

	void swap(Object[] a, int e1, int e2) {
		Object tmp = a[e1]; a[e1] = a[e2]; a[e2] = tmp;
	}

	
	public class Queue {
		@SuppressWarnings("rawtypes")
		private java.util.LinkedList list = new java.util.LinkedList();
		public Queue() {
		}
		public void clear() {
			list.clear();
		}
		public boolean isEmpty() {
			return list.isEmpty();
		}
		public Object firstEl() {
			return list.getFirst();
		}
		public Object dequeue() {
			return list.removeFirst();
		}
		@SuppressWarnings("unchecked")
		public void enqueue(Object el) {
			list.addLast(el);
		}
		public String toString() {
			return list.toString();
		}
	}
	
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	void quicksort(Object[] data, int first, int last) {
		int lower = first + 1, upper = last;
		swap(data,first,(first+last)/2);
		Comparable bound = (Comparable)data[first];
		while (lower <= upper) {
			while (bound.compareTo(data[upper])< 0 )
				lower++;
			while (bound.compareTo(data[upper])> 0)
				upper--;
			if (lower < upper)
				swap(data,lower++,upper--);
			else lower++;
		}
		swap(data,upper,first);
		if (first < upper-1)
			quicksort(data,first,upper-1);
		if (upper+1 < last)
			quicksort(data,upper+1,last);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	void quicksort(Object[] data) {
		if (data.length < 2)
			return;
		int max = 0;
		// find the largest element and put it at the end of data;
		for (int i = 1; i < data.length; i++)
			if (((Comparable)data[max]).compareTo(data[i]) < 0)
				max = i;
		swap(data,data.length-1,max); // largest el is now in its
		quicksort(data,0,data.length-2); // final position;
	}


	void radixsort(int[] data) {
		int digits = 10;
		int radix = 10;
		int d, j, k, factor;
		Queue[] queues = new Queue[radix];
		for (d = 0; d < radix; d++)
			queues[d] = new Queue();
		for (d = 1, factor = 1; d <= digits; factor *= radix, d++) {
			for (j = 0; j < data.length; j++)
				queues[(data[j] / factor) % radix].enqueue( new Integer(data[j]));
			for (j = k = 0; j < radix; j++)
				while (!queues[j].isEmpty())
					data[k++] =
						((Integer) queues[j].dequeue()).intValue();
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void insertionsort(Object[] data) {
		for (int i = 1, j; i < data.length; i++) {
			Comparable tmp = (Comparable)data[i];
			for (j = i; j > 0 && tmp.compareTo(data[j-1]) < 0; j--)
				data[j] = data[j-1];
			data[j] = tmp;
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		

	}

}

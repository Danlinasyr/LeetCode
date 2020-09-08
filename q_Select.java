
Random r = new Random();
public int partition(int[] list, int left, int right, int pivot){
	pivotValue = list[pivot];

	swap(list, right, pivot);  // Move pivot to end
	int storeIndex = left;
	for(int i = left; i < right; i++){
		if(list[i] < pivotValue){
			swap(list, storeIndex, i);
			storeIndex++;
		}
	}
	swap(list, storeIndex, right); // Move pivot to its final place

	return storeIndex;
}

public void swap(int[] list, i, j){
	int[] temp = list[i];
	list[i] = list[j];
	list[j] = temp;
}


public int qSelect(int[] list, int left, int right, int k){
	if (left == right) { 		//If the list contains only one element,
		return list[left]		// return that element
	}

	int pivot = left + r.nextInt();
	pivot = partition (list, left, right, pivot);  //pivot is at its final sorted position

	if(k = pivot){
		return list[pivot];
	}else if (k < pivot){
		qSelect(list, left, pivot-1, k);  
	}else {
		qSelect(list, pivot+1, right, k); // still wonder why it is still k not k-pivot????
	}

}




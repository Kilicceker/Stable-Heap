package stableHeap;

import java.util.ArrayList;

public class StableHeap<Type extends Comparable<? super Type>> implements Heap<Type>{

	 private ArrayList<Type> heap;
	 
	 public StableHeap() {
		 
		heap =new ArrayList<Type>();
		 
	 }
	
	@Override
	public void insert(Type data) {
		if(heap.size()==0) { //is Empty
			
			heap.add(data); 
		}
			
		else { //is not empty
		insertionSort(data);
	}
		}
	
	private void insertionSort(Type data){  
	    for(int i=0; i<heap.size();i++){     
	        if(data.compareTo(heap.get(i))<0){ 
	            heap.add(i,data);
	            return;
	        }
	    }
	heap.add(data);
	
	}

	@Override
	public Type findMin() {
		
		return heap.get(0); //0. index = min data 
	}

	@Override
	public Type deleteMin() {
		if(heap.size()==0) { return null;}
		else {return heap.remove(0);  //0. index has min data
	}}

	@Override
	public boolean isEmpty() {
		
		return heap.size()==0;  //size == 0 heap is empty
	}

	@Override
	public void makeEmpty() {
		
	heap=new ArrayList<Type>();  //create new clear array
	}
}

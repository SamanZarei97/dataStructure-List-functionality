/**
 * Name: Saman Zarei
 * The purpose of this class is implementing MyList in Array form
 * To test later and make sure that we have implemented correctly.
 */
public class ArrayGL<E> implements MyList<E> {

	// The array Element
    E[] elements;
    //The size of the array
    int size;

    /**
     * This is a constructor this initialize the instance variable
     * @param initialElements
     */
    public ArrayGL(E[] initialElements) {
        this.elements = initialElements;
        this.size = initialElements.length;
    }
    
    /**
     * This is an Override method from MyList interface that 
     * Returns the contents of the list as a new array, 
     * with shallow copy of the elements in the same order they appear in the list. 
     */
    @Override
    @SuppressWarnings("unchecked")
    public E[] toArray() {
    	
    	//Creating new array which we suppose to return it
    	E[] newArray = (E[]) new Object[this.size];
    	
    	// This for loop is to copy each element of elements array in newArray
    	for(int i = 0; i < this.size; i++) {
    		
    		newArray[i] = this.elements[i];
    	}
    	
    	return newArray;
    }
    
    /**
     * This is an Override method from MyList interface that
     * returns true if there is no element in the list and false otherwise
     */
    @Override
    public boolean isEmpty() {
    	
    	if(this.size == 0) {
    		
    		return true;
    	}
    	
    	else {
    		
    		return false;
    	}
    }
    
    /**
     * This is an Override method from MyTransformer interface that
     * Changes the contents of the list according to the provided MyTransformer.
     * It takes an element as an argument and returns the transformed element
     * It does not transfer null element.
     */
    @Override
    @SuppressWarnings("unchecked")
    public void transformAll(MyTransformer mt) {
    	
    	/* This loop check each elements to transform there but it
    	 * does not transfer the null element.   
    	 */
    	for(int i = 0; i < this.size; i++) {
    		
    		if(this.elements[i] != null) {
    			
    			this.elements[i] = (E) mt.transformElement(elements[i]);
    		}
    	}
    }
    
    /**
     * This is an Override method from MyChooser interface that 
     * Changes the list to contain only elements selected by the MyChooser.
     * it takes an element as an argument and check if this element should be put 
     * into the new list. It return true, if we should choose this element and false otherwise
     * Also it skips all the null elements.
     */
    @Override
    @SuppressWarnings("unchecked")
    public void chooseAll(MyChooser mc) {
    	
    	// Determining the length of array we need to create it.
    	int newLength = 0;
    	//This variable is for checking the index of array we want to create it.
    	int index = 0;
    	
    	/*This for loop determine the elements we need to choose and increments
    	 * the newLength to determine what the length of array would be.
    	 */
    	for(int i = 0; i < this.size; i++) {
    		
    		if(this.elements[i] != null && mc.chooseElement(this.elements[i])) {
    			
    			newLength +=1; 
    		}
    	}
    	
    	// Creating new array to store the chosen elements in it.
    	E[] array = (E[]) new Object[newLength];  	
 	    
    	/*
    	 * This for loop determines the chosen elements of elements array based on
    	 * what we have mentioned in method description and it copies all the 
    	 * chosen elements in array we have just created it. also the index will increment
    	 * by one here to copy each chosen element in its specific index
    	 */
    	for(int i = 0; i < this.size; i++) {
    		
    		if(this.elements[i] != null && mc.chooseElement(this.elements[i])) {
    			
    			array[index] = this.elements[i];
    			index +=1;    		
    		}
    	}
    	
    	//Initializing the array elements
    	this.elements = array;
    	//initializing the size which is the length of array elements
    	this.size = array.length;
    }        
}
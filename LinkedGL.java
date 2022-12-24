/**
 * The purpose of this class is implementing MyList in Node form
 * To test later and make sure that we have implemented correctly.
 */
public class LinkedGL<E> implements MyList<E> {

    class Node {
        E value;
        Node next;

        public Node(E value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    Node front;
    int size;
    
    /**
     * This is a constructor that creates a new LinkedGL with its elements 
     * from contents in the same order. Also in initializes the instant variables.
     * @param contents
     */
    public LinkedGL(E[] contents) {
        
    	this.front = new Node(null,null);
    	Node helperNode = this.front;
    	this.size = contents.length;
    	
    	for(int i = 0; i < contents.length; i++) {
    		
    		helperNode.next = new Node(contents[i],null);
    		helperNode = helperNode.next;  		
    	}    	   	
    }
    
    /**
     * This is an Override method from MyList interface that 
     * Returns the contents of the list as a new array, 
     * with shallow copy of the elements in the same order they appear in the list. 
     */
    @Override
    @SuppressWarnings("unchecked")
    public E[] toArray() {
    	
    	Node helperNode = this.front;
    	E[] contentsArray = (E[]) new Object[this.size];
    	
    	/*
    	 * This for loop check to see if each nodes is null or not
    	 * if it is not null, it stores its value in thecontentsArray 
    	 */
    	for(int i = 0; i < contentsArray.length; i++) {
    		
    		if(helperNode.next != null) {
    			
    			contentsArray[i] = helperNode.next.value;
    			helperNode = helperNode.next;
    		}
    	}
    	
    	return contentsArray;
    }
    
    /**
     * This is an Override method from MyList interface that
     * returns true if there is no element in the list and false otherwise
     */
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
    	
    	Node helperNode = this.front;
    	
    	/*
    	 * this for loop check to see if the node value is not null
    	 * if it is not, it transfers it.
    	 */
    	for(int i = 0; i < this.size; i++) {
    		
     			
    		if(helperNode.next.value != null) {
    				
    			helperNode.next.value = (E) mt.transformElement(helperNode.next.value);
    			helperNode = helperNode.next;
    			}
    		
    		else {
    			
    			helperNode = helperNode.next;
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
    	
    	Node helperNode = this.front;
    	//The Size of array we suppose to create it.
    	int sizeOfArray = 0;
    	//The number of element added in array we suppose to create it.
    	int indexOfArray = 0;
    	
    	/*This for loop determine the elements we need to choose and increments
    	 * the sizeOfArray to determine what the length of array would be. Also, 
    	 * it considers all the condition I mentioned in the method description when 
    	 * it's incrementing the sizeOfArray
    	 */
    	for(int i = 0; i < this.size; i++) {
    		if(helperNode.next != null) {
    			
    			if(helperNode.next.value != null && mc.chooseElement(helperNode.next.value)) {
    				
    				sizeOfArray +=1;
    			}
    		}
    		
    		helperNode = helperNode.next;
    	}
    	
    	//initializing the helperNode again.
    	helperNode = this.front;
    	//creating the temporary array to transfer all the chosen variable in it
    	E[] myTempoArray = (E[]) new Object[sizeOfArray];
    	
    	/*
    	 * This for loop determines the chosen elements based on
    	 * what we have mentioned in method description and it copies all the 
    	 * chosen elements in array we have just created it. also the indexOfArray will increment
    	 * by one here to copy each chosen element in its specific index
    	 */
    	for (int i = 0; i < this.size; i++) {
    		
    		if(helperNode.next != null) {
    			
    			if(helperNode.next.value != null && mc.chooseElement(helperNode.next.value)) {
    				
    				myTempoArray[indexOfArray] = helperNode.next.value;
    				indexOfArray +=1;
    			}
    		}
    		
    		helperNode = helperNode.next;
    	}
    	
    	//Reseting the front to transfer all the element in Node
    	this.front = new Node(null,null);
    	//initializing the helperNode again.
    	helperNode = this.front;
    	
    	/*
    	 * This for loop add all the chosen variable that we have in myTempoArray
    	 * into the Node.
    	 */
    	for(int i = 0; i < myTempoArray.length; i++) {
    		
    		helperNode.next = new Node(myTempoArray[i], null);
    		helperNode = helperNode.next;
    	}
    	
    	//Initializing the size of the Node.
    	this.size = myTempoArray.length;
    }    
}

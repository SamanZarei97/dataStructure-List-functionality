/**
 * Name: Saman Zarei
 */
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection; 
import java.util.NoSuchElementException;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 * The purpose of this class is to write some test cases to make sure we have 
 * implemented all the classes correctly.
 * @author saman
 *
 */
@RunWith(Parameterized.class)
public class TestLists {

	public static Collection<Object[]> LISTNUMS =
			Arrays.asList(new Object[][] { {"Linked"}, {"Array"} });
	private String listType;

	public TestLists(String listType) {
		super();
		this.listType = listType;
	}

	@Parameterized.Parameters(name = "{0}List")
	public static Collection<Object[]> bags() {
		return LISTNUMS;
	}

	private <E> MyList<E> makeList(E[] contents) {
		switch (this.listType) {
		case "Linked":
			return new LinkedGL<E>(contents);
		case "Array":
			return new ArrayGL<E>(contents);
		}
		return null;
	}

  // Don't change code above this line, it ensures the autograder works as
  // expected


  // This is a sample test; you can keep it, change it, or remove it as you like.
  // Note that it uses the method `assertArrayEquals`, which you should use to
  // test equality of arrays in this PA.
	@Test
	public void testSimpleToArray() {
		// Using the generic list to create an Integer list
		Integer[] int_input = {1, 2, 3};
		MyList<Integer> int_s = makeList(int_input);
		assertArrayEquals(int_input, int_s.toArray());
		
		// Using the generic list to create a String list
		String[] string_input = {"a", "b", "c"};
		MyList<String> string_s = makeList(string_input);
		assertArrayEquals(string_input, string_s.toArray());
	}
	
	/**
	 * This method test constructor with empty array
	 */
	@Test
	public void testConstructorWithEpmtyArray() {
		
		Integer[] myIntegerInput = {};
		MyList<Integer> integerInput = makeList(myIntegerInput);
		assertArrayEquals(myIntegerInput, integerInput.toArray());
		
		String[] myStringInput ={};
		MyList<String> stringInput = makeList(myStringInput);
		assertArrayEquals(myStringInput, stringInput.toArray());
	}
	
	/**
	 * This method test constructor by array with multiple elements
	 */
	@Test
	public void testConstructorWithMultipleArray() {
		
		Integer[] myIntegerInput = {1,2};
		MyList<Integer> integerInput = makeList(myIntegerInput);
		assertArrayEquals(myIntegerInput, integerInput.toArray());
		
		String[] myStringInput = {"Perspolise", "Shiraz"};
		MyList<String> stringInput = makeList(myStringInput);
		assertArrayEquals(myStringInput, stringInput.toArray());
	}
	
	/**
	 * This method test the correctness of isEmpty method
	 */
	@Test
	public void testIsEmptyWithoutElement() {
		
		Integer[] myIntegerInput = {};
		MyList<Integer> integerInput = makeList(myIntegerInput);
		assertEquals(true, integerInput.isEmpty());
		
		String[] myStringInput = {};
		MyList<String> stringInput = makeList(myStringInput);
		assertEquals(true, stringInput.isEmpty());
	}
	
	/**
	 * This method test the correctness of isEmpty method
	 */
	@Test
	public void testIsEmptyWitOneElement() {
		
		Integer[] myIntegerInput = {1};
		MyList<Integer> integerInput = makeList(myIntegerInput);
		assertEquals(false, integerInput.isEmpty());
		
		String[] myStringInput = {"S"};
		MyList<String> stringInput = makeList(myStringInput);
		assertEquals(false, stringInput.isEmpty());
	}
	
	/**
	 * This method test the correctness of isEmpty method
	 */
	@Test
	public void testIsEmptyWitTwoElement() {
		
		Integer[] myIntegerInput = {1,2};
		MyList<Integer> integerInput = makeList(myIntegerInput);
		assertEquals(false, integerInput.isEmpty());
		
		String[] myStringInput = {"S","Z"};
		MyList<String> stringInput = makeList(myStringInput);
		assertEquals(false, stringInput.isEmpty());
	}
	
	/**
	 * This method tests the when we have large size of array
	 */
	@Test
	public void testLargeSizeForToArray() {
		
		Integer [] myIntegerInput = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23};
		MyList<Integer> integerInput = makeList(myIntegerInput);
		assertArrayEquals(myIntegerInput, integerInput.toArray());
		
		String[] myStringInput = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o"};
		MyList<String> stringInput = makeList(myStringInput);
		assertArrayEquals(myStringInput, stringInput.toArray());
	}
	
	/**
	 * This method tests the correctness of transformAll method by having 
	 * empty list
	 */
	@Test
	public void testForEmptyTransform() {
		
		Integer[] myIntegerInput = {};
		Integer[] myIntegerOutput = {};
		MyList<Integer> integerInput = makeList(myIntegerInput);
		integerInput.transformAll(new UpperCaseTransformer());
		assertArrayEquals(myIntegerOutput,integerInput.toArray());
		
		String[] myStringInput = {};
		String[] myStringOutput = {};
		MyList<String> stringInput = makeList(myStringInput);
		stringInput.transformAll(new UpperCaseTransformer());
		assertArrayEquals(myStringOutput, stringInput.toArray());
	}
	
	/**
	 * This method test the correctness of isEmpty method by having null
	 * as element
	 */
	@Test
	public void isEmptyWithnull() {
		Integer[] myIntegerInput = {null};
		MyList<Integer> integerInput = makeList(myIntegerInput);
		assertEquals(false,integerInput.isEmpty());
		
		String[] myStringInput = {null};
		MyList<String> StringInput = makeList(myStringInput);
		assertEquals(false,StringInput.isEmpty());
	}
	
	/**
	 * This method tests the correctness of transformAll method by transferring 
	 * to upperCase
	 */
	@Test
	public void testTransformForUpperCase() {
		
		String [] myStringInput = {"dog", "pars", "persian", "redbull"};
		String [] myStringOutput = {"DOG", "PARS", "PERSIAN", "REDBULL"};
		MyList<String> stringInput = makeList(myStringInput);
		stringInput.transformAll(new UpperCaseTransformer());
		assertArrayEquals(myStringOutput, stringInput.toArray());
	}
	
	/**
	 * This method tests the correctness of transformAll method by transferring 
	 * to upperCase and having null
	 */
	@Test
	public void testTransformForUpperCaseWithNull() {
		
		String [] myStringInput = {"dog", null, "pars", null, "persian"};
		String [] myStringOutput = {"DOG",null,"PARS", null, "PERSIAN"};
		MyList<String> stringInput = makeList(myStringInput);
		stringInput.transformAll(new UpperCaseTransformer());
		assertArrayEquals(myStringOutput, stringInput.toArray());
	}
	
	/**
	 * This method tests the correctness of transformAll method by transferring 
	 * to upperCase and having null when we have a large size of elements
	 */
	@Test
	public void testTransformLargeSizeUpperCase() {
		
		String [] myStringInput = {"a","b",null,"c","d","e","f","g","h","i","j","k","l","m","n"};
		String [] myStringOutput = {"A","B",null,"C","D","E","F","G","H","I","J","K","L","M","N"};
		MyList<String> stringInput = makeList(myStringInput);
		stringInput.transformAll(new UpperCaseTransformer());
		assertArrayEquals(myStringOutput, stringInput.toArray());
	}
	
	/**
	 * This method tests the correctness of transformAll method by transferring 
	 * to double amount
	 */
	@Test
	public void testTransformForDoubleNumber() {
		
		Integer [] myIntegerInput = {1 , 2, 3, 4};
		Integer [] myIntegerOutput = {2 , 4, 6, 8};
		MyList<Integer> integerInput = makeList(myIntegerInput);
		integerInput.transformAll(new DoubleNumber());
		assertArrayEquals(myIntegerOutput, integerInput.toArray());
	}
	
	/**
	 * This method tests the correctness of transformAll method by transferring 
	 * to double amount and having null value
	 */
	@Test
	public void testTransformForDoubleNumberWithNull() {
		
		Integer [] myIntegerInput = {1, null, 2, null, 3, 4};
		Integer [] myIntegerOutput = {2, null, 4, null, 6, 8};
		MyList<Integer> integerInput = makeList(myIntegerInput);
		integerInput.transformAll(new DoubleNumber());
		assertArrayEquals(myIntegerOutput, integerInput.toArray());
	}
	
	/**
	 * This method tests the correctness of transformAll method by transferring 
	 * to show the character at the first index
	 */
	@Test
	public void testTransformForLetterAtFirstIndex() {
		
		String [] myStringInput = {"Santos", "perspolise", "cse12"};
		String [] myStringOutput = {"S", "p", "c"};
		MyList<String> stringInput = makeList(myStringInput);
		stringInput.transformAll(new showLetterAtFirstIndex());
		assertArrayEquals(myStringOutput, stringInput.toArray());
	}
	
	/**
	 * This method tests the correctness of transformAll method by transferring 
	 * to show the character at the first index and having null
	 */
	@Test
	public void testTransformForLetterAtFirstIndexWithNull() {
		
		String [] myStringInput = {"Santos", null, "perspolise", null, "cse12"};
		String [] myStringOutput = {"S", null, "p", null, "c"};
		MyList<String> stringInput = makeList(myStringInput);
		stringInput.transformAll(new showLetterAtFirstIndex());
		assertArrayEquals(myStringOutput, stringInput.toArray());
	}
	
	/**
	 * This method tests the correctness of chooseAll method by having empty list 
	 */
	@Test
	public void testChooseAllChooseLongWordChooserEmpty() {
		
		String [] myStringInput = {};
		String [] myStringOutput = {};
		MyList<String> stringInput = makeList(myStringInput);
		stringInput.chooseAll(new LongWordChooser());
		assertArrayEquals(myStringOutput, stringInput.toArray());
	}
	
	/**
	 * This method tests the correctness of chooseAll method by having empty list 
	 */
	@Test
	public void testChooseAllChooseLongWordChooserEmpty2() {
		
		String [] myStringInput = {};
		String [] myStringOutput = {};
		MyList<String> stringInput = makeList(myStringInput);
		stringInput.chooseAll(new LongWordChooser());
		assertEquals(true, stringInput.isEmpty());
	}
	
	/**
	 * This method tests the correctness of chooseAll method when 
	 * out array is not empty 
	 */
	@Test
	public void testChooseAllChooseLongWordChooserEmpty3() {
		
		String [] myStringInput = {"SanDiego", "LosAngeles", "Shi", "Pert"};
		String [] myStringOutput = {"SanDiego", "LosAngeles"};
		MyList<String> stringInput = makeList(myStringInput);
		stringInput.chooseAll(new LongWordChooser());
		assertEquals(false, stringInput.isEmpty());
	}
	
	/**
	 * This method tests the correctness of chooseAll method by having some
	 * elements length of less than 6
	 */
	@Test
	public void testChooseAllChooseLongWordChooserEmpty4() {
		
		String [] myStringInput = {"S", "L", "S", "P"};
		String [] myStringOutput = {};
		MyList<String> stringInput = makeList(myStringInput);
		stringInput.chooseAll(new LongWordChooser());
		assertArrayEquals(myStringOutput, stringInput.toArray());
	}
	
	/**
	 * This method tests the correctness of chooseAll method by having some
	 * elements length of less than 6
	 */
	@Test
	public void testChooseAllChooseLongWordChooserEmpty5() {
		
		String [] myStringInput = {"S", "L", "S", "P"};
		String [] myStringOutput = {};
		MyList<String> stringInput = makeList(myStringInput);
		stringInput.chooseAll(new LongWordChooser());
		assertEquals(true, stringInput.isEmpty());
	}
	
	/**
	 * This method tests the correctness of chooseAll method by choosing
	 * all elements.
	 */
	@Test
	public void testChooseAllChooseLongWordChooserChooseAllElement() {
		
		String [] myStringInput = {"Santos", "padideh", "AppIII", "banBang"};
		String [] myStringOutput = {"Santos", "padideh", "AppIII", "banBang"};
		MyList<String> stringInput = makeList(myStringInput);
		stringInput.chooseAll(new LongWordChooser());
		assertArrayEquals(myStringOutput, stringInput.toArray());
	}
	
	/**
	 * This method tests the correctness of chooseAll method by choosing
	 * the second element 
	 */
	@Test
	public void testChooseAllChooseLongWordChooserChooseTwoElement() {
		
		String [] myStringInput = {"Sa", "padideh"};
		String [] myStringOutput = {"padideh"};
		MyList<String> stringInput = makeList(myStringInput);
		stringInput.chooseAll(new LongWordChooser());
		assertArrayEquals(myStringOutput, stringInput.toArray());
	}
    
	/**
	 * This method tests the correctness of chooseAll method by choosing
	 * first and last element 
	 */
	@Test
	public void testChooseAllChooseLongWordChooserFirstLastElement() {
		
		String [] myStringInput = {"Santos", "pa", "App", "banBang"};
		String [] myStringOutput = {"Santos", "banBang"};
		MyList<String> stringInput = makeList(myStringInput);
		stringInput.chooseAll(new LongWordChooser());
		assertArrayEquals(myStringOutput, stringInput.toArray());
	}
	
	/**
	 * This method tests the correctness of chooseAll method by when
	 * we have null
	 */
	@Test
	public void testChooseAllChooseLongWordChooserWithNull() {
		
		String [] myStringInput = {"Santos", null, "pa", "App", null, "banBang"};
		String [] myStringOutput = {"Santos", "banBang"};
		MyList<String> stringInput = makeList(myStringInput);
		stringInput.chooseAll(new LongWordChooser());
		assertArrayEquals(myStringOutput, stringInput.toArray());
	}
	
	/**
	 * This method tests the correctness of chooseAll method by when
	 * we have null
	 */
	@Test
	public void testChooseAllChooseLongWordChooserWithNull2() {
		
		String [] myStringInput = {"San", null, "pa", "App", null, "bang"};
		String [] myStringOutput = {};
		MyList<String> stringInput = makeList(myStringInput);
		stringInput.chooseAll(new LongWordChooser());
		assertArrayEquals(myStringOutput, stringInput.toArray());
	}
	
	/**
	 * This method tests the correctness of chooseAll method by when
	 * we have null
	 */
	@Test
	public void testChooseAllChooseLongWordChooserWithNull3() {
		
		String [] myStringInput = {"San", null, "pa", "App", null, "bang"};
		String [] myStringOutput = {};
		MyList<String> stringInput = makeList(myStringInput);
		stringInput.chooseAll(new LongWordChooser());
		assertEquals(true, stringInput.isEmpty());
	}
	
	/**
	 * This method tests the correctness of chooseAll method by when
	 * we have null
	 */
	@Test
	public void testChooseAllChooseLongWordChooserWithNull4() {
		
		String [] myStringInput = {"SanTos", null, "pa", "App", null, "bang"};
		String [] myStringOutput = {"SanTos"};
		MyList<String> stringInput = makeList(myStringInput);
		stringInput.chooseAll(new LongWordChooser());
		assertEquals(false, stringInput.isEmpty());
	}
	
	/**
	 * This method tests the correctness of chooseAll method by when
	 * we M as first letter
	 */
	@Test
	public void testChooseAllChoosefirstLetterIsM() {
		
		String [] myStringInput = {"Mosi", "Monisa", "Santos", "Moro"};
		String [] myStringOutput = {"Mosi", "Monisa","Moro"};
		MyList<String> stringInput = makeList(myStringInput);
		stringInput.chooseAll(new firstLetterIsM());
		assertArrayEquals(myStringOutput, stringInput.toArray());
		
	}
	
	/**
	 * This method tests the correctness of chooseAll method by when
	 * we M as first letter and null
	 */
	@Test
	public void testChooseAllChoosefirstLetterIsMWithNull() {
		
		String [] myStringInput = {"Mosi", null, "Monisa", null, "Moro"};
		String [] myStringOutput = {"Mosi", "Monisa","Moro"};
		MyList<String> stringInput = makeList(myStringInput);
		stringInput.chooseAll(new firstLetterIsM());
		assertArrayEquals(myStringOutput, stringInput.toArray());
		
	}
	
	/**
	 * This method tests the correctness of chooseAll method by when
	 * we M as first letter and array is empty
	 */
	@Test
	public void testChooseAllChoosefirstLetterIsMepmtyList() {
		
		String [] myStringInput = {};
		String [] myStringOutput = {};
		MyList<String> stringInput = makeList(myStringInput);
		stringInput.chooseAll(new firstLetterIsM());
		assertArrayEquals(myStringOutput, stringInput.toArray());
		
	}
	
	/**
	 * This method tests the correctness of chooseAll method by when
	 * we M as first letter and array is empty
	 */
	@Test
	public void testChooseAllChoosefirstLetterIsMepmtyList2() {
		
		String [] myStringInput = {};
		String [] myStringOutput = {};
		MyList<String> stringInput = makeList(myStringInput);
		stringInput.chooseAll(new firstLetterIsM());
		assertEquals(true, stringInput.isEmpty());
		
	}
	
	/**
	 * This method tests the correctness of chooseAll method by when
	 * we M as first letter
	 */
	@Test
	public void testChooseAllChoosefirstLetterIsMepmtyList3() {
		
		String [] myStringInput = {"Farab", "Santos"};
		String [] myStringOutput = {};
		MyList<String> stringInput = makeList(myStringInput);
		stringInput.chooseAll(new firstLetterIsM());
		assertEquals(true, stringInput.isEmpty());
		
	}
	
	/**
	 * This method tests the correctness of chooseAll method by when
	 * we M as first letter and we have empty list
	 */
	@Test
	public void testChooseAllChoosefirstLetterIsMepmtyList4() {
		
		String [] myStringInput = {"Farab", "Santos"};
		String [] myStringOutput = {};
		MyList<String> stringInput = makeList(myStringInput);
		stringInput.chooseAll(new firstLetterIsM());
		assertArrayEquals(myStringOutput, stringInput.toArray());
		
	}
	
	/**
	 * This method tests the correctness of chooseAll method by when
	 * we M as first letter and we have null
	 */
	@Test
	public void testChooseAllChoosefirstLetterIsMepmtyList5() {
		
		String [] myStringInput = {"Farab", "Santos", null , null};
		String [] myStringOutput = {};
		MyList<String> stringInput = makeList(myStringInput);
		stringInput.chooseAll(new firstLetterIsM());
		assertArrayEquals(myStringOutput, stringInput.toArray());
		
	}
	
	/**
	 * This method tests the correctness of chooseAll method by when
	 * we M as first letter and we have null
	 */
	@Test
	public void testChooseAllChoosefirstLetterIsMepmtyList6() {
		
		String [] myStringInput = {"Farab", "Santos", null, null};
		String [] myStringOutput = {};
		MyList<String> stringInput = makeList(myStringInput);
		stringInput.chooseAll(new firstLetterIsM());
		assertEquals(true, stringInput.isEmpty());		
	}
	
	/**
	 * This method tests the correctness of chooseAll method by when
	 * we 12 as certain number
	 */
	@Test
	public void testChooseAllChoosemyCertainNumber() {
		
		Integer [] myIntegerInput = {12,2,5,1,12,14,12,12};
		Integer [] myIntegerOutput = {12,12,12,12};
		MyList<Integer> integerInput = makeList(myIntegerInput);
		integerInput.chooseAll(new myCertainNumber());
		assertArrayEquals(myIntegerOutput, integerInput.toArray());
	}
	
	/**
	 * This method tests the correctness of chooseAll method by when
	 * we 12 as certain number
	 */
	@Test
	public void testChooseAllChoosemyCertainNumber2() {
		
		Integer [] myIntegerInput = {2,5,1,14};
		Integer [] myIntegerOutput = {};
		MyList<Integer> integerInput = makeList(myIntegerInput);
		integerInput.chooseAll(new myCertainNumber());
		assertArrayEquals(myIntegerOutput, integerInput.toArray());
	}
	
	/**
	 * This method tests the correctness of chooseAll method by when
	 * we 12 as certain number and also we have null
	 */
	@Test
	public void testChooseAllChoosemyCertainNumber3() {
		
		Integer [] myIntegerInput = {12,2,5,null,1,12,null,14,12,12};
		Integer [] myIntegerOutput = {12,12,12,12};
		MyList<Integer> integerInput = makeList(myIntegerInput);
		integerInput.chooseAll(new myCertainNumber());
		assertArrayEquals(myIntegerOutput, integerInput.toArray());
	}
	
	/**
	 * This method tests the correctness of chooseAll method by when
	 * we 12 as certain number and also we have null
	 */
	@Test
	public void testChooseAllChoosemyCertainNumber4() {
		
		Integer [] myIntegerInput = {12,2,5,null,1,12,null,14,12,12};
		Integer [] myIntegerOutput = {12,12,12,12};
		MyList<Integer> integerInput = makeList(myIntegerInput);
		integerInput.chooseAll(new myCertainNumber());
		assertEquals(false, integerInput.isEmpty());
	}
	/**
	 * This method tests the correctness of chooseAll method by when
	 * we 12 as certain number and also we have null
	 */
	@Test
	public void testChooseAllChoosemyCertainNumber5() {
		
		Integer [] myIntegerInput = {2,5,null,1,null,14};
		Integer [] myIntegerOutput = {};
		MyList<Integer> integerInput = makeList(myIntegerInput);
		integerInput.chooseAll(new myCertainNumber());
		assertEquals(true, integerInput.isEmpty());
	}
	
	/**
	 * This method tests the correctness of chooseAll method by when
	 * we have emptyList
	 */
	@Test
	public void testChooseAllChoosemyCertainNumber6() {
		
		Integer [] myIntegerInput = {};
		Integer [] myIntegerOutput = {};
		MyList<Integer> integerInput = makeList(myIntegerInput);
		integerInput.chooseAll(new myCertainNumber());
		assertEquals(true, integerInput.isEmpty());
	}
	/**
	 * This method tests the correctness of chooseAll method by when
	 * we have null
	 */
	@Test
	public void testChooseAllChoosemyCertainNumber7() {
		
		Integer [] myIntegerInput = {null,null};
		Integer [] myIntegerOutput = {};
		MyList<Integer> integerInput = makeList(myIntegerInput);
		integerInput.chooseAll(new myCertainNumber());
		assertEquals(true, integerInput.isEmpty());
	}
}
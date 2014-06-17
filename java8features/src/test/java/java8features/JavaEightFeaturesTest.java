package java8features;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

import com.sun.xml.internal.fastinfoset.algorithm.IEEE754FloatingPointEncodingAlgorithm;

public class JavaEightFeaturesTest {

	//Read entire file at a time using Stream's line()
	@Test
	public void test_StreamingFiles_lines() throws FileNotFoundException{
	    URL url = Main.class.getClassLoader().getResource("ram.txt");
		File file = new File(url.getPath());
		PrintStream out = System.out;
//		out.println(".....:"+file.getAbsolutePath());
		FileReader reader = new FileReader(file);
		try (BufferedReader bufferedReader = new BufferedReader(reader);){
			Stream<String> lines = bufferedReader.lines();
			lines.forEach(out::println);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Test
	public void testForEachWithNoParallelProcessing() throws InterruptedException{
		long currentTimeMillis = System.currentTimeMillis();
		List<String> list = getListOfStrings();
		for (String integer : list) {
			Thread.sleep(100);
			System.out.println(integer);
		}
		long timeSpan = System.currentTimeMillis()-currentTimeMillis;
		System.out.println("TimeSpan:"+timeSpan);
	}

	//Parallel Processing
	@Test
	public void testForEeachWithParallelProcessing(){
		Stream<String> stream = getListOfStrings().parallelStream();
		long currentTimeMillis = System.currentTimeMillis();
		System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "20");
		
		//Parallel without Lambda expression
		stream.forEach(new Consumer<String>() {
			@Override
			public void accept(String t) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(t);
			}
		});
		
//		Parallel with Lambda expression			
/*		stream.parallel().forEach((String inte) -> {
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println(inte);});
*/		
		System.out.println("TimeSpan:"+(System.currentTimeMillis()-currentTimeMillis));
	}
	

/**
 * Intermediate operations: 
 * Intermediate operations return the stream itself so you can chain multiple method calls in a row.
 */
	
//	Filter() : Accepts a predicate to filter elements of the stream.
	@Test
	public void testFilter(){
		
		getTech().stream().filter((s) -> s.startsWith("J"))
        .forEach(System.out::println);

		//Without Lambda
/*		getTech().stream().filter(new Predicate<String>() {
			@Override
			public boolean test(String t) {
				return t.startsWith("J");
			}
		}).forEach(System.out::println);
*/	}
	
//	Map() : converts each element into another object via the given function in the stream. 
	@Test
	public void testMap(){
/*		getTech().stream().filter((s) -> s.startsWith("J"))
        .map(String::toUpperCase)
        .forEach(System.out::println);
*/		
		getTech().stream().filter((s) -> s.startsWith("J"))
        .map(new Function<String, String>() {
			@Override
			public String apply(String t) {
				return t.toUpperCase();
			}
		}).forEach(System.out::println);
	}
	
//	Sorted() :  Returns a sorted view of the stream default 
	@Test
	public void testSorted(){
		getTech().stream().sorted()
        .forEach(System.out::println);
	}
	
	
/**	
 * Terminal operations: 
 * Terminal operations return a result of a certain type instead of again a Stream.
 */
	
//	forEach() : Iterate through elements in the stream perform some operation
	@Test
	public void testForEach(){
		getTech().stream()
        .forEach(System.out::println);
	}

//	collect() : Gets the elements from the stream and store them into another Collection
	@Test
	public void testCollect(){
		List<String> memNamesInUppercase = getTech().stream()
				.sorted()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
		System.out.print(memNamesInUppercase);
	}
	
//	match() : Various matching operations can be used to check whether a certain predicate matches the stream.
	@Test
	public void testMatch() {
		boolean matchedResult = getTech().stream().anyMatch(
				(s) -> s.startsWith("J"));
		System.out.println(matchedResult);

		matchedResult = getTech().stream().allMatch((s) -> s.startsWith("A"));
		System.out.println(matchedResult);

		matchedResult = getTech().stream()
				.noneMatch((s) -> s.startsWith("A"));
		System.out.println(matchedResult);
	}
	
//	count() : Count is a terminal operation returning the number of elements in the stream as a long.
	@Test
	public void testCount() {
		long totalMatched = getTech().stream()
                .filter((s) -> s.startsWith("A"))
                .count();
		System.out.println(totalMatched);
	}
	
//	reduce() : This terminal operation performs a reduction on the elements of the stream with the given function. 
//			   The result is an Optional holding the reduced value.
	@Test
	public void testReduce() {
		Optional<String> reduced = getTech().stream()
				.reduce((s1,s2) -> s1 + "#" + s2);
		reduced.ifPresent(System.out::println);
	}
	
	
/**
 * 	Short-circuit operations :
 *  Breaks the operation whenever a matching element is encountered during iteration.
 */
	
//	anyMatch(): This will return true once a condition passed as predicate satisfy. 
//				It will not process any more elements.
	@Test
	public void testAnyMatch() {
		boolean matched = getTech().stream()
                .anyMatch((s) -> s.startsWith("S"));
		System.out.println(matched);
	}
	
//	findFirst() : It will return first element from stream and then will not process any more element.
	@Test
	public void testFindFirst() {
		String firstMatchedName = getTech().stream()
				.filter((s) -> s.startsWith("S"))
				.findFirst().get();
		System.out.println(firstMatchedName);
	}


	
	private List<String> getTech() {
		return Arrays.asList("java","Servlet","Jsp","Struts","Spring","JPA","Hibernate","Toplink");
	}
	
	public List<String> getListOfStrings(){
		List<String> list = new ArrayList<>();
		for(int i=0;i<100;i++){
			list.add("name"+i);
		}
		return list;
	}
	
	@Test
	public void testHighest() throws InterruptedException{
		
	/*	TreeMap<TestTreeSet, String> treeMap = new TreeMap<>();
		treeMap.put(new TestTreeSet(7,"test1"), "one");
		treeMap.put(new TestTreeSet(7,"test"), "two");
		treeMap.put(new TestTreeSet(3,"test3"), "three");
		
		
		System.out.println(treeMap);
		Set<TestTreeSet> keySet = treeMap.keySet();
		for (TestTreeSet testTreeSet : keySet) {
			System.out.println(testTreeSet.getNumber()+":"+treeMap.get(testTreeSet));
		}*/
		
/*		Map<TestTreeSet, String> linkedHashSet = new LinkedHashMap<>();
		linkedHashSet.put(new TestTreeSet(7,"test"), "one");
		linkedHashSet.put(new TestTreeSet(7,"test"), "one");
		linkedHashSet.put(new TestTreeSet(3,"test"), "one");
		
		System.out.println(linkedHashSet);
		HashSet<Object> hashSet = new HashSet<>();
		hashSet.add(null);
		boolean add = hashSet.add(2);
		System.out.println(add);
*/		/*
		TreeSet<TestTreeSet> treeSet = new TreeSet<>();
		treeSet.add(new TestTreeSet(9));
		treeSet.add(new TestTreeSet(1));
		treeSet.add(new TestTreeSet(0));
		
		for (TestTreeSet testTreeSet : treeSet) {
			
			System.out.println(testTreeSet.getNumber());
		}*/
		
	/*	int a[] = {9,83,81,67};
		int firstHigh = 0;
		int secondhigh = 0;
		for(int i=0;i<a.length;i++){
			firstHigh = a[i]>firstHigh?a[i]:firstHigh;
		}

		for(int i=0;i<a.length;i++){
			secondhigh = a[i]>secondhigh && a[i]<firstHigh?a[i]:secondhigh;
		}

		System.out.println(firstHigh+":"+secondhigh);
		*/
		
		List<String> asList = Arrays.asList("madammadam","madammadammadam","neen");
		
		String largestPalandrum="";
		
		for (String string : asList) {
			char[] charArray = string.toCharArray();
			
			StringBuffer afterConversion=new StringBuffer();
			for (int i = charArray.length-1; i >= 0; i--) {
				afterConversion.append(charArray[i]);
			}
			boolean equalsIgnoreCase = string.equalsIgnoreCase(afterConversion.toString());
			if(equalsIgnoreCase){
				largestPalandrum=(largestPalandrum.length()<afterConversion.toString().length())?afterConversion.toString():largestPalandrum;
			}
		}
		System.out.println("Largest palandrum:"+largestPalandrum);
	
/*		ArrayList<Object> arrayList = new ArrayList<>(1);
		arrayList.add("dsfsd");
		arrayList.add("sddsfsd");
//		System.out.println(arrayList);
		
		Vector<Object> vector = new Vector<>();
		Enumeration<Object> elements = vector.elements();
		
		
	List<String> linkedList = new LinkedList<>();
	linkedList.add(0, "1");
	linkedList.add(1, "2");
	linkedList.add(2, "3");
	
	ListIterator<String> iterator = linkedList.listIterator();
	iterator.next();
	iterator.remove();
	while(iterator.hasNext()){
		System.out.println(iterator.next());
	}
*/	
	
//	System.out.println(linkedList);
		Thread thread = new Thread();
	}
		
	
}

package java8features;

public class TestTreeSet implements Comparable<TestTreeSet> {

	private String field1;
	private String field2;

	public TestTreeSet(String number, String name) {
		this.field1 = number;
		this.field2 = name;
	}

	@Override
	public int compareTo(TestTreeSet o) {
		int compareTo = field1.compareTo(o.getNumber());
		if(compareTo==0){
			return field2.compareTo(o.getName());
		}
		return compareTo;
	}

	public String getNumber() {
		return field1;
	}

	public String getName() {
		return field2;
	}
	
	
}

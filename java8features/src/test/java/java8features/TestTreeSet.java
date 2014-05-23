package java8features;

public class TestTreeSet implements Comparable<TestTreeSet> {

	private Integer number;

	public TestTreeSet(Integer number) {
		this.number = number;
	}

	@Override
	public int compareTo(TestTreeSet o) {
		return number.compareTo(o.getNumber());
	}

	public Integer getNumber() {
		return number;
	}
	
	
	
}

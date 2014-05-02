package foo;

public enum EnumTest {

	APPLIED_ON("sdfsfd"), NOT_APPLIED_ON("sfdfsd");
	
	private String testNmae;
	
	private EnumTest(String testNmae) {
		this.testNmae = testNmae;
	}
}

package foo;

public class TestConcrete implements TestInterface {

	public String displayMe(String test)  {

		System.out.println(test);
		throw new RuntimeException("exp thrown in concrete");
		//return "returned by concrete";
	}


}

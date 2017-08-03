package dudu.jingjing;

import java.util.Collection;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

@RunWith(Parameterized.class)
public class DataUser {

	private String name;
	private String password;

	public DataUser(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}

	@Parameters
	public static Collection<String[]> readData() {
		return DataPare.getFile(System.getProperty("user.dir") + "/datadoc/datain.cvs");
	}

	@Test
	public void outData() {
		System.out.println(name + "----:" + password);
	}

	@BeforeMethod
	public void beforeMethod() {
	}

	@AfterMethod
	public void afterMethod() {
	}

	@BeforeClass
	public void beforeClass() {
	}

	@AfterClass
	public void afterClass() {
	}

	@BeforeTest
	public void beforeTest() {
	}

	@AfterTest
	public void afterTest() {
	}

}

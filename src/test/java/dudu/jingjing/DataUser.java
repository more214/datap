package dudu.jingjing;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.Collection;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

public class DataUser {

	private String name;
	private String password;

	public DataUser(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}

	@DataProvider(name="searchData") 
	public static Collection<String[]> readData() {
		return DataPare.getFile("C:\\Users\\jackie\\workspace\\jingjing\\datadoc\\datain.csv");
	}

	@Test(dataProvider="searchData")  
	public void outData() {
		System.out.println(name + "----:" + password);
	}
	@Test
	public void f()
	{
		
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

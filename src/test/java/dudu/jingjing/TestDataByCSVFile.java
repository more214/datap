package dudu.jingjing;

//从CSV文件中读取每行中前2个逗号分割的中文词作为搜索框中输入的搜索关键词
//断言搜索结果页面是否包含CSV文件中每行的最后一个词汇的关键字
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestDataByCSVFile {
	private static WebDriver driver;
	@DataProvider(name="searchData")
	public static Object[][] data() throws IOException
	{
		return GetData.getSearchData("C:\\Users\\jackie\\workspace\\jingjing\\datadoc\\datain.csv");//获取CSV文件的测试数据
	}
  @Test(dataProvider="searchData")
  public void testSearch(String searchdata1,String searchdata2,String searchResult) {
	  //打开sogou首页
	  driver.get("http://www.sogou.com/");
	  //输入搜索条件
	  //从CSV文件中读取每行中前2个逗号分割的中文词作为搜索框中输入的搜索关键词,在两个搜索词中间增加一个空格
	  driver.findElement(By.id("query")).sendKeys(searchdata1+" "+searchdata2);
	  //单击搜索按钮
	  driver.findElement(By.id("stb")).click();
	  
	  //使用显式等待方式，确认页面已经加载完成，页面底部的关键字"搜索帮助"已经显示在页面上
	  (new WebDriverWait(driver,3)).until(new ExpectedCondition<Boolean>(){

		public Boolean apply(WebDriver driver) {
			return driver.findElement(By.id("sogou_webhelp")).getText().contains("搜索帮助");
		}});

	  //断言搜索结果页面是否包含CSV文件中每行的最后一个词汇的关键字
	  Assert.assertTrue(driver.getPageSource().contains(searchResult));
  }
  @BeforeMethod
  public void beforeMethod() {
	  //若无法打开Firefox浏览器，可设定Firefox浏览器的安装路径
	  //System.setProperty("webdriver.firefox.bin", "D:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
	  //打开Firefox浏览器
	  driver=new ChromeDriver();
	  //设定等待时间为5秒
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
  }

  @AfterMethod
  public void afterMethod() {
	  //关闭打开的浏览器
	  driver.quit();
  }
  //读取CSV文件的静态方法，使用CSV文件的绝对文件路径作为函数参数
  
}
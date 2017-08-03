package dudu.jingjing;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
//搜索2个关键词，验证搜索结果页面是否包含期望的关键词
public class DataProviderDemo {
	private static WebDriver driver;
	@DataProvider(name="searchData")
	public static Object[][] data()
	{
		return new Object[][] {{"老九门","演员","赵丽颖"},{"X站警天启","导演","布莱恩·辛格"},{"诛仙青云志","编剧","张戬"}};
	}
  @Test(dataProvider="searchData")
  public void testSearch(String searchdata1,String searchdata2,String searchResult) {
	  //打开sogou首页
	  driver.get("http://www.sogou.com/");
	  //输入搜索条件
	  driver.findElement(By.id("query")).sendKeys(searchdata1+" "+searchdata2);
	  //单击搜索按钮
	  driver.findElement(By.id("stb")).click();
	  //单击搜索按钮后，等待3秒显示搜索结果
	  try{
		  Thread.sleep(3000);
	  }catch(InterruptedException e){
		  e.printStackTrace();
	  }
	  //判断搜索的结果是否包含期望的关键字
	  Assert.assertTrue(driver.getPageSource().contains(searchResult));
  }
  @BeforeMethod
  public void beforeMethod() {
	  //若无法打开Firefox浏览器，可设定Firefox浏览器的安装路径
	  
	  driver=new ChromeDriver();
	  //设定等待时间为5秒
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
  }

  @AfterMethod
  public void afterMethod() {
	  //关闭打开的浏览器
	  driver.quit();
  }
}
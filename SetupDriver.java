package driver;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SetupDriver {
	private static WebDriver driver;
	private WebElement wd;

	public void setupDriver() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get("https://emicalculator.net/");
	}

	public void carloanfind() {
		wd = driver.findElement(By.id("car-loan"));
		wd.click();
		WebElement d = driver.findElement(By.xpath("//input[@id='loanamount']"));
		d.click();
		d.clear();
       	d.sendKeys(Keys.BACK_SPACE);
		d.sendKeys("1500000");
		d.sendKeys(Keys.ENTER);
	}

	public void set_The_Interst() {
		WebElement e= driver.findElement(By.xpath("//input[@id='loaninterest']"));
		e.click();
		e.clear();
        e.sendKeys(Keys.BACK_SPACE);
        e.sendKeys("9.5");
        e.sendKeys(Keys.ENTER);
	}
	public void set_The_Tenure() {
	
		driver.findElement(By.cssSelector(".tenure-choice > div:nth-child(1) > label:nth-child(2)")).click();
	WebElement f = driver.findElement(By.xpath("//input[@id='loanterm']"));
		f.click();
	    f.sendKeys(Keys.BACK_SPACE);
	    f.sendKeys(Keys.BACK_SPACE);
	    f.sendKeys("1");
		f.sendKeys(Keys.ENTER);
		
	}
	public void Print_The_Respective_Amount() {
		String Pi=driver.findElement(By.xpath("//table/tbody/tr[2]/td[2]")).getText();
	    System.out.println("Principal Amount is =" + Pi.substring(1));
	    String In=driver.findElement(By.xpath("//table/tbody/tr[2]/td[3]")).getText();
	    System.out.println("Interest Amount is =" +In.substring(1));
	    String To=driver.findElement(By.xpath("//table/tbody/tr[2]/td[4]")).getText();
	    System.out.println("Total Payment Amount is ="+To.substring(1));
	}

	public static void main(String[] args) {
		SetupDriver ob = new SetupDriver();
		ob.setupDriver();
		ob.carloanfind();                
		ob.set_The_Interst();
		ob.set_The_Tenure();
        ob.Print_The_Respective_Amount();
	}
}
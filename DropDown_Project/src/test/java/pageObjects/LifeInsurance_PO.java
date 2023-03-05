package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import commonTags.LifeInsurance_Tags;

public class LifeInsurance_PO {

	public static WebDriver driver;
	public static String benefitsHeader = "";
	public static String sutainabilityHeader = "";

	public static void driver() {

		System.setProperty("Webdriver.chrome.driver", "E:\\Automation\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.get(LifeInsurance_Tags.getDefaultURL());

	}

	public static void windowMax() {

		driver.manage().window().maximize();

	}

	public static void browserClose() {

		driver.close();

	}

	public static void header() {

		WebElement careers = driver.findElement(By.xpath("//a[text()='Careers']"));

		WebElement benefits = driver.findElement(By.xpath("//a[text()='Benefits']"));

		Actions acc = new Actions(driver);

		acc.moveToElement(careers).perform();

		benefits.click();

		WebElement benefitsHdr = driver.findElement(By.xpath(
				"//p[text()='Total Rewards* is a comprehensive program to attract, retain and reward our world-class employees.']")); // Benefits

		benefitsHeader = benefitsHdr.getText(); // Benefits

		// Comparison: Benefits = Benefits
		if (benefitsHeader.equals(
				"Total Rewards* is a comprehensive program to attract, retain and reward our world-class employees.")) {

			System.out.print("Comparison successfull for benefits");

		} else {
			System.out.println("Comparison Failed for benefits");
		}

	}

	public static void subHeader() {

		WebElement investors = driver.findElement(By.xpath("//a[text()='Investors']"));

		WebElement sutainability = driver.findElement(By.xpath("(//a[text()='Sustainability'])[2]"));

		Actions bcc = new Actions(driver);

		bcc.moveToElement(investors).perform();

		bcc.click(sutainability).perform();

		// sutainability.click();
		WebElement sutainabilityHdr = driver.findElement(By.xpath("//span[text()='Sustainability']"));

		WebElement homeButton = driver.findElement(By.xpath("(//a[@class='cmp-breadcrumb__item-link']/span)[1]"));

		sutainabilityHeader = sutainabilityHdr.getText();

		if (sutainabilityHeader.equals("SUSTAINABILITY")) {

			System.out.println("Comparison successfull for sutainability ");
			bcc.click(homeButton).perform();
			System.out.println("Home Button has been Clicked");

		} else {
			System.out.println("Comparison Failed for sutainability");
		}

	}

}

package pageObject_todo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TodoLogin {
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/form/div[1]/input")
	public static WebElement ClickName;

	@FindBy(xpath = "//*[@id=\"root\"]/div/form/div[2]/input")
	public static WebElement ClickPass;
	@FindBy(xpath = "//*[@id=\"root\"]/div/form/button")
	public static WebElement SumitBtn;

}

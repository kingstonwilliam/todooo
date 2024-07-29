package pageObject_todo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TodoSignup {
	@FindBy(xpath = "//*[@id=\"root\"]/div/p/a")
	public static WebElement ClickRegister;
	@FindBy(xpath = "//*[@id=\"root\"]/div/p[1]/a")
	public static WebElement ClickRegister2;
	@FindBy(id = "username")
	public static WebElement ClickName;
	@FindBy(id = "email")
	public static WebElement Clickmail;
	@FindBy(id = "password")
	public static WebElement ClickPassword;
	@FindBy(xpath = "//*[@id=\"root\"]/div/form/div[4]/label/input")
	public static WebElement checkBox;
	@FindBy(xpath = "//*[@id=\"root\"]/div/form/button")
	public static WebElement clickSubmit;
}

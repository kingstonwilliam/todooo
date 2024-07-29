package testCases_Todo;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import commonFunction.CommonFunction;
import freemarker.core.ParseException;
import pageObject_todo.TodoLogin;
import pageObject_todo.TodoSignup;

public class TodoRegistration extends CommonFunction {
	@Test(priority = (0))
	public void OpenGoogle() throws InterruptedException, AWTException, IOException {

		try {
			test = extent.createTest("TC001 - open google");
			test.log(Status.INFO, "Successfully Google opened");
			test.assignCategory("smoke Test");

		}

		catch (Exception e) {
			Robot robot = new Robot();
			java.awt.Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			Rectangle rectangle = new Rectangle(screenSize);
			BufferedImage source = robot.createScreenCapture(rectangle);
			File destinationFile = new File("C:\\ss\\TestEmailLogin.png");
			ImageIO.write(source, "png", destinationFile);
			test.log(Status.FAIL, "Unable to open Google",
					MediaEntityBuilder.createScreenCaptureFromPath("C:\\ss\\TestEmailLogin.png").build());

		}

	}

	@Test(dataProvider="EmailSignup",priority=(1))
	public  void emailSignup(String data) throws InterruptedException, AWTException, IOException {

		try {
			test = extent.createTest("TC002 - Sign Up");
			test.log(Status.INFO, "Sign Up Successfully");
			test.assignCategory("smoke Test");

		 String users[]=data.split(",");
        PageFactory.initElements(driver, TodoSignup.class);
        Thread.sleep(4000);
        TodoSignup.ClickRegister.click();
        Thread.sleep(2000);
        TodoSignup.ClickName.sendKeys(users[0]);
     // Thread.sleep(2000);
       TodoSignup.Clickmail.sendKeys(users[1]);
      TodoSignup.ClickPassword.sendKeys(users[2]);
      TodoSignup.checkBox.click();
     TodoSignup.clickSubmit.click();
        test.log(Status.PASS, "Successfully Entered userId and password");
		//logger.info("TC005 - Email Login UserId and Password");
		//logger.info("Successfully Entered userId");
	}
		catch (Exception e) {
			// logger.error("Error in userId and Password");
			 Robot robot= new Robot();
		     java.awt.Dimension screenSize= Toolkit.getDefaultToolkit().getScreenSize();
		     Rectangle rectangle= new Rectangle(screenSize);
		     BufferedImage source =robot.createScreenCapture(rectangle);
		     File destinationFile=new File("C:\\ss\\TestSignupPage.png");
		     ImageIO.write(source, "png", destinationFile);
		     test.log(Status.FAIL, "Unable to Signup",MediaEntityBuilder.createScreenCaptureFromPath("C:\\ss\\TestSignupPage.png").build());

		}
		}
		@Test(dataProvider="EmailSignup",priority=(2))
		public  void emailDuplicateSignup(String data) throws InterruptedException, AWTException, IOException {

			try {
				test = extent.createTest("TC003 - Sign Up with same user data");
				test.log(Status.INFO, "Successfully error message occured");
				test.assignCategory("smoke Test");

			 String users[]=data.split(",");
	        PageFactory.initElements(driver, TodoSignup.class);
	        Thread.sleep(4000);
	        TodoSignup.ClickRegister2.click();
	        Thread.sleep(2000);
	        TodoSignup.ClickName.sendKeys(users[0]);
	     // Thread.sleep(2000);
	       TodoSignup.Clickmail.sendKeys(users[1]);
	      TodoSignup.ClickPassword.sendKeys(users[2]);
	      TodoSignup.checkBox.click();
	     TodoSignup.clickSubmit.click();
	        test.log(Status.PASS, "Successfully poped up error message");
			//logger.info("TC005 - Email Login UserId and Password");
			//logger.info("Successfully Entered userId");
		}
			catch (Exception e) {
				// logger.error("Error in userId and Password");
				 Robot robot= new Robot();
			     java.awt.Dimension screenSize= Toolkit.getDefaultToolkit().getScreenSize();
			     Rectangle rectangle= new Rectangle(screenSize);
			     BufferedImage source =robot.createScreenCapture(rectangle);
			     File destinationFile=new File("C:\\ss\\TestSignupPage.png");
			     ImageIO.write(source, "png", destinationFile);
			     test.log(Status.FAIL, "Unable to Signup",MediaEntityBuilder.createScreenCaptureFromPath("C:\\ss\\TestSignupPage.png").build());

			}
		
		}
	
	@DataProvider(name="EmailSignup")
	public String[] readEmailSignup() throws IOException, ParseException, org.json.simple.parser.ParseException {
		JSONParser jsonparser= new JSONParser();
		FileReader reader= new FileReader(".\\jsonFolder\\registration.json");
		Object obj=jsonparser.parse(reader);
		JSONObject empjsonobj=(JSONObject)obj;
		JSONArray emailloginsArray=(JSONArray) empjsonobj.get("userSignup");
		String arr[]=new String[emailloginsArray.size()];	
		for(int i=0;i<emailloginsArray.size();i++) {
			JSONObject users=(JSONObject)emailloginsArray.get(i);
			String user=(String) users.get("username");
			String email=(String) users.get("userEmail");
			String pass=(String) users.get("password");
			arr[i]=user+","+email+","+pass;
		}
		return arr;
}
	@Test(dataProvider = "EmailLogin",priority =(3))
	public  void Login(String data) throws InterruptedException, AWTException, IOException {
		 
		try {
			test = extent.createTest("TC003 - Login");
			test.log(Status.INFO, "Login Successfully");
			test.assignCategory("smoke Test");
			Thread.sleep(8000);
			String users[]=data.split(",");
			PageFactory.initElements(driver, TodoLogin.class);
			TodoLogin.ClickName.click();
            TodoLogin.ClickName.sendKeys(users[0]);
            TodoLogin.ClickPass.click();
            TodoLogin.ClickPass.sendKeys(users[1]);
            TodoLogin.SumitBtn.click();
            
            
		}
		catch (Exception e) {
			Robot robot = new Robot();
			java.awt.Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			Rectangle rectangle = new Rectangle(screenSize);
			BufferedImage source = robot.createScreenCapture(rectangle);
			File destinationFile = new File("C:\\ss\\TestEmailLogin.png");
			ImageIO.write(source, "png", destinationFile);
			test.log(Status.FAIL, "Unable to login",
					MediaEntityBuilder.createScreenCaptureFromPath("C:\\ss\\TestEmailLogin.png").build());

		}
	}
	@DataProvider(name="EmailLogin")
	public String[] readEmaiLogin() throws IOException, ParseException, org.json.simple.parser.ParseException {
		JSONParser jsonparser= new JSONParser();
		FileReader reader= new FileReader(".\\jsonFolder\\login.json");
		Object obj=jsonparser.parse(reader);
		JSONObject empjsonobj=(JSONObject)obj;
		JSONArray emailloginsArray=(JSONArray) empjsonobj.get("login");
		String arr[]=new String[emailloginsArray.size()];	
		for(int i=0;i<emailloginsArray.size();i++) {
			JSONObject users=(JSONObject)emailloginsArray.get(i);
			String email=(String) users.get("EmailName");
			String pass=(String) users.get("password");
			arr[i]=email+","+pass;
		}
		return arr;
}

}

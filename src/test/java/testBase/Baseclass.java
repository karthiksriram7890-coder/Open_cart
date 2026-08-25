package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


public class Baseclass {
	
public static WebDriver driver;
public Logger logger;
public Properties p;
	
	@BeforeClass(groups= {"sanity","regression","Master"})
	@Parameters({"os","browser"})
	public void setup(String os,String br) throws IOException {
		
		FileReader file = new FileReader("./src//test//resources//config.properties");
		p =new Properties();
		p.load(file);
		
	logger=LogManager.getLogger(this.getClass());
	
	 switch(br.toLowerCase()) {
	 case "chrome":	driver= new ChromeDriver();break;
	 
	 case "edge": driver= new EdgeDriver(); break;
	 
	 default:System.out.println("Invalid browser"); return;
	 	
		}

	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get(p.getProperty("appurl"));
	driver.manage().window().maximize();
	
}
	@AfterClass(groups= {"sanity","regression","Master"})
	public void tearDown() {
		driver.quit();
	}
	
	public String randomeString() {

	String generatedstring= RandomStringUtils.secure().nextAlphabetic(5);
		return  generatedstring;
	}
	
	public String randomenumber() {

	String generatednumber= RandomStringUtils.secure().nextAlphanumeric(10);
	
		return  generatednumber;
	}
	
	public String randomAlphaNumberic() {
		
		String generatedstring= RandomStringUtils.secure().nextAlphabetic(5);
	String generatednumber= RandomStringUtils.secure().nextAlphanumeric(3);
	
		return(generatedstring+"@"+generatednumber);
	}
	public String captureScreen(String tname) {
		String timestamp =new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		
	File sourcefile=ts.getScreenshotAs(OutputType.FILE);
	
	String targetfile= System.getProperty("user.dir")+"\\screenshots\\"+tname+"_"+timestamp+".png";
	
	File targetpath=new File(targetfile);
	
	sourcefile.renameTo(targetpath);
	
	
		return targetfile;
	}
}

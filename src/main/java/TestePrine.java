import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class TestePrine {
	
	private WebDriver driver;
	private DSL dsl;
	
	@Before
	public void inicializa(){
		System.setProperty("webdriver.gecko.driver", 
		        "C:\\JAVA_HOME\\Automação_home\\geckodriver.exe");
		
		driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		dsl = new DSL(driver);
	}
	
	@After
	public void finaliza(){
		// driver.quit(); 
}
	@Test
	public void deveInteragirComRadioPrime() {
		driver.get("https://www.primefaces.org/showcase/ui/input/oneRadio.xhtml");
	   dsl.clicarRadio(By.xpath("//input[@id='j_idt86:console:0']/../..//span"));
	   Assert.assertTrue(dsl.isRadioMarcado("j_idt86:console:0"));
	   dsl.clicarRadio(By.xpath("//label[.='PS4']/..//span"));
	   Assert.assertTrue(dsl.isRadioMarcado("j_idt86:console:1"));
	}
	
	@Test
	public void deveInteragirComSelectPrime() {
		driver.get("https://www.primefaces.org/showcase/ui/input/oneMenu.xhtml");
		dsl.selecionarCombo("j_idt86:console_input", "PS4");
	}
	
	
}




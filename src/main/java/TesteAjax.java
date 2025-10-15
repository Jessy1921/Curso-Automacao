import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.ce.wcaquino.core.DSL;

public class TesteAjax {
	
	private WebDriver driver;
	private DSL dsl;
	
	@Before
	public void inicializa(){
		System.setProperty("webdriver.gecko.driver", 
		        "C:\\JAVA_HOME\\Automação_home\\geckodriver.exe");
		
		driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("https://www.primefaces.org/showcase/ui/ajax/basic.xhtml");
		dsl = new DSL(driver);
	}
	
	@After
	public void finaliza(){
		// driver.quit(); 
}

	@Test
	public void testAjax() {
		dsl.escrever("j_id_47:name", "Teste");
		dsl.clicarBotao("j_id_47:j_id_4d");
		WebDriverWait wait = new WebDriverWait(driver, 30);
	//	wait.until(ExpectedConditions.textToBe(By.id("j_idt85:display"), "Teste"));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("j_idt98")));
		Assert.assertEquals("Teste", dsl.obterTexto("j_idt85:display"));
	}
}

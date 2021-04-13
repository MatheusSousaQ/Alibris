package alibris_test;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import java.util.*;


public class BuscaProduto  {
    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers/chrome/89/chromedriver.exe");
        driver = new ChromeDriver();
    }
    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void buscarProdutoEValidaNaLista() {
        driver.get("https://www.alibris.com/");
        driver.manage().window().setSize(new Dimension(1456, 876));
        driver.findElement(By.id("searchBox")).click();
        driver.findElement(By.id("searchBox")).sendKeys("the art of software testing");
        driver.findElement(By.id("sbSubmit")).click();
        assertThat(driver.findElement(By.cssSelector("li:nth-child(1) .price-row:nth-child(2) .price:nth-child(1)")).getText(), is("$40.82"));
    }

    @Test
    public void buscaprodutoevalidanateladoproduto() {
        driver.get("https://www.alibris.com/");
        driver.manage().window().setSize(new Dimension(1456, 876));
        driver.findElement(By.id("searchBox")).click();
        driver.findElement(By.id("searchBox")).sendKeys("the art of software testing");
        driver.findElement(By.id("sbSubmit")).click();
        driver.findElement(By.linkText("The Art of Software Testing")).click();
        assertThat(driver.findElement(By.cssSelector(".product-container:nth-child(1) .price > p")).getText(), is("$163.01"));
    }
}


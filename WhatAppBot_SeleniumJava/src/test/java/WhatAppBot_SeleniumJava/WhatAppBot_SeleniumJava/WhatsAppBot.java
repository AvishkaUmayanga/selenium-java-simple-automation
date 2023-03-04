package WhatAppBot_SeleniumJava.WhatAppBot_SeleniumJava;



import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WhatsAppBot {
	
	public static void main( String[] args ) throws InterruptedException
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        
        //open whatsapp web
        driver.get("https://web.whatsapp.com/");
        Actions a =new Actions(driver);
        Thread.sleep(20000);
        
        //click search bar
        WebElement chatNew = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[3]/header/div[2]/div/span/div[3]/div/span"));
        chatNew.click();
        
        try {
        	//search the name what you want to get from contact list 
            WebElement searchContact = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[1]/span/div/span/div/div[1]/div/div/div[2]/div/div[2]"));
            searchContact.sendKeys("john");
            Thread.sleep(10000);
            a.sendKeys(Keys.ENTER).perform();
            
          //Type message in message box
            WebElement messageBox = driver.findElement(By.xpath("//*[@id=\"main\"]/footer/div[1]/div/span[2]/div/div[2]/div[1]/div/div[1]/p"));
            messageBox.sendKeys("Hi Avishka Here ... using the whatsapp bot");
            a.sendKeys(Keys.ENTER).perform();
            
        	}catch(Exception e){
            	System.out.println("Name not in the contact list");
            }
          
        
    }
}

package com.jorge.testui.selenium;

import com.jorge.testui.selenium.enums.SelectorEnum;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * @author mufanglin
 * @email 280932756@qq.com
 * @date 2019-12-11 11:22
 */
@Slf4j
public class BaseSeleniumTest {
    protected static WebDriver driver;
    protected static String		baseUrl;

    /**
     * 查找对应标签名 text 值为输入值对象
     *
     * @param tagName
     * @param textValue
     * @return
     */
    public WebElement findWebElement(String tagName, String textValue) {
        List<WebElement> allElement = driver.findElements(By.tagName(tagName));
        for (WebElement e : allElement) {
            //            log.info("Text:"+e.getText());
            if (e.getText().toString().equals(textValue)) {
                return e;
            }
        }
        return null;

    }

    /**
     * 单选框选择，定位单选按钮名称，根据Value值确定选择那个
     *
     * @param name
     * @param value
     * @return
     */
    public WebElement findWebElementRadio(String name, String value) {
        List<WebElement> allElement = driver.findElements(By.name(name));
        for (WebElement e : allElement) {
            log.info("attribute:" + e.getAttribute("value"));
            if (e.getAttribute("value") != null
                    && e.getAttribute("value").toString().contains(value)) {
                return e;
            }
        }
        return null;

    }

    // Web-related click events
    public void click(SelectorEnum selector, String pathValue) {
        switch (selector.code()) {
            case "id":
                driver.findElement(By.id(pathValue)).click();
                log.info("This test click event is used-id: {}" , pathValue);
                break;
            case "name":
                driver.findElement(By.name(pathValue)).click();
                log.info("This test click event is used-name: {}" , pathValue);
                break;
            case "xpath":
                driver.findElement(By.xpath(pathValue)).click();
                log.info("This test click event is used-xpath:{} " , pathValue);
                break;
            case "cssSelector":
                driver.findElement(By.cssSelector(pathValue)).click();
                log.info("This test click event is used-cssSelector: {}" , pathValue);
                break;
            case "className":
                driver.findElement(By.className(pathValue)).click();
                log.info("This test click event is used-className: {}" , pathValue);
                break;
            case "tagName":
                driver.findElement(By.tagName(pathValue)).click();
                log.info("This test click event is used-tagName: {}" , pathValue);
                break;
            case "linkText":
                driver.findElement(By.linkText(pathValue)).click();
                log.info("This test click event is used-linkText: {}" , pathValue);
                break;
            case "partialLinkText":
                driver.findElement(By.partialLinkText(pathValue)).click();
                log.info("This test click event is used-partialLinkText: {}" , pathValue);
                break;
            default:
                log.info("Illegal selector: {} !!!",selector);
                break;
        }
    }

    //Web-related sendKeys events
    public void sendKeys(SelectorEnum selector, String pathValue, String sendkeys) {
        switch (selector.code()) {
            case "id":
                driver.findElement(By.id(pathValue)).clear();
                driver.findElement(By.id(pathValue)).sendKeys(sendkeys);
                log.info("This test sendKeys event is used-id:{} " , pathValue);
                log.info("By id senKeys value: {}" , sendkeys);
                break;
            case "name":
                driver.findElement(By.name(pathValue)).clear();
                driver.findElement(By.name(pathValue)).sendKeys(sendkeys);
                log.info("This test sendKeys event is used-name: {}" , pathValue);
                log.info("By name senKeys value: {}" , sendkeys);
                break;
            case "xpath":
                driver.findElement(By.xpath(pathValue)).clear();
                driver.findElement(By.xpath(pathValue)).sendKeys(sendkeys);
                log.info("This test sendKeys event is used-xpath: {}" , pathValue);
                log.info("By xpath senKeys value: {}" , sendkeys);
                break;
            case "linkText":
                driver.findElement(By.linkText(pathValue)).clear();
                driver.findElement(By.linkText(pathValue)).sendKeys(sendkeys);
                log.info("This test sendKeys event is used-linkText: {}" , pathValue);
                log.info("By linkText senKeys value: {}" , sendkeys);
                break;
            case "className":
                driver.findElement(By.className(pathValue)).clear();
                driver.findElement(By.className(pathValue)).sendKeys(sendkeys);
                log.info("This test sendKeys event is used-className: {}" , pathValue);
                log.info("By className senKeys value: {}" , sendkeys);
                break;
            case "tagName":
                driver.findElement(By.tagName(pathValue)).clear();
                driver.findElement(By.tagName(pathValue)).sendKeys(sendkeys);
                log.info("This test sendKeys event is used-tagName: {}" , pathValue);
                log.info("By tagName senKeys value: {}" , sendkeys);
                break;
            case "partialLinkText":
                driver.findElement(By.partialLinkText(pathValue)).clear();
                driver.findElement(By.partialLinkText(pathValue)).sendKeys(sendkeys);
                log.info("This test sendKeys event is used-partialLinkText: {}" , pathValue);
                log.info("By partialLinkText senKeys value: {}" , sendkeys);
                break;
            case "cssSelector":
                driver.findElement(By.cssSelector(pathValue)).clear();
                driver.findElement(By.cssSelector(pathValue)).sendKeys(sendkeys);
                log.info("This test sendKeys event is used-cssSelector: {}" , pathValue);
                log.info("By cssSelector senKeys value: {}" , sendkeys);
                break;
            default:
                log.info("Illegal selector: {} !!!",selector);
                break;
        }
    }
}

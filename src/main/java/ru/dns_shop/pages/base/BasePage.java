package ru.dns_shop.pages.base;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import ru.dns_shop.pages.TopMenu;
import ru.dns_shop.pages.managers.PageManager;
import static ru.dns_shop.pages.managers.DriverManager.getDriver;
import ru.dns_shop.pages.managers.PropertiesManager;
import static ru.dns_shop.pages.utils.ProperitesConstant.*;
import ru.dns_shop.pages.utils.Screenshoter;

/**
 * Базовый класс для страниц фреймворка.
 * @author vadim
 */
public class BasePage {
    protected PageManager apptest = PageManager.getManager();
    protected PropertiesManager propertiesManager = PropertiesManager.getPropertiesManager();
    protected Screenshoter scr = new Screenshoter();
    protected static long timeOperation;
    /**
     * Метод первоначальной настройки драйвера и параметров запуска
     */
    public BasePage() {
        PageFactory.initElements(getDriver(), this);
        initTime();
    }
    
    public void fillInputField(WebElement element, String value) {
        element.sendKeys(value);
    }
    
    public void fillFields(String nameElement, String value) {
        /*switch(nameElement) {
            case "0" :
                fillFields("0", value);
                break;
            default:
                System.out.println("");
        }*/
    }
    
    public void scrollToElement() {
        
    }
    
    public boolean isElementExist(By by) {
        boolean flag = false;
        try {
            getDriver().manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
            getDriver().findElement(by);
            flag = true;
        } catch (NoSuchElementException ignore) {}
        finally {
            getDriver().manage().timeouts().implicitlyWait(Integer.parseInt(
            propertiesManager.getProperty(IMPLICITY_WAIT)), TimeUnit.SECONDS);
        }
        return flag;
    }

    // Метод перехода к элементам главного меню для доступности в любой части страницы
    public TopMenu getTopMenu() {
        //scr.takeScreenshot();
        return apptest.getTopMenu();
    }
    
    public static void print(String text, String r) {
        String mask = "'%s' - '%s' - '%s'";
        long thisTime = System.currentTimeMillis();
        String textPrint = String.format(mask, r, text, ((thisTime-timeOperation) + "ms"));
        timeOperation = thisTime;
        System.out.println(textPrint);
    }
    
    private void initTime() {
        timeOperation = System.currentTimeMillis();
    }
}

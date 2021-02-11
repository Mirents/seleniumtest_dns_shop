package ru.dns_shop.pages;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.dns_shop.pages.base.BasePage;

/**
 * Класс главной страницы сайта
 * @author vadim
 */
public class SearchResultPage extends BasePage {
    
    @FindBy(xpath = "//div[contains(@class, 'products-list__content')]")
    List<WebElement> productList;
    
    /*@FindBy(xpath = "//a[contains(@aria-label, 'Карты')]")
    WebElement buttonMenu;
    
    @FindBy(xpath = "//a[contains(@class, 'kitt-top-menu__link kitt-top-menu__link_second') and contains(text(), 'Дебетовые')]")
    WebElement buttonPodPenu;*/

    
    public void findInList(String name) {
        for(WebElement e: productList) {
            System.out.println("::::::: text = " + e.getText() + " / " + e.getTagName());
        }
    }
}
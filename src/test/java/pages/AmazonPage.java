package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AmazonPage extends BasePage{

    String searchBar="//input[@id='twotabsearchtextbox']";
    String searchButton="//input[@id='nav-search-submit-button']";
    String thirdProduct="/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/span[1]/div[1]/div[4]/div[1]/div[1]/span[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/a[1]/h2[1]/span[1]";
    String addToCartButton="//input[@id='add-to-cart-button']";
    String successMessage="/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/h1[1]";
    String xpathResults="//div[@data-component-type='s-search-result']//img[@class='s-image']/ancestor::a";

    public void navigateTo(){
        navigateTo("https://www.amazon.com/");
        //test
    }

    public void clickOnSearchButton(){
        clickElement(searchButton);
    }

    public void searchProduct(String product){
        type(searchBar,product);
    }

    public void goToPage(int pageNumber){
        goToLinkText(String.valueOf(pageNumber));
    }


    public void selectAnItem(){
        clickElement(thirdProduct);
    }

    public void addToCart(){
        clickElement(addToCartButton);
    }

    public String successMessage(){
        return getButtonName(successMessage);
    }


    public void clickItem(int index){
        selectNthElement(xpathResults,index);
    }



}

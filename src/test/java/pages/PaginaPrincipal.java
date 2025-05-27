package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

public class PaginaPrincipal extends BasePage{
    WebElement web=new RemoteWebElement();

    private String searchButton="//a[@href='/introduccion-al-testing-de-software'][normalize-space()='Ver producto']";
    private String sectionLink="//a[normalize-space()='%s' and @href]";
    private String elegirPlan="//a[normalize-space()='Elegir Plan']";

    //Metodo para navegar a la pagina freeRange


    public void navigateToFreeRange(){
        navigateTo("https://www.freerangetesters.com");

    }

    public void clickNavSection(String section){
        //reemplazar marcador posicion %s
        String xpathSection= String.format(sectionLink,section);
        clickElement(xpathSection);
    }

    public void clickElegirPlan(){
        clickElement(elegirPlan);
    }



}

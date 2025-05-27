package pages;

public class CursosPage extends BasePage {
    private String fundamentosLink="//h3[normalize-space()='Introducción al Testing de Software']";
    private String tabTitle="//h2[contains(normalize-space(),'%s')]";

    public void clickFundamentos(){
        clickElement(fundamentosLink);
    }

    public boolean tabTitle(String section){
        String xpathSection=String.format(tabTitle, section);
        return getButtonName(xpathSection).contains(section);
    }

}

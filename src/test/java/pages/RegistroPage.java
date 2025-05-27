package pages;

import java.util.List;

public class RegistroPage extends BasePage{
    private String dropLocator="//select[@id='cart_cart_item_attributes_plan_with_interval']";
    private String courseName="//h3[@class='mt-n1']";

    public void dropdown(){
        selectFromDropdownByIndex(dropLocator,0);
    }

    public List<String> returnDrodpownnValues(){
        return getDropdownValues(dropLocator);
    }

    public boolean courseTitle(String nombreCurso){
        return getButtonName(courseName).contains(nombreCurso);
    }


}

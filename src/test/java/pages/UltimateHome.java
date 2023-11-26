package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class UltimateHome {
    private WebDriver driver;
    public UltimateHome(WebDriver driver){this.driver=driver;}

    By clickableIcon = By.xpath("//a[@href='/link-success/']/span/span");
    By linkSuccessPageTitle = By.xpath("//h1[@class='entry-title']");
    By nameField = By.xpath("//input[@id='et_pb_contact_name_0']");
    By emailField = By.xpath("//input[@id='et_pb_contact_email_0']");
    By emailMeButton = By.xpath("//button[@name='et_builder_submit_button']");
    By emailSentMessage = By.xpath("//div[@class='et-pb-contact-message']//p");
    By femaleRadioButton = By.xpath("//input[@value='female']");
    By iHaveBikeCheckbox = By.xpath("//input[@value='Bike']");
    By iHaveCarCheckbox = By.xpath("//input[@value='Car']");
    By carDropdown = By.xpath("//option[@value='volvo']/..");
    By tabOne = By.xpath("//li[@class='et_pb_tab_0']");
    By tabTwo = By.xpath("//li[@class='et_pb_tab_1']/a");
    By tabText = By.xpath("//div[@class='et_pb_tab_content']");
    By listOftabs = By.xpath("//ul[@class='et_pb_tabs_controls clearfix']");

    public void clickClickableIcon(){
        driver.findElement(clickableIcon).click();
    }

    public String getLinkSuccessPageTitle(){
        return  driver.findElement(linkSuccessPageTitle).getText();
    }

    public void inputContactName(String name){
        driver.findElement(nameField).sendKeys(name);
    }
    public void inputContactEamil(String email){
        driver.findElement(emailField).sendKeys(email);
    }
    public void clickOnEmailMeButton(){
        driver.findElement(emailMeButton).click();
    }
    public String getEmailSentMessage(){
        return driver.findElement(emailSentMessage).getText();
    }

    public void clickOnFemaleRadioButton(){
        driver.findElement(femaleRadioButton).click();
    }

    public boolean getFemaleRadioButtonStatus(){
        return driver.findElement(femaleRadioButton).isSelected();
    }

    public void checkIHaveBikeCheckbox(){
        driver.findElement(iHaveBikeCheckbox).click();
    }
    public void checkIHaveCarCheckbox(){
        driver.findElement(iHaveCarCheckbox).click();
    }
    public boolean getIHaveBikeCheckboxStatus(){
        return driver.findElement(iHaveBikeCheckbox).isSelected();
    }
    public boolean getIHaveCarCheckboxStatus(){
        return driver.findElement(iHaveCarCheckbox).isSelected();
    }

    public void selectCar(String option){
        Select carDropdownObject = new Select(driver.findElement(carDropdown));
        carDropdownObject.selectByValue(option);
    }
    public String getSelectedOption(){
        Select carDropdownObject = new Select(driver.findElement(carDropdown));
        return carDropdownObject.getFirstSelectedOption().getText();
    }

    public void clickOnTabOne(){
        driver.findElement(tabOne).click();
    }
    public void clickOnTabTwo(){
        ((JavascriptExecutor)driver).executeScript("arguments[0].click()", driver.findElement(tabTwo));
        //driver.findElement(tabTwo).click();
    }
    public String getTabText(){
        return driver.findElement(tabText).getText();
    }
    public void scrollToTabList(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", driver.findElement(listOftabs));
        driver.findElement(tabText).click();
    }
}

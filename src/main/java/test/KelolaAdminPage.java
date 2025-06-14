package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class KelolaAdminPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public KelolaAdminPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


//    LOCATOR
    public By tambahAdminBtn = By.id("tambahAdminBtn");
    public By fieldName = By.id("name");
    public By fieldEmail = By.id("email");
    public By fieldPass = By.id("password");
    public By fieldConfirmPass = By.id("confirmPassword");
    public By tamabahAdminSideBar = By.xpath("//*[@id=\"tambahAdminModal\"]/div[1]/h3");
    public By txtTambahAdmin = By.cssSelector("#tambahAdminModal .modal-header h3");
    public By tombolTambah = By.xpath("//*[@id=\"tambahAdminForm\"]/div[5]/button[2]");
    public By toastMessage = By.xpath("//div[contains(@class, 'toastify') and contains(text(), 'Password yang dimasukkan')]");


    //    ACTION
    public void clickButton(By locator) {
        WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        button.click();
    }

    public void kirimData(By field, String query) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(field));
        element.sendKeys(query);
    }

//    GETTER
    public String getCurrentUrl() {
        wait.until(ExpectedConditions.urlContains("admin"));
        return driver.getCurrentUrl();
    }

    public String getText(By element){
        return  driver.findElement(element).getText();
    }
    public Boolean isTxtTambahAdminVisible() {
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(txtTambahAdmin));
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isAdminEmailExist(String email) {
        try {
            By emailLocator = By.xpath("//table[@id='adminTable']//td//div[contains(text(),'" + email + "')]");
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(emailLocator));
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isPesanErrorMenambahkanAdminVisible() {
        try {
            WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(toastMessage));
            return toast.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

}

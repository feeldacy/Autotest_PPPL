package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class KelolaTanahPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public KelolaTanahPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

//    LOCATOR
    public By detailBtn = By.xpath("//*[@id=\"groundTable\"]/tbody/tr[1]/td[5]/div/button[2]");
    public By modalDetailTitle = By.xpath("//*[@id=\"detailModal\"]/div/h2");
    public By tombolDelete = By.xpath("//table[@id='groundTable']//tr[td[2][normalize-space()='test1']]//button[contains(@class, 'delete')]");
    public By tombolDeleteModal = By.xpath("//button[contains(text(),'Hapus')]");
    public By txtKonfirmasiHapus = By.xpath("//h2[contains(text(), 'Apakah yakin akan menghapus tanah')]");



    public void clickButton(By locator) {
        WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        button.click();
    }

    public void hapusDataTanahBerdasarkanNama(String namaAsset) {
        WebElement tombolHapus = wait.until(ExpectedConditions.elementToBeClickable(tombolDelete));
        tombolHapus.click();
    }


    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public String getText(By element){
        return  driver.findElement(element).getText();
    }


    public Boolean isTxtKonfirmasiHapusnVisible() {
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(txtKonfirmasiHapus));
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isDataTanahDenganNamaTidakTampil(String namaAsset) {
        String xpathBaris = "//table[@id='groundTable']//tr[td[2][normalize-space()='" + namaAsset + "']]";
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpathBaris)));
            return true;
        } catch (Exception e) {
            return false;
        }
    }


}

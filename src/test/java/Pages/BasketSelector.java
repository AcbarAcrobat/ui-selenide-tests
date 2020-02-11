package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$;

public class BasketSelector {

  WebDriver driver;

  public void BasketPage(WebDriver driver)
  {
    this.driver = driver;
  }

  private By basket = By.cssSelector(".basket > .wrapper");

    public void setBasket(String strBasket) {
      $(By.cssSelector(String.valueOf(getBasket()))).click();
    }

  public By getBasket() {
    return basket;
  }
}

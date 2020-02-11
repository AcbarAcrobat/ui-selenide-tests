import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class AddProductTest {

  @BeforeTest
  public void setUp()
  {
    open("https://market.evotor.ru");
  }

  @Test
  public void FirstMethodAdd() throws Exception
  {
    setBasket();
    addProduct();
    set1CInMenu();
    selectProductInList();
    goToBasketAfter();
    checkProductInBasket();
//    $(By.cssSelector(".categories > Обмен с 1С")).click();
  }

  public void setBasket() {
    $(By.cssSelector(".basket > .wrapper")).click();
  }

  public void addProduct() {
    $(By.cssSelector(".basket-empty__button")).click();
  }

  public void set1CInMenu() {
    $(By.xpath("//a[contains(@class, 'categories__item')][23]")).click();
  }

  public void selectProductInList() {
    $(By.xpath("//app-card[.//h3[@class = 'app-title' and contains(.,'Интеграция 1С 8')]]")).click();
  }

  public void goToBasketAfter() {
    $(By.cssSelector(".plan-item-controls__basket-button")).click();
  }

  public void checkProductInBasket() {
    $(By.xpath("//*[contains(@class,'basket__list-item')]")).shouldBe(Condition.visible);
  }

  @AfterTest
  public void TearDown()
  {
    closeWebDriver();
  }
}

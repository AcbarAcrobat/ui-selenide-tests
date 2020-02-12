import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

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
    goToCategory("Обмен с 1С");
    selectProductInList();
    goToBasketAfter();
    checkProductInBasket();
//    $(By.cssSelector(".categories > Обмен с 1С")).click();
  }

  public void setBasket()
  {
    $(By.cssSelector(".basket > .wrapper")).click();
  }

  public void addProduct()
  {
    $(By.cssSelector(".basket-empty__button")).click();
  }

  public void goToCategory(String catName)
  {
    String xpath = String.format("//a[contains(concat(' ', normalize-space(@class), ' '), ' categories__item ')][contains(., '%s')]", catName);
    $(By.xpath(xpath)).click();
  }

  public void selectProductInList()
  {
    $(By.xpath("//app-card[.//h3[@class = 'app-title' and contains(.,'Интеграция 1С 8')]]")).click();
  }

  public void goToBasketAfter()
  {
    $(By.cssSelector(".plan-item-controls__basket-button")).click();
  }

  public void checkProductInBasket()
  {
    $(By.xpath("//*[contains(@class,'basket__list-item')]")).shouldBe(Condition.visible);
  }

  @AfterTest
  public void TearDown()
  {
    closeWebDriver();
  }
}

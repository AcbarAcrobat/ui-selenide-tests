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
    $(By.cssSelector(".basket > .wrapper")).click();
    $(By.cssSelector(".basket-empty__button")).click();
//    $(By.cssSelector(".categories > Обмен с 1С")).click();
    $(By.xpath("//a[contains(@class, 'categories__item')][23]")).click();
    $(By.xpath("//app-card[.//h3[@class = 'app-title' and contains(.,'Интеграция 1С 8')]]")).click();
    $(By.cssSelector(".plan-item-controls__basket-button")).click();
    $(By.xpath("//*[contains(@class,'basket__list-item')]")).shouldBe(Condition.visible);
  }

  @AfterTest
  public void TearDown()
  {
    closeWebDriver();
  }
}

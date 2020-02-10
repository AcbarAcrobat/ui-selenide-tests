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
    $(By.xpath("//header-basket-button[contains(@class, 'basket')]")).click();
    $(By.xpath("//*[contains(text(), 'Добавьте')]")).click();
    $(By.xpath("//*[contains(text(), 'Обмен с 1С') and contains(@class, 'ng-star-inserted')]")).click();
    $(By.xpath("//*[contains(@class, 'app-category__card ng-star-inserted')][1]")).click();
    $(By.xpath("//*[contains(@class, 'evo-button_green')]")).click();
  }

  @AfterTest
  public void TearDown()
  {
    closeWebDriver();
  }
}

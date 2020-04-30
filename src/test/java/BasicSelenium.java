import conf.TestManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import pages.BoardsPage;
import pages.HomePage;
import pages.LoginPage;

public class BasicSelenium extends TestManager {

    @Test
    public void openHomePage(){
        HomePage homePage = new HomePage(driver);
        homePage.openPage(homePage.url);
        String title = homePage.getTitle();
        Assertions.assertEquals(title, homePage.title);
    }

    @Test
    public void loginTest(){
        //Home Page
        HomePage homePage = new HomePage(driver);
        homePage.openPage(homePage.url);
        homePage.loginLink.click();
        // Login Page
        LoginPage loginPage = new LoginPage(driver);
        loginPage.emailField.sendKeys("kovtunihor@gmail.com");
        loginPage.passwordField.sendKeys("2481632az" + Keys.ENTER);
        // Boards Page
        BoardsPage boardsPage = new BoardsPage(driver);
        Assertions.assertTrue(boardsPage.allBoardsContainer.isExist());
    }

}

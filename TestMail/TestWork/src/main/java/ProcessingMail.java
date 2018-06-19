
import data_provider.DataProviderEmail;
import org.testng.annotations.Test;
import pages.PageFillParameters;
import pages.WebDriverSettingsMainPage;
import users.User;


public class ProcessingMail extends WebDriverSettingsMainPage {
    User user = User.createUser();
    PageFillParameters pageFillParameters = new PageFillParameters();

    @Test(groups = "login page")
    public void inputLoginPage() {
        mainPage.searchUserName(user.getLogin());
    }

    @Test(dependsOnMethods = "inputLoginPage", groups = "login page")
    public void inputPasswordPage() {
        mainPage.searchPassword(user.getPassword());

    }

    @Test(dependsOnMethods = "inputPasswordPage", groups = "login page")
    public void checkButtonMainPage() {

        mainPage.searchLoginClickButton();
        pageFillParameters.getDriver(mainPage.getDriver());

    }


    @Test(dependsOnGroups = "login page", dataProvider = "wordsMail", dataProviderClass = DataProviderEmail.class)
    public void checkWordsMail(String wordsReciever, String wordsBody) {

        pageFillParameters.clickButtonWrite();
        pageFillParameters.writeWordsMail(wordsReciever);
        pageFillParameters.writeWordsBody(wordsBody);
        pageFillParameters.clickOnSendMail();

    }
}

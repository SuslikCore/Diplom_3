import PageObject.ProfilePage;
import RandomGenerator.Generator;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import PageObject.LoginPage;
import PageObject.MainPage;
import PageObject.RegisterPage;

public class test extends BaseUITest{

    @Test
    @DisplayName("Проверка регистрации")
    @Description("Проверка регистрации с валидными данными")
    public void successfulRegisterTest(){

        String generatedEmail = generator.generateEmail(6);
        String generatedUserName = generator.generateUserName(6);
        String generatedPassword = generator.generatePassword(6);

        mainPage.openMainPage();
        mainPage.clickAccountLink();
        loginPage.clickRegisterButton();
        registerPage.registerUser(generatedUserName, generatedEmail,generatedPassword);
        loginPage.loginIn(generatedEmail,generatedPassword);
        mainPage.clickAccountLink();

        Assert.assertEquals(generatedEmail, profilePage.getEmail());

        setGeneratedData(generatedEmail ,generatedPassword);

        System.out.printf("%s%n%s%n%s%n", generatedEmail,generatedPassword,generatedUserName);
    }

    @Test
    public void incorrectPasswordTest(){

        String generatedEmail = generator.generateEmail(6);
        String generatedUserName = generator.generateUserName(6);
        String generatedPassword = generator.generatePassword(3);

        mainPage.openMainPage();
        mainPage.clickAccountLink();
        loginPage.clickRegisterButton();
        registerPage.registerUser(generatedUserName, generatedEmail,generatedPassword);

        Assert.assertEquals("Некорректный пароль", registerPage.incorrectPasswordMessage());

        setGeneratedData(generatedEmail ,generatedPassword);

        System.out.printf("%s%n%s%n%s%n", generatedEmail,generatedPassword,generatedUserName);
    }


}

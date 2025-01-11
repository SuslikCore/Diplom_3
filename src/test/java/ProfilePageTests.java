import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;

import static PageObject.MainPage.MAIN_PAGE_URL;
import static PageObject.ProfilePage.PROFILE_PAGE_URL;

public class AccountPageTests extends BaseUITest{

    @Test
    @DisplayName("Переход зарегистрированного пользователя до страницы профиля")
    @Description("")
    public void goToProfilePageTest(){

        String generatedEmail = generator.generateEmail(6);
        String generatedUserName = generator.generateUserName(6);
        String generatedPassword = generator.generatePassword(6);
        setGeneratedData(generatedEmail ,generatedPassword);

        registerPage.openRegisterPage();
        registerPage.registerUser(generatedUserName, generatedEmail,generatedPassword);
        loginPage.loginIn(generatedEmail,generatedPassword);
        mainPage.clickAccountLink();

        softAssertions.assertThat(profilePage.getProfileText()).isEqualTo("Профиль");
        softAssertions.assertThat(driver.getCurrentUrl()).isEqualTo(PROFILE_PAGE_URL);
        softAssertions.assertAll();
    }

    @Test
    @DisplayName("Переход из личного кабинета на главную страницу через ссылку Конструктор")
    @Description("")
    public void goToMainPageFromProfilePageViaConstructorButton(){

        String generatedEmail = generator.generateEmail(6);
        String generatedUserName = generator.generateUserName(6);
        String generatedPassword = generator.generatePassword(6);
        setGeneratedData(generatedEmail ,generatedPassword);

        registerPage.openRegisterPage();
        registerPage.registerUser(generatedUserName, generatedEmail,generatedPassword);
        loginPage.loginIn(generatedEmail,generatedPassword);
        profilePage.clickConstructorLink();

        Assert.assertEquals(MAIN_PAGE_URL, driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Переход из личного кабинета на главную страницу через лого")
    @Description("")
    public void goToMainPageFromProfilePageViaLogoLink(){

        String generatedEmail = generator.generateEmail(6);
        String generatedUserName = generator.generateUserName(6);
        String generatedPassword = generator.generatePassword(6);
        setGeneratedData(generatedEmail ,generatedPassword);

        registerPage.openRegisterPage();
        registerPage.registerUser(generatedUserName, generatedEmail,generatedPassword);
        loginPage.loginIn(generatedEmail,generatedPassword);
        profilePage.clickBurgerLogoLink();

        Assert.assertEquals(MAIN_PAGE_URL, driver.getCurrentUrl());
    }


}

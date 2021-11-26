package org.test;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AppTest
{
    private AndroidDriver androidDriver;
    private SwipesClass swipesClass;
    private LoginPage loginPage;
    private InboxPage inboxPage;
    private MenuPage menuPage;
    private BeginPage beginPage;
    private SentPage sentPage;
    private SettingsPage settingsPage;

    @BeforeMethod
    public void setup() throws MalformedURLException
    {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "phone");
        capabilities.setCapability("platformName", "android");
        capabilities.setCapability("platformVersion", "11.0");
        capabilities.setCapability("udid","emulator-5554");
        capabilities.setCapability("appPackage","ru.yandex.mail");
        capabilities.setCapability("appActivity", "ru.yandex.mail.ui.LoginActivity");
        androidDriver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
        swipesClass = new SwipesClass(androidDriver);
        androidDriver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
    }

    @Test
    public void all()
    {
        /** начальные действия перед авторизацией */
        loginPage = new LoginPage(androidDriver, swipesClass);
        inboxPage = loginPage.clickContinue();
        menuPage = inboxPage.openMenu();
        beginPage = menuPage.clickLogout();
        beginPage.isBeginPage();
        loginPage = beginPage.clickYandex();

        /** авторизация */
        inboxPage = loginPage.login(ConfProperties.getProperty("login"), ConfProperties.getProperty("password"));
        inboxPage.isInboxPage();

        /** переход в отправленные сообщения */
        menuPage = inboxPage.openMenu();
        sentPage = menuPage.clickSent();
        sentPage.isSentPage();

        /** открытие/закрытие меню */
        menuPage = sentPage.openMenu();
        menuPage.closeMenu();

        /** переход во входящие сообщения */
        menuPage = sentPage.openMenu();
        inboxPage = menuPage.clickInbox();
        inboxPage.isInboxPage();

        /** изменение темы */
        menuPage = inboxPage.openMenu();
        settingsPage = menuPage.clickSettings();
        settingsPage.setThemeDark();
        settingsPage.Wait();
        settingsPage.isDark();
        settingsPage.setThemeLight();
        settingsPage.Wait();
        settingsPage.isLight();
        menuPage = settingsPage.clickBack();

        /** выход из аккаунта */
        menuPage.clickLogout();
        beginPage.isBeginPage();
    }

    @AfterMethod
    public void exit()
    {
        androidDriver.quit();
    }
}

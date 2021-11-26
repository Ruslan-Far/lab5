package org.test;

import io.appium.java_client.android.AndroidDriver;

public class LoginPage
{
    private AndroidDriver androidDriver;
    private SwipesClass swipesClass;

    public LoginPage(AndroidDriver androidDriver, SwipesClass swipesClass)
    {
        this.androidDriver = androidDriver;
        this.swipesClass = swipesClass;
    }

    public void inputLogin(String login)
    {
        androidDriver.findElementById("ru.yandex.mail:id/edit_login").sendKeys(login);
    }

    public void inputPassword(String password)
    {
        androidDriver.findElementById("ru.yandex.mail:id/edit_password").sendKeys(password);
    }

    public void clickButtonNext()
    {
        androidDriver.findElementById("ru.yandex.mail:id/button_next").click();
    }

    public InboxPage clickContinue()
    {
        androidDriver.findElementById("ru.yandex.mail:id/go_to_mail_button").click();
        return new InboxPage(androidDriver, swipesClass);
    }

    public InboxPage login(String login, String password)
    {
        inputLogin(login);
        clickButtonNext();
        inputPassword(password);
        clickButtonNext();
        return clickContinue();
    }
}

package org.test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class SwipesClass
{
    private AndroidDriver androidDriver;

    public SwipesClass(AndroidDriver androidDriver)
    {
        this.androidDriver = androidDriver;
    }

    public void swipeDown()
    {
        (new TouchAction(androidDriver)).waitAction(1000).press(405,1573).moveTo(481,230).release().perform();
    }

    public void swipeUp(){
        (new TouchAction(androidDriver)).waitAction(1000).press(481,230).moveTo(405,1573).release().perform();
    }

    public void swipeLeft()
    {
        (new TouchAction(androidDriver)).press(971,1066).waitAction(1000).moveTo(115,1066).release().perform();
    }

    public void swipeRight()
    {
        (new TouchAction(androidDriver)).press(3,382).waitAction(1000).moveTo(1000,407).release().perform();
    }
}

package org.example;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class Calculator {
    public AndroidDriver<MobileElement> driver;

    @AndroidFindBy(id = "com.google.android.calculator:id/digit_1")
    private MobileElement tombolSatu;

    @AndroidFindBy(id = "com.google.android.calculator:id/digit_2")
    private MobileElement tombolDua;

    @AndroidFindBy(id = "com.google.android.calculator:id/digit_3")
    private MobileElement tombolTiga;

    @AndroidFindBy(id = "com.google.android.calculator:id/digit_4")
    private MobileElement tombolEmpat;

    @AndroidFindBy(id = "com.google.android.calculator:id/op_add")
    private MobileElement tombolTambah;

    @AndroidFindBy(id = "com.google.android.calculator:id/op_sub")
    private MobileElement tombolKurang;

    @AndroidFindBy(id = "com.google.android.calculator:id/op_mul")
    private MobileElement tombolKali;

    @AndroidFindBy(id = "com.google.android.calculator:id/op_div")
    private MobileElement tombolBagi;

    @AndroidFindBy(id = "com.google.android.calculator:id/eq")
    private MobileElement tombolSamaDengan;

    @AndroidFindBy(id = "com.google.android.calculator:id/result_final")
    private MobileElement hasil;

    public Calculator(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }



    //Method
    public void calcAdd() {
        tombolDua.click();
        tombolTambah.click();
        tombolDua.click();
        tombolSamaDengan.click();
    }

    public void calcSub() {
        tombolEmpat.click();
        tombolKurang.click();
        tombolDua.click();
        tombolSamaDengan.click();
    }

    public void calcMul(){
        tombolTiga.click();
        tombolKali.click();
        tombolEmpat.click();
        tombolSamaDengan.click();
    }

    public void calcDiv(){
        tombolEmpat.click();
        tombolBagi.click();
        tombolDua.click();
        tombolSamaDengan.click();
    }

    public String getTxtResult() {
        return hasil.getText();
    }
}

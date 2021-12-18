package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.ChoosingClothesPage;
import pages.LogInPage;
import pages.OrderHistoryPage;
import pages.PaymentPage;
import java.io.File;
import org.apache.commons.io.FileUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ChoosingClothesTest extends BaseTest{

    @Test
    public void shouldAddSweaterToCart()throws IOException {
        //the user login
        LogInPage userLogIn = new LogInPage(driver);
        userLogIn.logIn("edqmvgciosxbbrvmhz@kvhrw.com", "edqmvgciosxbbrvmhz@kvhrw.com");
        String firstLastName = "Nata Testerska";
        Assert.assertEquals(firstLastName, userLogIn.getFirstAndLastName());

        //Choosing the hummingbird printed sweater
        ChoosingClothesPage chooseClothes = new ChoosingClothesPage(driver);
        Assert.assertTrue(chooseClothes.areAnyClothesAvailable());
        chooseClothes.choosingHummingbirdPrintedSweater();

        //Checking if there is a 20% discount in the price
        double countedDiscount = chooseClothes.regularPriceInfo()*0.8;
        Assert.assertEquals(countedDiscount, chooseClothes.priceWithTwentyPercentDiscountInfo(),0.1);

        //Choosing with size "M" and quantity 5 for the sweater
        String sweaterSize = "M";
        String clothesQuantity = "5";
        chooseClothes.choosingSize(sweaterSize);
        chooseClothes.choosingQuantity(clothesQuantity);
        chooseClothes.proceedToCheckout();

        //Checking if the size and the quantity are correct(size "M" and quantity 5)
        Assert.assertEquals(sweaterSize, chooseClothes.sizeInformation());
        String checkingQuantity = clothesQuantity + " items";
        Assert.assertEquals(checkingQuantity, chooseClothes.quantityInformation());
        chooseClothes.nextProceedToCheckout();

        //Checking if we have the right address and confirming it
        PaymentPage paymentData = new PaymentPage(driver);
        String firstAndLastName = "Nata Testerska";
        String address = "Pretty Street 234";
        String zipCode = "567890";
        String city = "Edinburgh";
        String country = "United Kingdom";
        String phone = "345345621";
        String addressData = firstAndLastName+'\n'+address+'\n'+zipCode+'\n'+city+'\n'+country+'\n'+phone;
        Assert.assertEquals(addressData, paymentData.getAddressInformation());
        paymentData.confirmAddress();

        //Choosing the option "Pick up in store"
        paymentData.clickPickUpInStore();
        paymentData.clickPayByCheck();

        //Capturing a screenshot
        File purchaseProve = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(purchaseProve, new File("C:\\Users\\nata\\coderslab\\WarsztatyZadaniaZaliczeniowe_Zadanie2/purchaseProve.png"));
        System.out.println("The Screenshot is captured.");

        //Saving the sum and the order reference for the future check
        String totalOrderSumInformation = paymentData.totalOrderSumInfo();
        String orderReferenceInfo = paymentData.orderReferenceInfo();

        //Checking information on the user's order history page
        OrderHistoryPage orderHistoryPage = new OrderHistoryPage(driver);
        orderHistoryPage.goToTheCustomerInfoPage();
        String awaitingPaymentString = "Awaiting check payment";
        String orderReferenceSummaryInfo = orderHistoryPage.orderReferenceInCustomerHistoryInfo();
        String orderTotalSumSummaryInfo = orderHistoryPage.totalSumInCustomerHistoryInfo();
        Assert.assertEquals(orderReferenceInfo, "Order reference: " + orderReferenceSummaryInfo);
        Assert.assertEquals(totalOrderSumInformation, orderTotalSumSummaryInfo);
        Assert.assertEquals(awaitingPaymentString, orderHistoryPage.awaitingCheckPaymentInfo());
    }
}

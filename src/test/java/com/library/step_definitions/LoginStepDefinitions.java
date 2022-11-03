package com.cydeo.library.step_definitions;

import com.cydeo.library.pages.LoginPage;
import com.cydeo.library.utilities.BrowserUtils;
import com.cydeo.library.utilities.ConfigurationReader;
import com.cydeo.library.utilities.Driver;
import com.github.javafaker.BackToTheFuture;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LoginStepDefinitions {
    LoginPage loginPage = new LoginPage();

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }

    @When("user enter student username")
    public void user_enter_student_username() {
        loginPage.username.sendKeys("student8@library");
    }
    @When("user enter student password")
    public void user_enter_student_pasword() {
        loginPage.password.sendKeys("1DaJSz1z");
    }


    @When("user click sign in button")
    public void user_click_sign_in_button() {

        loginPage.signInButton.click();
    }

    @Then("user should be able to see the student dashboard")
    public void user_should_be_able_to_see_the_student_dashboard() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.urlContains("books"));

        String expectedResultIn = "books";
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains(expectedResultIn));
    }


    @When("user enter  librarian username")
    public void user_enter_librarian_username() {
        loginPage.username.sendKeys("librarian4@library");
    }
    @When("user enter librarian password")
    public void user_enter_librarian_pasword() {
        loginPage.password.sendKeys("3lwxJ1Kk");
    }

    @Then("user should be able to see the librarian dashboard")
    public void user_should_be_able_to_see_the_librarian_dashboard() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.urlContains("dashboard"));

        String expectedResultIn = "dashboard";
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains(expectedResultIn));
    }


    @When("user enter student username {string}")
    public void userEnterStudentUsername(String username) {
        loginPage.username.sendKeys(username);
    }

    @And("user enter student password {string}")
    public void userEnterStudentPassword(String password) {
        loginPage.password.sendKeys(password);
    }

    @When("user enter librarian username {string}")
    public void userEnterLibrarianUsername(String username) {
        loginPage.username.sendKeys(username);
    }

    @And("user enter librarian password {string}")
    public void userEnterLibrarianPassword(String password) {
        loginPage.password.sendKeys(password);
    }


    @When("user enters below credentials and click sign in button")
    public void userEntersBelowCredentialsAndClickSignInButton(Map<String ,String > credentials){

        loginPage.login(credentials.get("username"),credentials.get("password"));
    }

    @When("user enters librarian username, password and logins")
    public void userEntersLibrarianUsernamePasswordAndLogins() {
        loginPage.login("librarian4@library","3lwxJ1Kk");
    }

    @When("user enters librarian {string}, {string} and logins")
    public void userEntersLibrarianAndLogins(String username, String password) {
        loginPage.login(username, password);
    }


    @Then("user should be able to see username in the {string} section")
    public void userShouldBeAbleToSeeUsernameInTheSection(String expectedAccount)   {

    //   String actualAccount = loginPage.account.getText();

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.visibilityOf(loginPage.accountName));

        Assert.assertEquals(expectedAccount, loginPage.accountName.getText());

    }


    @And("user click {string} link")
    public void userClickLink(String string) {

        loginPage.usersLink.click();
    }

    @Then("User should see table which has below columns")
    public void user_should_see_table_which_has_below_columns(List<String > expectedColumns) {

//        List<WebElement> actualTitles = new ArrayList<>();
//
//        for (int i = 0; i < expectedColumns.size(); i++) {
//            Assert.assertEquals(expectedColumns.get(i), actualTitles.get(i).getText());
//        }
        List<String> actualColumnNames = new ArrayList<>();

        for (WebElement each : loginPage.columnNames) {
            actualColumnNames.add(each.getText());
        }

        Assert.assertEquals(expectedColumns, actualColumnNames);


        }


    @Then("librarian should be able see {string} users")
    public void librarian_should_be_able_see_users(String numberOfUsers) {


        String actualResult = loginPage.userCount.getText();
        // System.out.println(actualResult);

        Assert.assertEquals(numberOfUsers, actualResult);

    }



}






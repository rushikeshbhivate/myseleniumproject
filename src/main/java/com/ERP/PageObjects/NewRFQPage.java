package com.ERP.PageObjects;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.github.javafaker.Faker;

public class NewRFQPage {

	WebDriver driver;
	JavascriptExecutor executor;

	WebDriverWait wait;

	public NewRFQPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		executor = (JavascriptExecutor)driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@FindBy(xpath = "//input[@id=\"right\"]")
	WebElement Right;
	
	public void right()
	{
		Right.click();
	}
	
	@FindBy(xpath = "//select[@name=\"reason_id\"]")
	WebElement RFQReason;

	public void rfqReason(String value)
	{
		Select select = new Select(RFQReason);
		select.selectByVisibleText(value);
	}

	@FindBy(xpath = "//input[@name=\"oe\"]")
	WebElement OE;

	public void oe(Faker faker)
	{
		String RandomDigits = faker.number().digits(7);
		char FirstDigit = faker.options().option('9', '8', '7');
		String OeValue = "PG" + FirstDigit + RandomDigits;
		executor.executeScript("arguments[0].scrollIntoView(true);", OE);
		OE.sendKeys(OeValue);
	}

	@FindBy(xpath = "//input[@name=\"close_date\"]")
	WebElement CloseDate;

	@FindBy(xpath = "//a[@title=\"Next\"]")
	WebElement NextButton;

	@FindBy(xpath = "//table//tbody//tr[4]//td[5]")
	WebElement Date;

	public void closeDate()
	{
		CloseDate.click();
		executor.executeScript("arguments[0].click();", NextButton);
		executor.executeScript("arguments[0].click();", Date);
	}

	@FindBy(xpath = "//textarea[@id=\"description\"]")
	WebElement Description;

	public void description(String Text)
	{
		Description.sendKeys(Text);
	}

	/*public void subModel(String Value)
	{
		SubModel.click();
		boolean found = false;
		for(WebElement option: SubModelList)
		{
			if(option.getText().trim().equalsIgnoreCase(Value))
			{
				try {
					executor.executeScript("arguments[0].click();", option);
				}
				catch (Exception e) 
				{
					System.out.println("Exception While Clicking: " + e.getMessage());
				}
			}
		}
		if(!found)
		{
			throw new RuntimeException("Value '" + Value + "Not found or could not be clickable.");
		}
	}*/

	public void selectAutoSuggestion(WebElement InputField, List<WebElement> SuggestionList, String Value)
	{
		InputField.click();

		wait.until(driver -> !SuggestionList.isEmpty());
		boolean found = false;

		for(WebElement Option: SuggestionList)
		{
			if (Option.getText().trim().equalsIgnoreCase(Value)) 
			{
				try {
					executor.executeScript("arguments[0].click();", Option);
					found = true;
					break;
				}

				catch (Exception e) {
					System.out.println("Exception while clicking: " +e.getMessage());
				}
			}
		}

		if (!found) {
			throw new RuntimeException("Value '" + Value +	"' not found or could not be clickable." );
		}
	}

	@FindBy(xpath = "//input[@id=\"make_0\"]")
	WebElement PrimaryMake;

	@FindBy(xpath = "//ul[@id=\"ui-id-1\"]//li")
	List<WebElement> PrimaryMakeList;

	public void primaryMake(String Value)
	{
		selectAutoSuggestion(PrimaryMake, PrimaryMakeList, Value);
	}

	@FindBy(xpath = "//input[@id=\"model_0\"]")
	WebElement Model;

	@FindBy(xpath = "//ul[@id=\"ui-id-2\"]//li")
	List<WebElement> ModelList;
	
	public void model(String Value)
	{
		selectAutoSuggestion(Model, ModelList, Value);
	}

	@FindBy(xpath = "//input[@id=\"sub_model_0\"]")
	WebElement SubModel;

	@FindBy(xpath = "//ul[@id=\"ui-id-3\"]//li")
	List<WebElement> SubModelList;
	
	public void subModel(String Value)
	{
		selectAutoSuggestion(SubModel, SubModelList, Value);
	}

	@FindBy(xpath = "//input[@id=\"min_year_0\"]")
	WebElement MinYear;

	@FindBy(xpath = "//ul[@id=\"ui-id-4\"]//li")
	List<WebElement> MinYearList;

	public void minYear(String Value)
	{
		selectAutoSuggestion(MinYear, MinYearList, Value);
	}

	@FindBy(xpath = "//input[@id=\"max_year_0\"]")
	WebElement MaxYear;

	@FindBy(xpath = "//ul[@id=\"ui-id-5\"]//li")
	List<WebElement> MaxYearList;

	public void maxYear(String Value)
	{
		selectAutoSuggestion(MaxYear, MaxYearList, Value);
	}

	@FindBy(xpath = "//input[@id=\"usa_only\"]")
	WebElement USAOnlyCheckBox;

	public void usaOnlyCheckbox()
	{
		USAOnlyCheckBox.click();
	}

	@FindBy(xpath = "//input[@id=\"product_group_id\"]")
	WebElement ProductGroup;

	@FindBy(xpath = "//ul[@id=\"ui-id-10\"]//li")
	List<WebElement> ProductGroupList;

	public void productGroup(String Value)
	{
		selectAutoSuggestion(ProductGroup, ProductGroupList, Value);
	}

	@FindBy(xpath = "//input[@id=\"stocking_decision_id\"]")
	WebElement StockingDecision;

	@FindBy(xpath = "//ul[@id=\"ui-id-7\"]//li")
	List<WebElement> StockingDecisionList;

	public void stockingDecision(String Value)
	{
		selectAutoSuggestion(StockingDecision, StockingDecisionList, Value);
	}

	@FindBy(xpath = "//input[@id=\"style_id\"]")
	WebElement Style;

	@FindBy(xpath = "//ul[@id=\"ui-id-8\"]//li")
	List<WebElement> StyleList;

	public void style(String Value)
	{
		selectAutoSuggestion(Style, StyleList, Value);
	}

	@FindBy(xpath = "//input[@id=\"annual_forecast\"]")
	WebElement InitilalOrderQty;

	public void initialOrderQty(String Value)
	{
		InitilalOrderQty.sendKeys(Value);
	}

	@FindBy(xpath = "//input[@id=\"media_id\"]")
	WebElement Media;

	@FindBy(xpath = "/html/body/ul[11]//li")
	List<WebElement> MediaList;

	public void media(String Value)
	{
		selectAutoSuggestion(Media, MediaList, Value);
	}

	@FindBy(xpath = "//input[@id=\"qty_case\"]")
	WebElement QtyCase;

	public void qtyCase(String Value)
	{
		QtyCase.sendKeys("2");
	}

	@FindBy(xpath = "//input[@id=\"saveRfq\"]")
	WebElement Save;

	public void save()
	{
		Save.click();
	}

	@FindBy(xpath = "(//input[@type=\"radio\"])[6]")
	WebElement WantSystemAssiggnedBaseNumber;

	public void wantSystemAssignedBaseNumber()
	{
		WantSystemAssiggnedBaseNumber.click();
	}

	@FindBy(xpath = "//input[@id=\"partNoForSO\"]")
	WebElement BaseNumber;
	
	@FindBy(xpath = "(//input[@value=\"Save\"])[3]")
	WebElement SaveRFQ;
	
	public void saveRFQ()
	{
		SaveRFQ.click();
	}
	
	@FindBy(xpath = "//input[@value=\"Send RFQ\"]")
	WebElement SendRFQ;
	
	public void sendRFQ()
	{
		executor.executeScript("arguments[0].scrollIntoView(true);", SendRFQ);
		SendRFQ.click();
	}
	
	@FindBy(xpath = "//input[@value=\"188\"]")
	WebElement SupplierName;
	
	public void selectSupplier()
	{
		SupplierName.click();
	}
	
	@FindBy(xpath = "//input[@id=\"sendRfq2\"]")
	WebElement SendRFQ2;
	
	public void sendRFQ2()
	{
		SendRFQ2.click();
	}
}

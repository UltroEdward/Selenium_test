package com.manahealth.sv.ui.tests.application.pages.patients;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.manahealth.sv.ui.tests.framework.elements.IButton;
import com.manahealth.sv.ui.tests.framework.elements.ILabel;
import com.manahealth.sv.ui.tests.framework.pages.BasePage;

import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;

public class BasePatientsTablePage extends BasePage {

	private static final String LOAD_INDICATOR = "//a[contains(@class, 'logo')]";

	@FindBy(xpath = "//header//*[contains(@class, 'title')]")
	public ILabel userTitleLbl;
	@FindBy(xpath = "//div[contains(@class, 'FilterTab')]//div[contains(@class, 'pending')]")
	public IButton pendingTabBtn;
	@FindBy(xpath = "//div[contains(@class, 'FilterTab')]//div[contains(@class, 'approved')]")
	public IButton approvedTabBtn;
	@FindBy(xpath = "//div[contains(@class, 'FilterTab')]//div[contains(@class, 'denied')]")
	public IButton deniedTabBtn;

	// table header
	@FindBy(xpath = "//table//th[contains(text(), 'First Name')]")
	public ILabel firstNameLbl;
	@FindBy(xpath = "//table//th[contains(text(), 'Last Name')]")
	public ILabel lastNameLbl;;
	@FindBy(xpath = "//table//th[contains(text(), 'DOB')]")
	public ILabel dobLbl;
	@FindBy(xpath = "//table//th[contains(text(), 'Sex')]")
	public ILabel sexLbl;
	@FindBy(xpath = "//table//*[contains(text(), 'SSN')]")
	public ILabel ssnLbl;
	@FindBy(xpath = "//table//*[contains(text(), 'Address')]")
	public ILabel addressLbl;
	@FindBy(xpath = "//table//*[contains(text(), 'City')]")
	public ILabel cityLbl;
	@FindBy(xpath = "//table//*[contains(text(), 'State')]")
	public ILabel stateLbl;
	@FindBy(xpath = "//table//th[contains(text(), 'Zip')]")
	public ILabel zipLbl;

	// table rows
	@FindBy(xpath = "//table//tbody//tr")
	public List<ILabel> abstarctPatientLbl;

	// pagination
	@FindBy(xpath = "//i[contains(@class, 'Paging')]")
	public ILabel paginationLbl;
	@FindBy(xpath = "//ul[contains(@class, 'Paging')]//li[contains(@class,'next')]/*")
	public IButton paginationNextBtn;

	public BasePatientsTablePage(WebDriver driver) {
		super(driver);
		waitForPageToLoad(LOAD_INDICATOR);
		PageFactory.initElements(new HtmlElementDecorator(driver), this);
	}

	public enum TableItemsPosition {
		F_NAME(1), L_NAME(2), DOB(3), SEX(4), SSN(5), ADDRESS(6), CITY(7), STATE(8), ZIP(9);
		private int position;

		TableItemsPosition(int number) {
			this.position = number;
		}

		public int getPosition() {
			return this.position;
		}

	}

}

package com.manahealth.sv.ui.tests.application.pages.patients;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.manahealth.sv.ui.tests.framework.elements.IButton;
import com.manahealth.sv.ui.tests.framework.elements.ILabel;
import com.manahealth.sv.ui.tests.framework.pages.BasePage;

import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;

public class AbstractPatientsTablePage extends BasePage{

	private static final String LOAD_INDICATOR = "//a[contains(@class, 'logo')]";
	
	@FindBy(xpath = "//header//*[contains(@class, 'title')]")
	public ILabel userTitleLbl;
	@FindBy(xpath = "//div[contains(@class, 'FilterTab')]//div[contains(@class, 'pending')]")
	public IButton pendingTabBtn;
	@FindBy(xpath = "//div[contains(@class, 'FilterTab')]//div[contains(@class, 'approved')]")
	public IButton approvedTabBtn;
	@FindBy(xpath = "//div[contains(@class, 'FilterTab')]//div[contains(@class, 'denied')]")
	public IButton deniedTabBtn;
	
	//table header
	@FindBy(xpath = "//table//th[contains(@class, 'Mark')]")
	public ILabel markLbl;
	@FindBy(xpath = "//table//*[contains(text(), 'Name')]")
	public ILabel nameLbl;
	@FindBy(xpath = "//table//th[contains(text(), 'DOB')]")
	public ILabel dobLbl;
	@FindBy(xpath = "//table//th[contains(@class, 'Sex')]")
	public ILabel sexLbl;
	@FindBy(xpath = "//table//*[contains(@class, 'SSN')]")
	public ILabel ssnLbl;
	@FindBy(xpath = "//table//*[contains(text(), 'Address')]")
	public ILabel addressLbl;
	@FindBy(xpath = "//table//*[contains(text(), 'City')]")
	public ILabel cityLbl;
	@FindBy(xpath = "//table//*[contains(@class, 'State')]")
	public ILabel stateLbl;
	@FindBy(xpath = "//table//th[contains(@class, 'Zip')]")
	public ILabel zipLbl;

	@FindBy(xpath = "//table//*[contains(@class, 'Button')]")
	public IButton actionBtn;
	
	//table rows
	@FindBy(xpath = "//table//tbody//tr")
	public List<ILabel> abstarctPatientLbl;
	
	//pagination
	@FindBy(xpath = "//i[contains(@class, 'Paging')]")
	public ILabel paginationLbl;
	@FindBy(xpath = "//ul[contains(@class, 'Paging')]//li[contains(@class,'next')]/*")
	public IButton paginationNextBtn;

	
	public AbstractPatientsTablePage(WebDriver driver) {
		super(driver);
		waitForPageToLoad(LOAD_INDICATOR);
		PageFactory.initElements(new HtmlElementDecorator(driver), this);
	}
	
	public enum TableItems{
		NAME("1"), DOB("2"), SEX ("3"),SSN("4"), ADDRESS ("5"), CITY("6"), STATE("7"), ZIP("8"), SOURCE("9"), REQUESTER("9"), REQUESTED("10"), SUMBITTED("10"), ACTION("11");
		
		private String value;
		
		TableItems (String number){
			this.value = number;
		}
		
		public String getValue(){
			return this.value;
		}
		
	}
	
	
	
}

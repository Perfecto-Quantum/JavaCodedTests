/**
 * 
 */
package com.quantum.pages;

import com.qmetry.qaf.automation.step.QAFTestStepProvider;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.quantum.utils.DeviceUtils;
import com.quantum.utils.DriverUtils;

/**
 * @author chirag.jayswal
 *
 */
@QAFTestStepProvider
public class CalculatorPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	@FindBy(locator = "input.box")
	private QAFExtendedWebElement inputBox;

	@FindBy(locator = "btn.plus")
	private QAFExtendedWebElement btnPlus;

	@FindBy(locator = "btn.multiplication")
	private QAFExtendedWebElement btnMultiplication;

	@FindBy(locator = "btn.division")
	private QAFExtendedWebElement btnDivision;

	@FindBy(locator = "btn.minus")
	private QAFExtendedWebElement btnMinus;

	@FindBy(locator = "btn.equal")
	private QAFExtendedWebElement btnEqual;

	@FindBy(locator = "btn.clear")
	private QAFExtendedWebElement btnClear;

	@Override
	protected void openPage(PageLocator pageLocator, Object... args) {
	}
	
	public CalculatorPage()
	{
		DeviceUtils.switchToContext("NATIVE_APP");
	}
	
	public void startApp(String name)
	{
		DeviceUtils.startApp(name, "name");
	}

	public void clearCalculator() {

		btnClear.click();
	}

	public void addInto(long l1, long l2) {

		DriverUtils.getAppiumDriver().findElementByAccessibilityId(String.valueOf(l1)).click();
		btnPlus.click();
		DriverUtils.getAppiumDriver().findElementByAccessibilityId(String.valueOf(l2)).click();
		btnEqual.click();
	}

	public void resultShouldBe(long l1) {
		inputBox.verifyText("in:" + String.valueOf(l1));
	}

}

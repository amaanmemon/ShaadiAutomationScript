package page.test;

import page.actions.*;
import org.testng.annotations.Test;

public class PaymentsTest extends PaymentsActions  {

	@Test(priority = 0, groups = "")
	public void NavigatePayments() throws Exception
	{
		ShaadiTab();
	}
};


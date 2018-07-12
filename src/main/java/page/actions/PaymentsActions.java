package page.actions;

import page.objects.PaymentsObjects;
import android.shaadi.BasePageActions;

public class PaymentsActions extends BasePageActions {
	public static void ShaadiTab()
	{
	  click(PaymentsObjects.tabShaadi,"Click on Shaadi Button to view Dashboard","Payments-01");
	  click(PaymentsObjects.btnUpgradeNow,"Click on Upgrade Now Button to View Payments Page","Payments-02");
	}
}

package page.test;

import page.actions.*;
import org.testng.annotations.Test;

public class SearchTest extends SearchActions  {

	@Test(priority = 0, groups = "")
	public void Search() throws Exception
	{
		ClickGotit();
		ClickGotit();
		ClickSearch();
	}
	
	@Test(priority = 1, groups = "")
	public void MaritialStatus() throws Exception
	{
		Scroll();
		ClickMartialStatusDropdown();
		ClickNeverMarried();
		ClickApply();
	}
	
	@Test(priority = 2, groups = "")
	public void Religion() throws Exception
	{
		Scroll();
		ClickReligionDropdown();
		ClickHindu();
		ClickApply();
	}
	
	@Test(priority = 3, groups = "")
	public void MotherTongue() throws Exception
	{
		ClickMotherTongueDropdown();
		ClickHindu_MotherTongue();
		ClickApply();
		ScrollAgain();
	}
	
	@Test(priority = 4, groups = "")
	public void Community() throws Exception
	{
		ClickCommunityDropdown();
		ClickCommunityData();
		ClickApply();
	}
	
	@Test(priority = 5, groups = "")
	public void Country() throws Exception
	{
		ClickCountryDropdown();
		ClickCountryData();
		ClickApply();
		ScrollAgain();
	}
	
	@Test(priority = 6, groups = "")
	public void State() throws Exception
	{
		ClickStateDropdown();
		ClickStateData();
		ClickApply();
	}
	
	@Test(priority = 6, groups = "")
	public void Manglik() throws Exception
	{
		ScrollAgainManglik();
		ClickManglikDropdown();
		ClickManglikData();
		ClickApply();
	}
	
	@Test(priority = 7, groups = "")
	public void SearchNow() throws Exception
	{
		ScrollSearchNow();
		ClickSearchNow();
		Thread.sleep(10000);
	}
	
	@Test(priority = 8, groups = "")
	public void ConnectNow() throws Exception
	{
		ScrollProfilePage();
		VerifyProfilesCount();
		ClickConnectNow();
		Thread.sleep(15000);
	}
	
}







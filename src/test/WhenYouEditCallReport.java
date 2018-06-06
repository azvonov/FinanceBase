package components.banker.bankerCalendar.meetings_mobile;

import base.BaseTest;
import com.ubs.bpx.domainObjects.banker.Meeting;
import com.ubs.bpx.pageObject.common.menu.ActionsMenu;
import com.ubs.bpx.pageObject.components.banker.BankerBasePage;
import com.ubs.bpx.utils.DateUtils;
import com.ubs.bpx.utils.componentQuery.BpxSelenide;
import data.MeetingDataProvider;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

public class WhenYouEditCallReport extends BaseTest {

    @Description("")
    @TmsLink("CCSAD-7911")
    @Owner("@zvonovo")
    @Test(dataProviderClass = MeetingDataProvider.class, dataProvider = "userShouldBeAbleToCreateAndSaveMeeting")
    public void notificationShouldAppearWhenYouEditAndSaveCallReport(Meeting meeting) {
        meeting.setMeetingDate(DateUtils.getCurrentDate("dd MMM yyyy"));
        BankerBasePage bankerBasePage = BpxSelenide.page(ActionsMenu.class).open()
                .clickCreateMeetingLink()
                .fillCreateNewMeetingMandatoryFields(meeting)
                .setMeetingDate(meeting.getMeetingDate())
                .clickSaveButton();

    }
}

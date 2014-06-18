package advanced.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Date;

import advanced.bo.KioskService;
import advanced.DVDInfo;

public class TestClient {
    private ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:ApplicationContext.xml");
    public static void main(String args[]) {
        TestClient testClient = new TestClient();
        testClient.testUSA();
        testClient.testNL();
    }

    public void testUSA(){
        System.out.println("Test Kiosk in USA");
        String searchTitle = "2 Fast 2 Furious";

        KioskService kioskService = (KioskService)context.getBean("KioskServiceUSA");

        List<DVDInfo> result = kioskService.searchByTitle(searchTitle);
        if(result.size() == 0){
            System.out.println("Error, the DVD '2 Fast 2 Furious' should be available at location 'BUR-2'");
            return;
        }

        DVDInfo dvdInfo = result.get(0);

        int loandID = kioskService.loanDVD(dvdInfo.getId(),"j.wirth","whoknows",new Date(),"AMS-1");
        System.out.println("Loan added underNumber: " + loandID);
    }
    public void testNL(){
        System.out.println("Test Kiosk in NL");
        String searchTitle = "Phone Booth";
        KioskService kioskService = (KioskService)context.getBean("KioskServiceNL");

        List<DVDInfo> result = kioskService.searchByTitle(searchTitle);
        if(result.size() == 0){
            System.out.println("Error, the DVD 'Phone Booth' should be available at location 'AMS-1'");
            return;
        }

        DVDInfo dvdInfo = result.get(0);

        int loandID = kioskService.loanDVD(dvdInfo.getId(),"j.wirth","whoknows",new Date(),"BUR-2");
        System.out.println("Loan added underNumber: " + loandID);
    }
}

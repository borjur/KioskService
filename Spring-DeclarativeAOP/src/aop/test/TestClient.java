package aop.test;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import aop.DVDInfo;
import aop.bo.DVDStatistics;
import aop.bo.KioskService;

/**
 * <p/>
 * This component and its source code representation are copyright protected
 * and proprietary to The Trivera Group, Inc., Worldwide D/B/A Trivera Technologies
 *
 * This component and source code may be used for instructional and
 * evaluation purposes only. No part of this component or its source code
 * may be sold, transferred, or publicly posted, nor may it be used in a
 * commercial or production environment, without the express written consent
 * of the Trivera Group, Inc.
 *
 * Copyright (c) 2010 The Trivera Group, LLC.
 * http://www.triveratech.com   http://www.triveragroup.com
 * </p>
 * @author The Trivera Group Tech Team.
 */

public class TestClient {
    public static void main(String args[]) {
        TestClient testClient = new TestClient();
        testClient.test();
    }

    private static final String[] searchData = {"a", "b", "c", "d", "e",
            "f", "g", "h", "i", "j",
            "k", "l", "m", "n", "o",
            "p", "q", "r", "s", "t",
            "u", "v", "w", "x", "y",
            "z"};

    public void test() {

        ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:ApplicationContext.xml");
        KioskService kioskService = (KioskService) context.getBean("KioskService");
        System.out.println("------------------------------------");
        System.out.println("Doing random searches to test DVD stats");
        for (String title : searchData) {
            kioskService.searchByTitle(title);
        }
        Map<String, Integer> stats = DVDStatistics.getInstance().getStatistics();
        for (String key : stats.keySet()) {
            System.out.println(key + " - " + stats.get(key));
        }

        String searchTitle = "2 Fast 2 Furious";
        List<DVDInfo> result = kioskService.searchByTitle(searchTitle);
        if (result.size() == 0) {
            System.out.println("Error, the DVD '2 Fast 2 Furious' should be available at location 'BUR-2'");
            return;
        }

        DVDInfo dvdInfo = result.get(0);
        System.out.println("------------------------------------");
        kioskService.loanDVD(dvdInfo.getId(), "j.wirth", "wrongPassword", new Date(), "AMS-1");
        System.out.println("Should have shown 'wrong password' message from ThrowsAdvice");
        System.out.println("------------------------------------");
        kioskService.loanDVD(dvdInfo.getId(), "wrongName", "wrongPassword", new Date(), "AMS-1");
        System.out.println("Should have shown 'wrong name' message from ThrowsAdvice");
        System.out.println("------------------------------------");
    }

}

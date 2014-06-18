package aop.test;

import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import aop.DVDInfo;
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

    public void test() {

        ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:ApplicationContext.xml");
        KioskService kioskService = (KioskService) context.getBean("KioskService");

        String searchTitle = "2 Fast 2 Furious";
        List<DVDInfo> result = kioskService.searchByTitle(searchTitle);
        if (result.size() == 0) {
            System.out.println("Error, the DVD '2 Fast 2 Furious' should be available at location 'BUR-2'");
            return;
        }
        
        DVDInfo dvdInfo = result.get(0);
        kioskService.loanDVD(dvdInfo.getId(), "j.wirth", "wrongPassword", new Date(), "AMS-1");

    }

}

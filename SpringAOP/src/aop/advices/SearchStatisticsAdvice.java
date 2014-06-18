package aop.advices;

import java.lang.reflect.Method;
import java.util.List;

import org.springframework.aop.AfterReturningAdvice;

import aop.DVDInfo;
import aop.bo.DVDStatistics;



public class SearchStatisticsAdvice implements AfterReturningAdvice {
    private DVDStatistics dvdStatistics;

    public void setDvdStatistics(DVDStatistics dvdStatistics) {
        this.dvdStatistics = dvdStatistics;
    }

    public void afterReturning(Object result, Method method, Object[] args, Object target) throws Throwable {
        List<DVDInfo> resultData = (List<DVDInfo>)result;
        dvdStatistics.addData(resultData);
    }

}
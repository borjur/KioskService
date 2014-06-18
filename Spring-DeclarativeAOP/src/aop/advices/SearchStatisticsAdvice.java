package aop.advices;

import java.util.List;

import javax.xml.ws.soap.Addressing;

import aop.DVDInfo;
import aop.bo.DVDStatistics;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;



@Aspect
public class SearchStatisticsAdvice {
	private DVDStatistics dvdStats;

	public DVDStatistics getDvdStats() {
		return dvdStats;
	}

	public void setDvdStats(DVDStatistics dvdStats) {
		this.dvdStats = dvdStats;
	}
	
	@AfterReturning( 
			pointcut = "aop.advices.Pointcuts.inKioskSearchMethod()",
			returning = "result" 
	)
	void afterReturning(List<DVDInfo> result) {
		//TODO implement
		this.dvdStats.addData(result);
	}
}

package aop.advices;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;



@Aspect
public class Pointcuts {

	// Create the inMemberDAO() named Pointcut
	@Pointcut("execution( * aop.dao.MemberDAO.*(..) )")
	void inMemberDAO() {}

	// Create the inKioskSearchMethod() named Pointcut
	@Pointcut( "execution( * aop.bo.KioskService.search*(..) )" )
	void inKioskSearchMethod() {}
}

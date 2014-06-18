package aop.advices;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

import aop.InvalidMemberPasswordException;
import aop.UnknownMemberException;


@Aspect
public class MemberThrowsAdvice {

	// Create a method to intercept InvalidMemberPasswordException
	@AfterThrowing( 
		pointcut = "aop.advices.Pointcuts.inMemberDAO()",
		throwing = "ex"
	)
	void afterThrowing( JoinPoint joinPoint, InvalidMemberPasswordException ex ) {
		System.out.println( "Invalid Password when invoking " + methodCall2String(joinPoint) );
		System.out.println("...threw " + ex.getClass().getName() + " --- " + ex.getMessage() );
	}

	// Create a method to intercept UnknownMemberException
	@AfterThrowing( 
		pointcut = "aop.advices.Pointcuts.inMemberDAO()",
		throwing = "ex"
	)
	void afterThrowing( JoinPoint joinPoint, UnknownMemberException ex ) {
		System.out.println( "Unknown member when invoking " + methodCall2String(joinPoint) );
		System.out.println("...threw " + ex.getClass().getName() + " --- " + ex.getMessage() );
	}

    // methodCall2String
	private String methodCall2String(JoinPoint joinPoint)
	{
		Signature signature = joinPoint.getSignature();
		StringBuffer b = new StringBuffer();
		b.append(signature.getName());
		b.append("(");

		boolean firstTime = true;
		for (Object a: joinPoint.getArgs()) {
			if (!firstTime) b.append(", ");
			else firstTime = false;

			b.append(a);
		}
		b.append(")");
		return b.toString();
	}
}

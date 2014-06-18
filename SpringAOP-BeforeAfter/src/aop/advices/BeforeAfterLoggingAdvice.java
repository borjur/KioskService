package aop.advices;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.ThrowsAdvice;



public class BeforeAfterLoggingAdvice
implements MethodBeforeAdvice, AfterReturningAdvice, ThrowsAdvice
{

	public static Logger logger = Logger.getLogger("aop.advices.BeforeAfterLoggingAdvice");

	@Override
	public void before(Method method, Object[] args, Object target)
			throws Throwable {
		StringBuilder buffer = new StringBuilder();
		buffer.append("Called: ");
		buildMethodCall(buffer, target, method, args);
		output(buffer);
	}

	@Override
	public void afterReturning(Object returnVal, Method method, Object[] args,
			Object target) throws Throwable {
		StringBuilder buffer = new StringBuilder();
		buffer.append("Returned: " + returnVal );
		buildMethodCall(buffer, target, method, args);
		output(buffer);
	}

	public void afterThrowing(Method method, Object[] args, Object target, Throwable t)
	throws Throwable {
		StringBuilder buffer = new StringBuilder();
		buffer.append("Exception " + t.getClass().getName() + " thrown by " );
		buildMethodCall(buffer, target, method, args);
		output(buffer);	}
	
	
	private void buildMethodCall(StringBuilder buffer, Object target,
			Method method, Object[] args) {
		buffer.append(target.getClass().getSimpleName());
		buffer.append(".");
		buffer.append(method.getName());
		buffer.append("(");
		boolean firstArg = true;
		for( Object arg : args ) {
			if(firstArg != true) buffer.append(",");
			firstArg = false;
			boolean isString = false;
			if(arg.getClass() == String.class) isString = true;
			if(isString) buffer.append("'");
			buffer.append(arg.toString());
			if(isString) buffer.append("'");
		}
		buffer.append( ");" );
	}
	
	void output(StringBuilder buffer) { output(buffer.toString()); }

	void output(String s) { logger.debug(s); }


}

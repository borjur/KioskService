package aop.advices;

import java.lang.reflect.Method;

import org.springframework.aop.ThrowsAdvice;

import aop.InvalidMemberPasswordException;
import aop.UnknownMemberException;



public class MemberThrowsAdvice implements ThrowsAdvice {

    public void afterThrowing(Method method, Object[] args, Object target, InvalidMemberPasswordException me) {
        System.out.println("Invalid Password when invoking " + method);
        System.out.println("With params: ");
        for (Object o : args) {
            System.out.println(o);
        }
    }

    public void afterThrowing(Method method, Object[] args, Object target, UnknownMemberException me) {
        System.out.println("Unknown Member when invoking " + method);
        System.out.println("With params: ");
        for (Object o : args) {
            System.out.println(o);
        }
    }
}
package com.project.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class TraceAspect {

	//Belirttiğimiz bir metoddan önce çalışacak metod
	@Before("execution(* com.project.services.*.*(..))") //class ve metodlarında yerine de * gelecek,(..) parametresi önemli değil demek
	public void before(JoinPoint joinPoint) {
		System.out.println("Önce bu çalışacak");
		System.out.println("Çalışan Metodun Uzun Pathi =" +joinPoint.toLongString()); //hangi metodun öncesinde bunu çağırdık,uzun path
		System.out.println("Çalışan Metodun Kısa Pathi =" +joinPoint.toShortString()); //hangi metodun öncesinde bunu çağırdık,kısa path
		System.out.println("----------------------------------------");
	}
	
	//Belirttiğimiz bir metod çalışırken çalışacak metod
	//Around beforeden de önce çalışır
	@Around("execution(* com.project.services.*.*(..))") //class ve metodlarında yerine de * gelecek,(..) parametresi önemli değil demek
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("Çalışma sırasında bu çalışacak");
		System.out.println("----------------------------------------");
		Object around = joinPoint.proceed();
		return around;
	}
	
	//Belirttiğimiz bir metoddan sonra çalışacak metod
	//AfterReturning ve throwingten de sonra bu çalışır
	@After("execution(* com.project.services.*.*(..))") //class ve metodlarında yerine de * gelecek,(..) parametresi önemli değil demek
	public void after(JoinPoint joinPoint) {
		System.out.println("Sonra bu çalışacak");
		System.out.println("----------------------------------------");
	}
	
	//Belirttiğimiz bir metod başarılı bir şekilde çalıştıysa çalışacak metod
	@AfterReturning("execution(* com.project.services.*.*(..))") //class ve metodlarında yerine de * gelecek,(..) parametresi önemli değil demek
	public void afterReturning(JoinPoint joinPoint) {
		System.out.println("Düzgün çalışırsa metod bu çalışacak");
		System.out.println("----------------------------------------");
	}
	
	//Belirttiğimiz bir metod başarılı bir şekilde çalışmadıysa,excepting throwladıysa çalışacak metod
	@AfterThrowing("execution(* com.project.services.*.*(..))") //class ve metodlarında yerine de * gelecek,(..) parametresi önemli değil demek
	public void afterThrowing(JoinPoint joinPoint) {
		System.out.println("Düzgün çalışmazsa metod bu çalışacak");
		System.out.println("----------------------------------------");
	}
}

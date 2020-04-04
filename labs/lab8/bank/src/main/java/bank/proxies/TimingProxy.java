package bank.proxies;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TimingProxy implements InvocationHandler {

    Object target;

    public TimingProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        Object returnValue = method.invoke(target, args);

        stopWatch.stop();
        System.out.println("Method " + method.getName() + " took " + stopWatch.getMillis() + " ms");
        return returnValue;
    }
}

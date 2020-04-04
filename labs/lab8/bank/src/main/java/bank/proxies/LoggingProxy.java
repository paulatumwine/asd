package bank.proxies;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LoggingProxy implements InvocationHandler {

    private Object target;
    Logger logger = new Logger();

    public LoggingProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object returnValue = method.invoke(target, args);
        if (args == null) {
            logger.log("Calling method " + method.getName() + " with no arguments");
            return returnValue;
        }
        logger.log("Calling method " + method.getName() + " with argument(s):");
        for (int i = 0; i < args.length; i++) {
            logger.log(" Param[" + i + "]: " + args[i].toString());
        }
        return returnValue;
    }
}

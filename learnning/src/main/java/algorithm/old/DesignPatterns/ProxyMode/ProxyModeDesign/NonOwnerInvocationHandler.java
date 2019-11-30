package DesignPatterns.ProxyMode.ProxyModeDesign;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Isn't owner InvocationHandler
 */
public class NonOwnerInvocationHandler implements InvocationHandler {
    PersonBean person;

    public NonOwnerInvocationHandler(PersonBean person) {
        this.person = person;
    }

    /**
     * real handle method
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
       //如果方法名为get都可以调用
        if(method.getName().startsWith("get")){
            return method.invoke(person,args);
        }else if(method.getName().equals("setHotOrNotRating")){
            return method.invoke(person,args);
        }else if(method.getName().startsWith("set")){
            return new IllegalAccessException();
        }

        return null;
    }
}

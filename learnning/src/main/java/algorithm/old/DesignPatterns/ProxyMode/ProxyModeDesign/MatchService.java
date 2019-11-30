package DesignPatterns.ProxyMode.ProxyModeDesign;

import java.lang.reflect.Proxy;

public class MatchService {
    public MatchService(){
        PersonBean joe = getPersonInfo("joe","male","running");

        //test ownner proxy
        PersonBean OwnnerProxy = getOwnnerProxy(joe);

        System.out.println("Name is "+OwnnerProxy.getName());
        System.out.println("Interest is "+OwnnerProxy.getInterests());
        OwnnerProxy.setInterests("Bowling");
        System.out.println("Interest are "+ OwnnerProxy.getInterests());
        OwnnerProxy.setHotOrNotRating(50);
        System.out.println("Ranting is "+OwnnerProxy.getHotOrNotRating());
        OwnnerProxy.setHotOrNotRating(40);
        System.out.println("Ranting is "+OwnnerProxy.getHotOrNotRating());
        System.out.println("########################");

        //test non-ownner proxy
        PersonBean nonOwnnerProxy = getNonOwnnerProxy(joe);

        System.out.println("Name is "+nonOwnnerProxy.getName());
        System.out.println("Interest is "+nonOwnnerProxy.getInterests());
        nonOwnnerProxy.setInterests("hahaa");
        System.out.println("Interest are "+ nonOwnnerProxy.getInterests());
        nonOwnnerProxy.setHotOrNotRating(50);
        System.out.println("Ranting is "+OwnnerProxy.getHotOrNotRating());
    }

    PersonBean getPersonInfo(String name,String gender,String interest){
        PersonBean person = new PersonBeanImpl();
        person.setName(name);
        person.setGender(gender);
        person.setInterests(interest);
        return person;
        }

        PersonBean getOwnnerProxy(PersonBean personBean){

        return (PersonBean)Proxy.newProxyInstance(personBean.getClass().getClassLoader()
              ,personBean.getClass().getInterfaces(),new OwnnerInvocationHandler(personBean));
        }

        PersonBean getNonOwnnerProxy(PersonBean personBean){
            return (PersonBean)Proxy.newProxyInstance(personBean.getClass().getClassLoader()
                    ,personBean.getClass().getInterfaces(),new NonOwnerInvocationHandler
                            (personBean));
        }


    }




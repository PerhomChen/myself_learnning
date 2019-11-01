package java_new_feature.java8.optional;

import java_new_feature.java8.Car;

import java.util.Optional;

/**
 * @Author: Logan Chen
 * @date: 2019/10/31 10:51
 * @Description:
 */
public class optional {
    public static void main(String[] args) {
        //创建一个空的optional
        Optional<Object> optcar = Optional.empty();
        //使用静态工ԇ方法Optional.of，依据一个非空值创建一个Optional对象
        //如果car是一个null，这段代码会立即抛出错误。
        Car car = new Car("bwn",2000000.0);
        Optional<Car> optCar = Optional.of(car);
        //可接受null的Optional
        Optional<Car> oCar = Optional.ofNullable(car);

        //Optional使用filter
        Optional<Car> optInsurance = Optional.ofNullable(car);
        optInsurance.filter(insurance ->
                "CambridgeInsurance".equals(insurance.getName()))
                .ifPresent(x -> System.out.println("ok"));

        //Optional使用

    }

    //Optional的map与flatMap在遇到null值自动返回Optional.empty，无需判断。
    /*public Optional<Insurance> nullSafeFindCheapestInsurance(
            Optional<Person> person, Optional<Car> car) {
        return person.flatMap(p -> car.map(c -> findCheapestInsurance(p, c)));
    }*/

    //optional与异常
    public static Optional<Integer> stringToInt(String s) {
        try {
            //如果string能转换为对应的Integer，将其封装在Optional对象中返回
            return Optional.of(Integer.parseInt(s));
        } catch (NumberFormatException e) {
            //否则返回一个空对象。
            return Optional.empty();
        }
    }
}


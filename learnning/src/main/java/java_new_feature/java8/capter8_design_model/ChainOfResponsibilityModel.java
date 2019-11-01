package java_new_feature.java8.capter8_design_model;

import java.util.function.Function;
import java.util.function.UnaryOperator;

/**
 * @Author: Logan Chen
 * @date: 2019/10/30 16:26
 * @Description: 一种创建处理对象序列（操作序列）的通用方案。
 * 一个处理对象可能需要在完成一些工作之后，将结果传递给另一个对象。
 */
public abstract class ChainOfResponsibilityModel<T> {

    //指向 下一个责任链（节点）的方法
    protected ChainOfResponsibilityModel<T> successor;

    public void setSuccessor(ChainOfResponsibilityModel<T> successor) {
        this.successor = successor;
    }

    //整体的大概处理方法
    public T handle(T input) {
        T r = handleWork(input);
        //递归调用下一个处理方法
        if (successor != null) {
            return successor.handle(r);
        }
        return r;
    }

    //子类去实现的抽象方法，真正的处理方法
    abstract protected T handleWork(T input);
}


class HeaderTextProcessing extends ChainOfResponsibilityModel<String> {
    public String handleWork(String text) {
        return "From Raoul, Mario and Alan: " + text;
    }
}

class SpellCheckerProcessing extends ChainOfResponsibilityModel<String> {
    public String handleWork(String text) {
        return text.replaceAll("labda", "lambda");
    }
}

class TestChain {
    public static void main(String[] args) {
        ChainOfResponsibilityModel<String> c1 = new HeaderTextProcessing();
        ChainOfResponsibilityModel<String> c2 = new SpellCheckerProcessing();

        //将c1,c2链接起来
        c1.setSuccessor(c2);
        String result = c1.handle("Aren't labdas really sexy?!!");
        System.out.println(result);

        //UnaryOperator::identity接受收一个T类型参数，返回一米一样的值
        //UnaryOperator,继承于Function<T,T>，Function是接收T，返回R。而UnaryOperator接收T，返回T。可用于相同类型的修饰作业。
        UnaryOperator<String> headerProcessing =
                (String text) -> "From Raoul, Mario and Alan: " + text;
        UnaryOperator<String> spellCheckerProcessing =
                (String text) -> text.replaceAll("labda", "lambda");

        //andThen:实现责任链
        Function<String, String> pipeline =
                headerProcessing.andThen(spellCheckerProcessing);
        String ret = pipeline.apply("Aren't labdas really sexy?!!");
    }
}

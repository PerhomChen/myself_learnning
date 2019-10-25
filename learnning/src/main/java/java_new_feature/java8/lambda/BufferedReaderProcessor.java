package java_new_feature.java8.lambda;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * @Author: Logan Chen
 * @date: 2019/10/25 10:58
 * @Description:
 */
@FunctionalInterface
public interface BufferedReaderProcessor {
    String process(BufferedReader b) throws IOException;
}

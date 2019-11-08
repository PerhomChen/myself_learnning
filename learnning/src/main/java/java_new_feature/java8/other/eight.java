package java_new_feature.java8.other;


import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author: Logan Chen
 * @date: 2019/11/7 10:53
 * @Description:
 */
public class eight {
    @Test
    public void reallyFunctionalProgrammingTest() {
        List<Integer> test = Arrays.asList(1, 4, 9);
        List<List<Integer>> ret = suSets(test);
        ret.stream().forEach(System.out::println);

    }

    public static List<List<Integer>> suSets(List<Integer> list) {

        if (list.isEmpty()) {
            List<List<Integer>> ans = new ArrayList<>();
            ans.add(Collections.emptyList());
            return ans;
        }

        Integer first = list.get(0);
        List<Integer> rest = list.subList(1, list.size());

        List<List<Integer>> subans = suSets(rest);
        List<List<Integer>> subans2 = insertAll(first, subans);
        return concat(subans, subans2);
    }

    static List<List<Integer>> insertAll(Integer first,
                                         List<List<Integer>> lists) {
        List<List<Integer>> result = new ArrayList<>();
        for (List<Integer> list : lists) {
            List<Integer> copyList = new ArrayList<>();
            copyList.add(first);
            copyList.addAll(list);
            result.add(copyList);
        }
        return result;
    }

    static List<List<Integer>> concat(List<List<Integer>> a,
                                      List<List<Integer>> b) {
        List<List<Integer>> r = new ArrayList<>(a);
        r.addAll(b);
        return r;
    }


}

package java_new_feature.java8.capter4_stream;

import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * @Author: Logan Chen
 * @date: 2019/10/30 11:35
 * @Description:
 */
public class WordCounter {
    private final int counter;
    private final boolean lastSpace;

    public WordCounter(int counter, boolean lastSpace) {
        this.counter = counter;
        this.lastSpace = lastSpace;
    }


    public WordCounter accumulate(Character c) {

        //只有原先是单词然后出现空格，就算一个单词；或者原先是空格，出现一个空格。
        if (Character.isWhitespace(c)) {
            return lastSpace ? this : new WordCounter(counter, true);
        } else {
            return lastSpace ? new WordCounter(counter + 1, false) : this;
        }


    }

    public WordCounter combine(WordCounter wordCounter) {
        return new WordCounter(counter + wordCounter.counter, wordCounter.lastSpace);
    }

    public int getCounter() {
        return counter;
    }

    private static int countWords(Stream<Character> stream) {
        WordCounter wordCounter = stream.reduce(new WordCounter(0, true),
                WordCounter::accumulate,
                WordCounter::combine);
        return wordCounter.counter;
    }

    public static void main(String[] args) {
        final String SENTENCE =
                " Nel mezzo del cammin di nostra vita " +
                        "mi ritrovai in una selva oscura" +
                        " ché la dritta via era smarrita ";

        Stream<Character> stream = IntStream.range(0, SENTENCE.length())
                .mapToObj(SENTENCE::charAt);

        System.out.println("Found " + countWords(stream) + " words");

        System.out.println("----------------让流并行化---------------");

        Stream<Character> stream1 = IntStream.range(0, SENTENCE.length())
                .mapToObj(SENTENCE::charAt);

        System.out.println("Found " + countWords(stream1.parallel()) + " words");

        System.out.println("----------------使用自定义的Spliterator，让流并行化---------------");

        Spliterator<Character> spliterator = new WordCounterSpliterator(SENTENCE);
        Stream<Character> stream2 = StreamSupport.stream(spliterator,true);

        System.out.println("Found " + countWords(stream2) + " words");

        //因为原始的string在任意的位置拆分，所以有时一个词会分为两个词，然后数了两次。拆分流会影响结果，而把顺序流换成并行流可能会出错。
        //解决：确保string不是在随机位置拆开的，只能在词尾拆开，你需要为Character实现一个Spliterator。


    }


}

class WordCounterSpliterator implements Spliterator<Character> {
    private final String string;
    private int currentChar = 0;

    public WordCounterSpliterator(String string) {
        this.string = string;
    }

    //相当于迭代器
    @Override
    public boolean tryAdvance(Consumer<? super Character> action) {
        //处理当前字符串
        action.accept(string.charAt(currentChar++));
        //判断条件
        return currentChar < string.length();
    }

    @Override
    public Spliterator<Character> trySplit() {
        int currentSize = string.length() - currentChar;
        //最小拆分单位，里面顺序处理
        if (currentSize < 10) return null;
        //从待拆分字符串的一半位置开始试探，直到找到空格，找到了，递归调用。
        for (int splitPos = currentSize / 2 + currentChar; splitPos < string.length(); splitPos++) {
            if (Character.isWhitespace(string.charAt(splitPos))) {
                Spliterator<Character> spliterator = new WordCounterSpliterator(string.substring(currentChar, splitPos));
                //更新起始位置为拆分位置
                currentChar = splitPos;
                return spliterator;
            }
        }
        return null;
    }

    @Override
    public int characteristics() {
        return ORDERED + SIZED + SUBSIZED + NONNULL + IMMUTABLE;
    }

    @Override
    public long estimateSize() {
        return string.length() - currentChar;
    }
}

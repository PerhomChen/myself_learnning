package JavaBasicday_05.testGeneic;

public class Student {
    private Object javaScore;
    private Object mysqlScore;

    public Student(Object javaScore, Object mysqlScore) {
        this.javaScore = javaScore;
        this.mysqlScore = mysqlScore;
    }

    public Object getJavaScore() {
        return javaScore;
    }

    public void setJavaScore(Object javaScore) {
        this.javaScore = javaScore;
    }

    public Object getMysqlScore() {
        return mysqlScore;
    }

    public void setMysqlScore(Object mysqlScore) {
        this.mysqlScore = mysqlScore;
    }
}

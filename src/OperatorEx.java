import java.util.function.DoubleBinaryOperator;
import java.util.function.IntBinaryOperator;

public class OperatorEx {
    /*
        Operator는 Function과 마찮가지로 매개변수와 리턴값이 존재함.
        Function의 하위 인터페이스로 보통 매개변수 값을 연산하고, 그 결과를 리턴하는 경우
        사용함.

          인터페이스                 추상메서드
        BinaryOperator<T>           T apply(T t1, T t2)
        UnaryOperator<T>            T apply(T t)
        xxxBinaryOperator           xxx applyAsXXX(xxx, xxx)
        xxxUnaryOperator            xxx applyAsXXX(xxx)
     */

    static Student1[] list = {
            new Student1("홍길동", 90, 80, "컴공"),
            new Student1("이순신", 95, 70, "통계"),
            new Student1("김유신", 100, 60, "빅데이터")
    };

    public static void main(String[] args) {

        System.out.print("최대 수학 점수 : ");
        int max = maxOrMinMath((a,b) -> {
            if (a >= b) return a;
            else return b;
        });
        System.out.println(max);

        System.out.print("최소 수학 점수 : ");
        System.out.println( maxOrMinMath((a,b) -> (a <= b ? a: b)) );

        System.out.print("최대 평균 점수 : ");
        System.out.println( maxOrMinAvg((a,b) -> (a >= b ? a : b)) );

        System.out.print("최소 평균 점수 : ");
        System.out.println( maxOrMinAvg((a,b) -> (a <= b ? a : b)) );
    }

    // 두 개의 int 값을 입력하여 int값 리턴
    private static int maxOrMinMath(IntBinaryOperator op) {
        // IntBinaryOperator op = (a,b) -> {if (a >= b) return a;else return b;};
        int result = list[0].getMath();
        for (Student1 s : list) {
            result = op.applyAsInt(result, s.getMath());
        }
        return result;
    }
    // 두개의 double 값을 연산하여 double값을 리턴
    private static double maxOrMinAvg(DoubleBinaryOperator op) {
        double result = (list[0].getMath() + list[0].getEng()) / 2.0;
        for (Student1 s : list ) {
            result = op.applyAsDouble(result, (s.getMath()+s.getEng())/2.0);
        }
        return result;
    }

}

// 계산을 위한 객체 생성...
class Student1 {
    private String name;
    private int eng;
    private int math;
    private String major;

    public Student1(String name, int eng, int math, String major) {
        this.name = name;
        this.eng = eng;
        this.math = math;
        this.major = major;
    }

    // Getter
    public String getName() {
        return name;
    }

    public int getEng() {
        return eng;
    }

    public int getMath() {
        return math;
    }

    public String getMajor() {
        return major;
    }
}

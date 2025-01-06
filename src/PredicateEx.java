import java.util.function.Predicate;

public class PredicateEx {

    /*
        Predicate 함수적 인터페이스는 매개변수가 있고, 반환값이 boolean 타입으로 처리
        추상메서드가 test라는 이름으로 되어 있음.

          인터페이스             추상메서드
          Predicate<T>          boolean test(T t)
          BiPredicate<T, U>     boolean test(T t, U u)
          xxxPredicate          boolean test(xxx)

     */


    static Student1[] list = {
            new Student1("홍길동", 90, 80, "컴공"),
            new Student1("이순신", 95, 70, "통계"),
            new Student1("김유신", 100, 60, "컴공")
    };

    public static void main(String[] args) {
        // 과가 컴공인 학생의 영어 점수 평균
        double avg = avgEng(t -> t.getMajor().equals("컴공"));
        System.out.println("컴공과 영어 점수 평균 : "+ avg);

        // 과가 컴공인 학생의 수학 점수 평균
        avg = avgMath(t -> t.getMajor().equals("컴공"));
        System.out.println("컴공과 수학 점수 평균 : "+ avg);
    }

    // 영어 평균
    private static double avgEng(Predicate<Student1> predicate) {
        int sum = 0;
        int count = 0;      // predicate에서 true인 경우에 값을 카운트하기 위해서..
        for (Student1 student : list) {
            // equal 비교
            if (predicate.test(student)) {
                count++;
                sum += student.getEng();
            }
        }
        return (double) sum/count;
    }

    // 수학 평균
    private static double avgMath(Predicate<Student1> predicate) {
        int sum = 0;
        int count = 0;
        for (Student1 student : list) {
            if (predicate.test(student)) {
                count++;
                sum += student.getMath();
            }
        }
        return (double) sum/count;
    }
}

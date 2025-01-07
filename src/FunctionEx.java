import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;

public class FunctionEx {

    /*
       Function 인터페이스는 매개변수와 리턴값이 모두 있는 추상 메서드 apply를 가지고 있음.
       Function 인터페이스는 주로 매개변수로 받은 값을 리턴값으로 매핑하여 사용.

         인터페이스              추상메서드
         Function<T, R>         R apply(T t)
         BiFunction<T, U, R>    R apply(T t, U u)
         xxxFunction<R>         R apply(xxx x)
         xxxToyyyFunction       yyy applyAs(yyy)(xxx x) ex)double applyAsDouble(int x)
         ToxxxBiFunction<T,U>   xxx applyAsxxx(T t, U u)
         ToxxxFunction<T>       xxx applyAsxxx(T t)

     */

    static Student[] list = {
            new Student("홍길동", 20,"2024010655","컴공"),
            new Student("이순신", 28, "2024010656","통계")
    };

    public static void main(String[] args) {
        System.out.print("학생명 : ");
        // 학생 이름을 출력하는 함수 생성...
        printString(t -> t.getName());
        // 전공
        System.out.print("전공 : ");
        printString(t -> t.getMajor());
        // 학번
        System.out.print("학번 : ");
        printString(t -> t.getStudentID());
        // 나이 출력
        System.out.print("나이 : ");
        printInt(t -> t.getAge());
        // 나이 합계
        System.out.print("나이 합계 : ");
        printTot(t -> t.getAge());
        // 나이 평균
        System.out.print("나이 평균 : ");
        printAvg(t -> t.getAge());
        printAvg();
    }

    // 나이의 평균2
    static void printAvg() {
        ToDoubleFunction<Student> f = t -> t.getAge();
        double sum = 0.0;
        for (Student s : list) {
            sum += f.applyAsDouble(s);
        }
        System.out.println(sum/list.length);
    }

    // 나이의 평균1
    static void printAvg(ToDoubleFunction<Student> f) {
        double sum = 0;
        for (Student s : list) {
            sum += f.applyAsDouble(s);
        }
        System.out.println(sum/list.length);
    }
    // 나이의 합
    static void printTot(ToIntFunction<Student> f) {
        int sum = 0;
        for (Student s : list) {
            sum += f.applyAsInt(s);
        }
        System.out.println(sum);
    }

    // 정수 출력하는 함수
    static void printInt(Function<Student, Integer> f) {
        for (Student s : list) {
            System.out.print(f.apply(s)+" ");
        }
        System.out.println();
    }

    // 문자열을 출력하는 함수
    // Function<Student, String> = student -> {student.getName}
    static void printString(Function<Student, String> f) {
        for (Student s : list) {
            System.out.print(f.apply(s)+" ");
        }
        System.out.println();
    }

}


class Student {
    // 필드
    String name;
    int age;
    String major;
    String studentID;

    // 생성자
    Student(String name, int age, String studentID ,String major) {
        this.name = name;
        this.age = age;
        this.studentID = studentID;
        this.major = major;
    }

    //getter
    public String getName() {return name;}
    public int getAge() {return age;}
    public String getMajor() {return major;}
    public String getStudentID() {return studentID;}
    //setter
    public void setName(String name) {this.name = name;}
    public void setAge(int age) {this.age = age;}
    public void setMajor(String major) {this.major = major;}
    public void setStudentID(String studentID) {this.studentID = studentID;}
}
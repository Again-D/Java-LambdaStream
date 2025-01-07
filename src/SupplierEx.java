import java.util.function.DoubleSupplier;
import java.util.function.IntSupplier;
import java.util.function.Supplier;

public class SupplierEx {

    /*
        Supplier 함수적 인터페이스 : 매개변수 x , 반환값은 있음...
         인터페이스              추상메서드
        - Supplier<T>           T get()
        - BooleanSupplier       boolean getAsBoolean()
        - DoubleSupplier        double getAsDouble()
        - IntSupplier           int getAsInt()
        - LongSupplier          long getAsLong()
     */

    public static void main(String[] args) {
        Supplier<String> s1 = () -> {
            return "홍길동";
        };
        System.out.println(s1.get());

        s1 = () -> "이순신";
        System.out.println(s1.get());

        IntSupplier s2 = () -> {
            int num = (int)(Math.random() * 10)+1;
            return num;
        };
        System.out.println("1 ~ 10 사이 숫자 : " +s2.getAsInt());
        DoubleSupplier s3 = () -> Math.PI;
        System.out.println("원주율 값 : "+s3.getAsDouble());

    }
}

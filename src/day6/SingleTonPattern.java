package day6;

/**
 * 싱글톤 패턴 구현하기
 *
 * 단 하나의 인스턴스만 존재할 수 있는 클래스 SingletonPattern 을 구현하시오.
 *
 * 생성자를 외부에서 직접 호출할 수 없다.
 * 정적 메소드인 getInstance() 메소드를 이용해 객체를 받아온다.
 * 받아온 객체는 항상 같은 객체를 참조해야 한다.
 */
public class SingleTonPattern {

    private static SingleTonPattern singleTonPattern = null;

    private SingleTonPattern() {}

    public static SingleTonPattern getInstance() {
        if (singleTonPattern == null) {
            singleTonPattern = new SingleTonPattern();
        }
        return singleTonPattern;
    }
}

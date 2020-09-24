package day13;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntUnaryOperator;

/**
 * 열거형 타입과 함수형 프로그래밍을 이용하여 플레이어의 공격력을 계산하는 알고리즘을 구현하시오.
 * 플레이어 공격력을 계산하는 과정은 아래와 같다.
 * 1. 플레이어의 무기에 따라 공격력이 변화한다. 무기는 최근에 장착한 무기의 공격력 만으로 계산된다.
 * 1-1. BARE_HANDS - 공격력 5
 * 1-2. DAGGER - 공격력 40
 * 1-3. LONG_SWORD - 공격력 100
 * 1-4. DRAGON_SLAYER -  공격력 250
 * 2. 플레이어의 공격력에 영향을 주는 아이템에 따라 공격력 증가 방식이 다르며, 아이템은 중복 적용된다.
 * 2-1. BLACK_POTION - 공격력 10% 증가
 * 2-2. WHITE_POTION - 모든 공격력 계산이 끝난 후에 공격력 + 200
 * 2-3. MUSHROOM - 무기 공격력 + 20
 */

enum Weapon {
    BARE_HANDS(5), DAGGER(40), LONG_SWORD(100), DRAGON_SLAYER(250);

    private int damage;

    Weapon(int damage) {
        this.damage = damage;
    }

    int getWeaponAttack() {
        return damage;
    }

}

enum Item {
    MUSHROOM(value -> value + 20, 0), BLACK_POTION(value -> (int) (value * 1.1), 1),WHITE_POTION(value -> value + 200, 2);

    private final IntUnaryOperator op;
    private final int priority;

    Item(IntUnaryOperator op, int priority) {
        this.op = op;
        this. priority = priority;
    }

    public IntUnaryOperator getOp() {
        return op;
    }

    public int getPriority() {
        return priority;
    }
}

class Player {
    private String name;
    private Weapon weapon = Weapon.BARE_HANDS;
    private List<Item> usingItems = new ArrayList<>();

    public Player(String name) {
        this.name = name;
    }

    void takeWeapon(Weapon weapon) {
        this.weapon = weapon;
        System.out.println(this.name + "이(가) " + weapon + " 을 장착했습니다.");
        System.out.println();
    }

    void useItem(Item item) {
        usingItems.add(item);
        System.out.println(this.name + "이(가) " + item + " 을 사용했습니다.");
        System.out.println();
    }

    void endItemEffect(Item item) {
        if (usingItems.contains(item)) {
            usingItems.remove(item);
            System.out.println(this.name + "의 " + item + " 의 지속시간이 끝났습니다.");
            System.out.println();
        } else {
            System.out.println("사용중인 아이템이 아닙니다.");
            System.out.println();
        }
    }

    public int getDamage() {
        usingItems.sort((o1, o2) -> o1.getPriority() - o2.getPriority());
        IntUnaryOperator op = value -> value;
        for (Item item: usingItems) {
            op = op.andThen(item.getOp());
        }
        return op.applyAsInt(weapon.getWeaponAttack());
    }

    void printAttack() {
        System.out.println(name + "의 현재상태");
        System.out.println("--------------------------");
            System.out.println("장착 무기: " + weapon);
        if (usingItems.isEmpty()) {
            System.out.println("사용중인 아이템: 없음");
        } else {
            System.out.println("사용중인 아이템: " + usingItems);
        }
        System.out.println(name + "의 공격력: " + getDamage());
        System.out.println("--------------------------");
        System.out.println();
    }
}

public class DamageCalculation {
    public static void main(String[] args) {
        Player player1 = new Player("홍길동");
        player1.takeWeapon(Weapon.DRAGON_SLAYER);
        player1.useItem(Item.BLACK_POTION);
        player1.useItem(Item.MUSHROOM);
        player1.useItem(Item.WHITE_POTION);
        player1.printAttack();

        player1.endItemEffect(Item.BLACK_POTION);
        player1.takeWeapon(Weapon.BARE_HANDS);
        player1.printAttack();
    }
}
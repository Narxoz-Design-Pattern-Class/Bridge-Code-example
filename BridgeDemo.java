// The Implementor
interface Enchantment {
    void onActivate();
    void applyEffect();
}

// Concrete Implementor #1
class FireEnchantment implements Enchantment {
    @Override
    public void onActivate() {
        System.out.println("The weapon glows with a fiery aura.");
    }

    @Override
    public void applyEffect() {
        System.out.println("Burning effect: extra fire damage!");
    }
}

// Concrete Implementor #2
class IceEnchantment implements Enchantment {
    @Override
    public void onActivate() {
        System.out.println("The weapon is chilled by an icy aura.");
    }

    @Override
    public void applyEffect() {
        System.out.println("Freezing effect: chance to slow the enemy!");
    }
}

// The Abstraction
abstract class Weapon {
    protected Enchantment enchantment;

    public Weapon(Enchantment enchantment) {
        this.enchantment = enchantment;
    }

    public abstract void attack();
}

// A Refined Abstraction #1
class Sword extends Weapon {
    public Sword(Enchantment enchantment) {
        super(enchantment);
    }

    @Override
    public void attack() {
        System.out.println("Swinging sword...");
        enchantment.onActivate();
        enchantment.applyEffect();
    }
}

// A Refined Abstraction #2
class Bow extends Weapon {
    public Bow(Enchantment enchantment) {
        super(enchantment);
    }

    @Override
    public void attack() {
        System.out.println("Shooting an arrow...");
        enchantment.onActivate();
        enchantment.applyEffect();
    }
}

// Demo
public class BridgeDemo {
    public static void main(String[] args) {
        Weapon fireSword = new Sword(new FireEnchantment());
        fireSword.attack();

        System.out.println();

        Weapon iceBow = new Bow(new IceEnchantment());
        iceBow.attack();
    }
}

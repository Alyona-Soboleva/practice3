package part5.part5_1;

public abstract class Herbivore extends Animal {
    protected Herbivore(String name, int age, double weight, int energyLevel) {
        super(name, age, weight, energyLevel);
    }

    public void graze() {
        // TODO: +15 к energyLevel (макс 100).
        // ▼ ВАШ КОД ЗДЕСЬ ▼
        int newEnergy = energyLevel + 15;
        if (newEnergy > 100) {
            newEnergy = 100;
        }
        energyLevel = newEnergy;

        System.out.println(name + " пасётся! Энергия: " + energyLevel);
        // ▲ КОНЕЦ ВАШЕГО КОДА ▲
    }
}

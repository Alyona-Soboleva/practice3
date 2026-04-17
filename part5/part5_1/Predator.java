package part5.part5_1;

public abstract class Predator extends Animal {
    protected Predator(String name, int age, double weight, int energyLevel) {
        super(name, age, weight, energyLevel);
    }

    public void hunt() {
        // TODO: +30 к energyLevel (макс 100), weight -= 0.5.
        // ▼ ВАШ КОД ЗДЕСЬ ▼
        int newEnergy = energyLevel + 30;
        if (newEnergy > 100) {
            newEnergy = 100;
        }
        energyLevel = newEnergy;

        weight -= 0.5;
        if (weight < 0) {
            weight = 0;
        }

        System.out.println(name + " охотился! Энергия: " + energyLevel + ", Вес: " + weight);
        // ▲ КОНЕЦ ВАШЕГО КОДА ▲
    }
}

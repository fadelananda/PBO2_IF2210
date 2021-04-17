package entities.engimon;

public class Beckoo extends Engimon {
    public Beckoo() {
        this.setName("Wild Beckoo");

    }

    public Beckoo(String name, int x, int y) {
        super(name, x, y);
    }

    @Override
    public void showAura() {

    }

    @Override
    public String getSpeciesName() {
        return "Beckoo";
    }

    @Override
    public void showDescription() {

    }
}

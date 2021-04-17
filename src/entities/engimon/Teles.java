package entities.engimon;

public class Teles extends Engimon {
    public Teles() {
        this.setName("Wild Teles");
    }

    public Teles(String name, int x, int y) {
        super(name, x, y);
    }

    @Override
    public void showAura() {

    }

    @Override
    public String getSpeciesName() {
        return "Teles";
    }

    @Override
    public void showDescription() {

    }
}

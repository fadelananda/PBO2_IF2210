package entities.engimon;

public class Gledek extends Engimon {
    public Gledek() {
        this.setName("Wild Gledek");
    }

    public Gledek(String name, int x, int y) {
        super(name, x, y);
    }

    @Override
    public void showAura() {

    }

    @Override
    public String getSpeciesName() {
        return "Gledek";
    }

    @Override
    public void showDescription() {

    }
}

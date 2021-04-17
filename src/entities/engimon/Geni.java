package entities.engimon;

public class Geni extends Engimon {
    public Geni() {
        this.setName("Wild Geni");
    }

    public Geni(String name, int x, int y) {
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

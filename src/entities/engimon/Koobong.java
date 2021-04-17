package entities.engimon;

public class Koobong extends Engimon {
    public Koobong() {
        this.setName("Wild Koobong");
    }

    public Koobong(String name, int x, int y) {
        super(name, x, y);
    }

    @Override
    public void showAura() {

    }

    @Override
    public String getSpeciesName() {
        return "Koobong";
    }

    @Override
    public void showDescription() {

    }
}

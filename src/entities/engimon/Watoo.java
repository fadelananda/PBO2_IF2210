package entities.engimon;

public class Watoo extends Engimon{
    public Watoo() {
        this.setName("Wild Watoo");
    }

    public Watoo(String name, int x, int y) {
        super(name, x, y);
    }

    @Override
    public void showAura() {

    }

    @Override
    public String getSpeciesName() {
        return "Watoo";
    }

    @Override
    public void showDescription() {

    }
}

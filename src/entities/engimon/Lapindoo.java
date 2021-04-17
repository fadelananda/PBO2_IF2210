package entities.engimon;

public class Lapindoo extends Engimon{
    public Lapindoo() {
        this.setName("Wild Lapindoo");
    }

    public Lapindoo(String name, int x, int y) {
        super(name, x, y);
    }

    @Override
    public void showAura() {

    }

    @Override
    public String getSpeciesName() {
        return "Lapindoo";
    }

    @Override
    public void showDescription() {

    }
}

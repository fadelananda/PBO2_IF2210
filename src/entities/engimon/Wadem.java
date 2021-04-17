package entities.engimon;

public class Wadem extends Engimon{
    public Wadem() {
        this.setName("Wild Wadem");
    }

    public Wadem(String name, int x, int y) {
        super(name, x, y);
    }

    @Override
    public void showAura() {

    }

    @Override
    public String getSpeciesName() {
        return "Wadem";
    }

    @Override
    public void showDescription() {

    }
}

package it.eracle.ogamebot.it.eracle.ogamebot.buildings;

/**
 * In MVC Paradigm, is a Model class.
 * Represent the possibility to construct a MetalMine.
 * Created by eracle on 06/08/15.
 */
public class MetalMineConstruction {

    //TODO: switch from seconds to date?
    /**
     * number of seconds to produce the Building.
     */
    private int production_duration;

    /** energy needed for full production*/
    private int energy_needed;

    /** metal needed for construction*/
    private int metal_required;

    /** crystal needed for construction*/
    private int crystal_required;

    /** deuterium needed for construction*/
    private int deuterium_required;


    public MetalMineConstruction(int production_duration, int energy_needed, int crystal_required, int metal_required, int deuterium_required) {
        this.production_duration = production_duration;
        this.energy_needed = energy_needed;
        this.crystal_required = crystal_required;
        this.metal_required = metal_required;
        this.deuterium_required = deuterium_required;
    }

    public int getProduction_duration() {
        return production_duration;
    }

    public int getEnergy_needed() {
        return energy_needed;
    }

    public int getMetal_required() {
        return metal_required;
    }

    public int getCrystal_required() {
        return crystal_required;
    }

    @Override
    public String toString() {
        return "MetalMineConstruction{" +
                "production_duration=" + production_duration +
                ", energy_needed=" + energy_needed +
                ", metal_required=" + metal_required +
                ", crystal_required=" + crystal_required +
                ", deuterium_required=" + deuterium_required +
                '}';
    }

    public int getDeuterium_required() {
        return deuterium_required;
    }
}


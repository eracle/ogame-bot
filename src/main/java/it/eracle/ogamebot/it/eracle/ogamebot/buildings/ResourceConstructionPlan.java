package it.eracle.ogamebot.it.eracle.ogamebot.buildings;

/**
 * Is the abstract class of a generic plan of construction of a resource generator building. For instance Metal mine, crystal mine...
 * Created by eracle on 07/08/15.
 */
public abstract class ResourceConstructionPlan {

    /**
     * metal needed for construction
     */
    protected int metal_required;
    /**
     * crystal needed for construction
     */
    protected int crystal_required;
    /**
     * deuterium needed for construction
     */
    protected int deuterium_required;

    //TODO: switch from seconds to date?
    /**
     * number of seconds to produce the Building.
     */
    protected int production_duration;
    /**
     * energy needed for full production
     */
    protected int energy_needed;


    public ResourceConstructionPlan(int production_duration, int deuterium_required, int energy_needed, int metal_required, int crystal_required) {
        this.production_duration = production_duration;
        this.deuterium_required = deuterium_required;
        this.energy_needed = energy_needed;
        this.metal_required = metal_required;
        this.crystal_required = crystal_required;
    }

    public int getMetal_required() {
        return metal_required;
    }

    public int getCrystal_required() {
        return crystal_required;
    }

    public int getDeuterium_required() {
        return deuterium_required;
    }

    public int getProduction_duration() {
        return production_duration;
    }

    public int getEnergy_needed() {
        return energy_needed;
    }


}

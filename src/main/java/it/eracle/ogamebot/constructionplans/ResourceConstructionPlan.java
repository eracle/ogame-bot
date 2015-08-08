package it.eracle.ogamebot.constructionplans;

/**
 * Is the abstract class of a generic plan of construction of a resource generator building. For instance Metal mine, crystal mine...
 * Created by eracle on 07/08/15.
 */
public abstract class ResourceConstructionPlan {



    /** Name of the building*/
    protected String building_name;

    /** Building level*/
    protected int building_level;

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


    @Override
    public String toString() {
        return "ResourceConstructionPlan{" +
                "building_level=" + building_level +
                ", metal_required=" + metal_required +
                ", crystal_required=" + crystal_required +
                ", deuterium_required=" + deuterium_required +
                ", production_duration=" + production_duration +
                ", energy_needed=" + energy_needed +
                '}';
    }

    public int getBuilding_level() {
        return building_level;
    }

    public void setBuilding_level(int building_level) {
        this.building_level = building_level;
    }

    public ResourceConstructionPlan() {

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

    public void setMetal_required(int metal_required) {
        this.metal_required = metal_required;
    }

    public void setCrystal_required(int crystal_required) {
        this.crystal_required = crystal_required;
    }

    public void setDeuterium_required(int deuterium_required) {
        this.deuterium_required = deuterium_required;
    }

    public void setProduction_duration(int production_duration) {
        this.production_duration = production_duration;
    }

    public void setEnergy_needed(int energy_needed) {
        this.energy_needed = energy_needed;
    }

    public int getProduction_duration() {
        return production_duration;
    }

    public int getEnergy_needed() {
        return energy_needed;
    }
    public String getBuilding_name() {
        return building_name;
    }

    public void setBuilding_name(String building_name) {
        this.building_name = building_name;
    }

}

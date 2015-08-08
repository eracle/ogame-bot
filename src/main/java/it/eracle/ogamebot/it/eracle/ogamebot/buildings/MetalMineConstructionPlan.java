package it.eracle.ogamebot.it.eracle.ogamebot.buildings;

/**
 * In MVC Paradigm, is a Model class.
 * Represent the possibility to construct a MetalMine.
 * Created by eracle on 06/08/15.
 */
public class MetalMineConstructionPlan extends ResourceConstructionPlan{

    public MetalMineConstructionPlan(int production_duration, int energy_needed, int crystal_required, int metal_required, int deuterium_required) {
        super(production_duration, deuterium_required, energy_needed, metal_required, crystal_required);
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

}


package TP1;

public class PreciousStone {
  // Required arguments
  private String species; /* beryl */
  private String variety; /* emerald aquamarine heliodor morganite etc */
  
  // Optional arguments
  private double refractiveIndex = 1.77;
  private double weight = 0.3;
  private int hardness = 8; /* entre 1 et 10 */
  private String cleavage = "octahedral"; /* basal, pinacoidal, cubic planar, octahedral, dodecahedral etc */
  private boolean inclusions = false;
  private int water = 1; /* 1, 2, 3 */

  private PreciousStone(Builder builder) {
    this.refractiveIndex = builder.refractiveIndex;
    this.weight = builder.weight;
    this.hardness = builder.hardness;
    this.cleavage = builder.cleavage;
    this.inclusions = builder.inclusions;
    this.water = builder.water;
    this.species = builder.species;
    this.variety = builder.variety;
  }

  public String getSpecies() {
    return species;
  }


  public String getVariety() {
    return variety;
  }


  public double getRefractiveIndex() {
    return refractiveIndex;
  }


  public double getWeight() {
    return weight;
  }


  public int getHardness() {
    return hardness;
  }


  public String getCleavage() {
    return cleavage;
  }


  public boolean isInclusions() {
    return inclusions;
  }


  public int getWater() {
    return water;
  }


  public static class Builder {
    private String species; /* beryl */
    private String variety; /* emerald aquamarine heliodor morganite etc */
    
    // Optional arguments
    private double refractiveIndex = 1.77;
    private double weight = 0.3;
    private int hardness = 8; /* entre 1 et 10 */
    private String cleavage = "octahedral"; /* basal, pinacoidal, cubic planar, octahedral, dodecahedral etc */
    private boolean inclusions = false;
    private int water = 1; /* 1, 2, 3 */

    public Builder(String species, String variety) {
      this.species = species;
      this.variety = variety;
    }
    public Builder refractiveIndex(double val) {
      refractiveIndex = val;
      return this;
    }
    public Builder weight(double val) {
      weight = val;
      return this;
    }

    public Builder hardness(int val) {
        hardness = val;
        return this;
    }

    public Builder cleavage(String val) {
        cleavage = val;
        return this;
    }

    public Builder inclusions(boolean val) {
        inclusions = val;
        return this;
    }

    public Builder water(int val) {
        water = val;
        return this;
    }

    public PreciousStone build() {
      // Multiple field checks, e.g.
      if(!(this.water >= 0 && this.water <= 3)) {
        throw new IllegalArgumentException("Arguments not valid");
      }
      return new PreciousStone(this);
    }
  }
}

package dndhelper.entity.enums;

public enum ClassEnum {
  ARTIFICER("Artificer"),
  BARARIAN("Barbarian"),
  BARD("Bard"),
  BLOODFIGHTER("Blood Hunter"),
  CLERIC("Cleric"),
  DRUID("Druid"),
  FIGHTER("Fighter"),
  MONK("Monk"),
  PALADIN("Paladin"),
  RANGER("Ranger"),
  ROGUE("Rogue"),
  SORCERER("Sorcerer"),
  WARLOCK("Warlock"),
  WIZARD("Wizard");

    private final String dndClass;

    private ClassEnum(String dndClass) {
        this.dndClass = dndClass;
    }

    public String getDndClass() {
        return dndClass;
    }

}

package dndhelper.entity.enums;

public enum RaceEnum {

	AASIMAR("Aasimar"),
	DRAGONBORN("Dragonborn"),
	MOUNTAINDWARF("Mountain Dwarf"),
	HILLDWARF("Hill Dwarf"),
	DUERGAR("Duergar"),
	HIGHELF("High Elf"),
	WOODELF("Wood Elf"),
	DROW("Drow"),
	DEEPGNOME("Deep Gnome"),
	FORESTGNOME("Forest Gnome"),
	ROCKGNOME("Rock Gnome"),
	HALFELF("Half-Elf"),
	HALFORC("Half-Orc"),
	GHOSTWISEHALFLING("Ghostwise Halfling"),
	LIGHTFOOTHALFLING("Lightfoot Halfling"),
	STOUTHALFLING("Stout Halfling"),
	HUMAN("Human"),
	KENKU("Kenku"),
	TIEFLING("Tiefling"),
	TORTLE("Tortle");


    private final String race;

    private RaceEnum(String race) {
        this.race = race;
    }

    public String getRace() {
        return race;
    }

}


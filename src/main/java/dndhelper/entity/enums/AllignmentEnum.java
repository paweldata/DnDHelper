package dndhelper.entity.enums;

public enum AllignmentEnum {

	LAWFULLGOOD("Lawful Good", "Lawful Good"),
	NEUTRALGOOD("Neutral Good", "Neutral Good"),
	CHAOTICGOOD("Chaotic Good", "Chaotic Good"),
	LAWFULLNEUTRAL("Lawful Neutral", "Lawful Neutral"),
	NEUTRAL("Neutral", "Neutral"),
	CHAOTICNEUTRAL("Chaotic Neutral", "Chaotic Neutral"),
	LAWFULLEVIL("Lawful Evil", "Lawful Evil"),
	NEUTRALEVIL("Neutral Evil", "Neutral Evil"),
	CHAOTICEVIL("Chaotic Evil", "Chaotic Evil");

    private final String fullName;
    private final String shortName;

    private AllignmentEnum(String fullName, String shortName) {
        this.fullName = fullName;
        this.shortName = shortName;
    }

    public String getFullName() {
        return fullName;
    }

    public String getShortName() {
        return shortName;
    }

}

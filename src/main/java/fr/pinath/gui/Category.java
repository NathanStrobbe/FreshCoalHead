package fr.pinath.gui;

public enum Category {
    FOOD("food", "Food's Head"),
    DEVICES("devices", "Devices' Head"),
    MISC("misc", "Miscellaneous' Head"),
    ALPHABET("alphabet", "Alphabet's Head"),
    INTERIOR("interior", "Interior's Head"),
    COLOR("color", "Color's Head"),
    BLOCKS("blocks", "Blocks' Head"),
    GAMES("games", "Games' Head"),
    MOBS("mobs", "Mobs' Head"),
    CHARACATERS("characters", "Characters' Head"),
    POKEMON("pokemon", "Pokemon's Head");

    private String query;
    private String title;

    Category(String query, String title) {
        this.query = query;
        this.title = title;
    }

    public String getQuery() {
        return query;
    }

    public String getTitle() {
        return title;
    }
}


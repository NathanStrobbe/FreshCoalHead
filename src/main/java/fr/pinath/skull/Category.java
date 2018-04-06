package fr.pinath.skull;

public enum Category {
    FOOD("food", "Food's Head", new Skull("Food", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjkxMzY1MTRmMzQyZTdjNTIwOGExNDIyNTA2YTg2NjE1OGVmODRkMmIyNDkyMjAxMzllOGJmNjAzMmUxOTMifX19")),
    DEVICES("devices", "Devices' Head", new Skull("Devices", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOGFlNTJhZThjOThhYzE5ZmQwNzYzN2E0NjlmZmEyNTZhYjBiM2IxMGVjZTYyNDMxODYxODhiYTM4ZGYxNTQifX19")),
    MISC("misc", "Miscellaneous' Head", new Skull("Miscellaneous", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzBkMjI3YjMzMjY1OTZjYjkyZTY4MWE0NDVkYzk5ZDRjNjk2NWYxMWE4MDg2YWVlNjJkZGYwOWI3NzViIn19fQ==")),
    ALPHABET("alphabet", "Alphabet's Head", new Skull("Alphabet", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzMzYWEyNDkxNmM4ODY5NmVlNzFkYjdhYzhjZDMwNmFkNzMwOTZiNWI2ZmZkODY4ZTFjMzg0YjFkNjJjZmIzYyJ9fX0=")),
    INTERIOR("interior", "Interior's Head", new Skull("Interior", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTMxODRkNmFkNGEwZTE1YjNhNzFkYWRmNDVmNmM3Y2U5ZWM5NjE3MmJjOWZmMjVmZDNhZjc4N2EzNzliZDEifX19")),
    COLOR("color", "Color's Head", new Skull("Color", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzE0ODJiNzU1ODU4NjU3ZmI1MWI3ZDNmYmY0Y2Q4YzA5MGMwNWUzNWJkOGNkYmE5OGIxOTQ5OWQ3ODMzYWNiMiJ9fX0=")),
    BLOCKS("blocks", "Blocks' Head", new Skull("Block", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzQ5YzYzYmM1MDg3MjMzMjhhMTllNTk3ZjQwODYyZDI3YWQ1YzFkNTQ1NjYzYWMyNDQ2NjU4MmY1NjhkOSJ9fX0=")),
    GAMES("games", "Games' Head", new Skull("Game", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOGU0YTcwYjdiYmNkN2E4YzMyMmQ1MjI1MjA0OTFhMjdlYTZiODNkNjBlY2Y5NjFkMmI0ZWZiYmY5ZjYwNWQifX19")),
    MOBS("mobs", "Mobs' Head", new Skull("Mob", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDE4OGM5ODBhYWNmYTk0Y2YzMzA4ODUxMmIxYjk1MTdiYTgyNmIxNTRkNGNhZmMyNjJhZmY2OTc3YmU4YSJ9fX0=")),
    CHARACATERS("characters", "Characters' Head", new Skull("Character", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNmY3ZWI3NWU1NTQyY2M0OTM3YWFhZDViYjg2NTczOTNlYWYwMjY1MDA2ZWFjMWRjOTY2OTFmMzJlMTY0MzcifX19")),
    POKEMON("pokemon", "Pokemon's Head", new Skull("Pokemon", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZGZhNjk1YjU5NjE4YjM2MTZiNmFhYTkxMGM1YTEwMTQ2MTk1ZWRkNjM2N2QyNWU5Mzk5YTc0Y2VlZjk2NiJ9fX0="));

    private String query;
    private String title;
    private Skull skull;

    Category(String query, String title, Skull skull) {
        this.query = query;
        this.title = title;
        this.skull = skull;
    }

    public String getQuery() {
        return query;
    }

    public String getTitle() {
        return title;
    }

    public Skull getSkull() {
        return skull;
    }
}


/*
CS5010 Module 3 Lab - Building Dungeons
Wing Man, Kwok
Nov 24 2022

To construct a level in a game that is set in a medieval fantasy.
This class will be used to not only build a level for a game, but it will also ensure that all of the details of the game
are consistent.
 */
package dungeon;

public class MedievalLevelBuilder {
    /**
     * Constructor for the level builder.
     *
     * @param numOfRoom         index number of a room
     * @param numOfMonster      quantity of monster
     * @param numOfTreasure     quantity of treasure
     * @param level             level object to reflect number of level, room name, number of room, quantity of monster and treasure in the room
     */
    private int numOfRoom;
    private int numOfMonster;
    private int numOfTreasure;
    private Level level;
    public MedievalLevelBuilder(int numOflevel, int numOfRoom, int numOfMonster, int numOfTreasure) {
        if (numOfRoom < 0 || numOfMonster < 0 || numOfTreasure < 0) {
            throw new IllegalArgumentException();
        }
        level = new Level(numOflevel);
        this.numOfRoom = numOfRoom;
        this.numOfMonster = numOfMonster;
        this.numOfTreasure = numOfTreasure;
    }

    /**
     * addRoom method has a single parameter for the room's description and a room with that description to the level.
     *
     * @param description         room's description
     */
    public void addRoom(String description) {
        if (numOfRoom == 0) {
            throw new IllegalStateException("No available room");
        }
        numOfRoom--;
        level.addRoom(description);
    }

    /**
     * addPotion method add "a healing potion" (value = 1) to the specified room
     */
    public void addPotion(int roomNumber) {
        if (numOfTreasure == 0) {
            throw new IllegalStateException("Target number of treasures has already been reached.");
        }
        if (level.getRooms().get(roomNumber) == null) {
            throw new IllegalArgumentException("Room was not created");
        }
        numOfTreasure--;
        level.addTreasure(roomNumber, new Treasure("a healing potion", 1));
    }

    /**
     * addGold method add "pieces of gold" of the specified value to the specified room
     */
    public void addGold(int roomNumber, int goldCount) {
        if (numOfTreasure == 0) {
            throw new IllegalStateException("Target number of treasures has already been reached.");
        }
        if (level.getRooms().get(roomNumber) == null) {
            throw new IllegalArgumentException("Room was not created");
        }
        numOfTreasure--;
        level.addTreasure(roomNumber, new Treasure("pieces of gold", goldCount));
    }

    /**
     * addWeapon method add the specified weapon to the specified room
     */
    public void addWeapon(int roomNumber, String description) {
        if (numOfTreasure == 0) {
            throw new IllegalStateException("Target number of treasures has already been reached.");
        }
        if (level.getRooms().get(roomNumber) == null) {
            throw new IllegalArgumentException("Room was not created");
        }
        numOfTreasure--;
        level.addTreasure(roomNumber, new Treasure(description, 10));
    }

    /**
     * addSpecial method add the most exclusive treasures to the specified room.
     */
    public void addSpecial(int roomNumber, String description, int value) {
        if (numOfTreasure == 0) {
            throw new IllegalStateException("Target number of treasures has already been reached.");
        }
        if (level.getRooms().get(roomNumber) == null) {
            throw new IllegalArgumentException("Room was not created");
        }
        numOfTreasure--;
        level.addTreasure(roomNumber, new Treasure(description, value));
    }

    /**
     * addGoblins method add the specified number of goblins to the specified room
     */
    public void addGoblins(int roomNumber, int numOfGoblin) {
        if (numOfMonster - numOfGoblin < 0) {
            throw new IllegalStateException("Target number of monsters has already been reached");
        }
        if (level.getRooms().get(roomNumber) == null) {
            throw new IllegalArgumentException("Room was not created");
        }
        for (int i=0; i<numOfGoblin; i++) {
            level.addMonster(roomNumber, new Monster("goblin",
                    "mischievous and very unpleasant, vengeful, and greedy creature whose primary purpose is to cause trouble to humankind",
                    7));
        }
    }

    /**
     * addOrc method add a single orc to the specified room
     */
    public void addOrc(int roomNumber) {
        if (numOfMonster == 0) {
            throw new IllegalStateException("Target number of monsters has already been reached");
        }
        if (level.getRooms().get(roomNumber) == null) {
            throw new IllegalArgumentException("Room was not created");
        }
        numOfMonster--;
        level.addMonster(roomNumber, new Monster("orc",
                "brutish, aggressive, malevolent being serving evil",
                20));
    }

    /**
     * addOgre method add a single orc to the specified room
     */
    public void addOgre(int roomNumber) {
        if (numOfMonster == 0) {
            throw new IllegalStateException("Target number of monsters has already been reached");
        }
        if (level.getRooms().get(roomNumber) == null) {
            throw new IllegalArgumentException("Room was not created");
        }
        numOfMonster--;
        level.addMonster(roomNumber, new Monster("ogre",
                "large, hideous man-like being that likes to eat humans for lunch",
                50));
    }
    /**
     * addHuman method add a single human to the specified room
     */
    public void addHuman(int roomNumber, String name, String description, int hitpoint) {
        if (numOfMonster == 0) {
            throw new IllegalStateException("Target number of monsters has already been reached\"");
        }
        if (level.getRooms().get(roomNumber) == null) {
            throw new IllegalArgumentException("Room was not created");
        }
        numOfMonster--;
        level.addMonster(roomNumber, new Monster(name, description, hitpoint));
    }

    /**
     * build method return the level only after it has been completely constructed
     */
    public Level build() {
        if (level == null || numOfTreasure < 0 || numOfMonster < 0 || numOfRoom != 0 ) {
            throw new IllegalStateException("Parameters not probably initiated");
        }

        return level;
    }

}

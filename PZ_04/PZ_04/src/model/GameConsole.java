package model;

public class GameConsole implements Powered {
    public enum Brand {
        SONY, MICROSOFT, NINTENDO
    }

    public enum Color {
        BLACK, WHITE, GREEN, BLUE, RED
    }

    private final Brand brand;
    private final String serial;
    private String model;
    private GamePad firstGamepad;
    private GamePad secondGamepad;
    private boolean isOn;
    private Game activeGame;

    public GameConsole(Brand brand, String serial) {
        this.brand = brand;
        this.serial = serial;
        this.firstGamepad = new GamePad(brand, 1, Color.GREEN);
        this.secondGamepad = new GamePad(brand, 2, Color.BLACK);
        this.isOn = false;
        this.activeGame = null;
    }

    public GameConsole(Brand brand, String model, String serial) {
        this(brand, serial);
        this.model = model;
    }

    @Override
    public void powerOn() {
        if (!isOn) {
            isOn = true;
            System.out.println("Game console is now ON");
        }
    }

    @Override
    public void powerOff() {
        if (isOn) {
            isOn = false;
            System.out.println("Game console is now OFF");
        }
    }

    public void loadGame(Game game) {
        this.activeGame = game;
        System.out.println("Game " + game.getName() + " is loading...");
    }

    public void playGame() {
        if (activeGame == null) {
            System.out.println("No active game to play");
            return;
        }

        System.out.println("Playing " + activeGame.getName());
        GamePad[] gamePads = {firstGamepad, secondGamepad};
        for (GamePad gamePad : gamePads) {
            if (gamePad.isOn()) {
                System.out.println("GamePad " + gamePad.getConnectedNumber() +
                        " charge: " + gamePad.getChargeLevel() + "%");
                gamePad.reduceCharge(10);
            }
        }
    }

    public class GamePad implements Powered {
        private final Brand brand;
        private final String consoleSerial;
        private final int connectedNumber;
        private final Color color;
        private double chargeLevel;
        private boolean isOn;

        public GamePad(Brand brand, int connectedNumber, Color color) {
            this.brand = brand;
            this.consoleSerial = GameConsole.this.serial;
            this.connectedNumber = connectedNumber;
            this.color = color;
            this.chargeLevel = 100.0;
            this.isOn = false;
        }

        @Override
        public void powerOn() {
            if (!isOn) {
                isOn = true;
                System.out.println("GamePad " + connectedNumber + " is now ON.");
                GameConsole.this.powerOn();

                if (connectedNumber == 2 && !GameConsole.this.firstGamepad.isOn()) {
                    System.out.println("GamePad 2 is now the primary controller");
                    swapGamePads();
                }
            }
        }

        @Override
        public void powerOff() {
            if (isOn) {
                isOn = false;
                System.out.println("GamePad " + connectedNumber + " is now OFF");
            }
        }

        public void reduceCharge(double amount) {
            if (chargeLevel > 0) {
                chargeLevel -= amount;
                if (chargeLevel <= 0) {
                    chargeLevel = 0;
                    System.out.println("GamePad " + connectedNumber + " is out of charge and turning OFF");
                    powerOff();
                }
            }
        }

        public Brand getBrand() {
            return brand;
        }

        public String getConsoleSerial() {
            return consoleSerial;
        }

        public int getConnectedNumber() {
            return connectedNumber;
        }

        public Color getColor() {
            return color;
        }

        public double getChargeLevel() {
            return chargeLevel;
        }

        public boolean isOn() {
            return isOn;
        }
    }

    private void swapGamePads() {
        GamePad temp = firstGamepad;
        firstGamepad = secondGamepad;
        secondGamepad = temp;
    }

    public Brand getBrand() {
        return brand;
    }

    public String getSerial() {
        return serial;
    }

    public GamePad getFirstGamepad() {
        return firstGamepad;
    }

    public GamePad getSecondGamepad() {
        return secondGamepad;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public boolean isOn() {
        return isOn;
    }

    public Game getActiveGame() {
        return activeGame;
    }
}

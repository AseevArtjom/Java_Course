package model;

public class GameConsole {
    public enum Brand {
        SONY, MICROSOFT, NINTENDO
    }

    public enum Color {
        BLACK, WHITE, GREEN, BLUE, RED
    }

    private final Brand brand;
    private final String serial;
    private String model;
    private final GamePad firstGamepad;
    private final GamePad secondGamepad;
    private boolean isOn;

    public GameConsole(Brand brand, String serial) {
        this.brand = brand;
        this.serial = serial;
        this.firstGamepad = new GamePad(brand, 1, Color.GREEN);
        this.secondGamepad = new GamePad(brand, 2, Color.BLACK);
        this.isOn = false;
    }
    public GameConsole(Brand brand, String model, String serial) {
        this(brand, serial);
        this.model = model;
    }

    public class GamePad {
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

        public void setChargeLevel(double chargeLevel) {
            if (chargeLevel >= 0 && chargeLevel <= 100) {
                this.chargeLevel = chargeLevel;
            } else {
                System.out.println("Invalid charge level");
            }
        }

        public boolean isOn() {
            return isOn;
        }

        public void setOn(boolean isOn) {
            this.isOn = isOn;
        }
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

    public void setOn(boolean isOn) {
        this.isOn = isOn;
    }
}

package Model.Shop;

public enum ShopEnum {
    SMALL_SHOP(1, 2, "Small Shop"),
    SUPERMARKET(3, 100, "Supermarket");

    private final int minSize;
    private final int maxSize;
    private final String description;

    ShopEnum(int minSize, int maxSize, String description) {
        this.minSize = minSize;
        this.maxSize = maxSize;
        this.description = description;
    }

    public int getMinSize() {
        return minSize;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public String getDescription() {
        return description;
    }
}

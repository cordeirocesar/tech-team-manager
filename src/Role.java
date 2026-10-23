public enum Role {

    DEVELOPER("Developer"),
    PRODUCT_MANAGER("Product Manager"),
    DEVOPS("DevOps");

    private final String description;

    Role(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}

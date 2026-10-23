public enum Role {

    DEVELOPER("Developer") {
        @Override
        double calculateBonus(double salary) {
            return salary * 0.10;
        }
    },
    PRODUCT_MANAGER("Product Manager") {
        @Override
        double calculateBonus(double salary) {
            return salary * 0.20;
        }
    },
    DEVOPS("DevOps") {
        @Override
        double calculateBonus(double salary) {
            return salary * 0.15;
        }
    };

    private final String description;
    abstract double calculateBonus(double salary);

    Role(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}

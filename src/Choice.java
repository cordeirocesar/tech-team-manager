public enum Choice {

    REGISTER_EMPLOYEE(1),
    LIST_EMPLOYEES(2),
    DISPLAY_FINAL_SALARY(3),
    DISPLAY_EMPLOYEE_WITH_HIGHEST_SALARY(4),
    DISPLAY_EMPLOYEE_COUNT_BY_ROLE(5),
    SEARCH_EMPLOYEE_BY_NAME(6),
    EXIT(7);
    private final int code;

    Choice(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}

package properties;

public enum PageProperty {

    BUDGET_ACTIVITY("BudgetActivity"),
    GOOGLE_PAGE("https://google.com"),
    EPAM_SEARCH("EPAM");

    private String str;

    public String getText() {
        return this.str;
    }

    PageProperty(String str) {
        this.str = str;
    }
}
package np.com.alon.enumlist;

public enum StatusList {

    DRAFT("DRAFT"),
    TRASH("TRASH"),
    PUBLISH("PUBLISH");

    StatusList(String value) {
        this.value = value;
    }

    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

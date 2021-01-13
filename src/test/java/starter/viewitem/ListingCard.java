package starter.viewitem;

public class ListingCard {
    private final String title;

    public String getTitle() {
        return title;
    }

    public String getDataListingId() {
        return dataListingId;
    }

    private final String dataListingId;

    public ListingCard(String title, String dataListingId) {
        this.title = title;
        this.dataListingId = dataListingId;
    }
}

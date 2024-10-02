public class Order {
    private String clientName;
    private String cakeName;
    private int prepTime;

    public Order(String clientName, String cakeName, int prepTime) {
        this.clientName = clientName;
        this.cakeName = cakeName;
        this.prepTime = prepTime;
    }

    public String getClientName() {
        return clientName;
    }

    public String getCakeName() {
        return cakeName;
    }

    public int getPrepTime() {
        return prepTime;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public void setCakeName(String cakeName) {
        this.cakeName = cakeName;
    }

    public void setPrepTime(int prepTime) {
        this.prepTime = prepTime;
    }
}

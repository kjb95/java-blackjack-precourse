package dto;

public class RevenueDto {

    private final String name;
    private final int revenue;

    public RevenueDto(String name, int revenue) {
        this.name = name;
        this.revenue = revenue;
    }

    public String getName() {
        return name;
    }

    public int getRevenue() {
        return revenue;
    }
}

package P0052rv3;
public class Country extends EastAsiaCountries implements Comparable<Country> {
    private String countryTerrain;

    public Country() {}

    public Country(String countryCode, String countryName, double countryArea, String countryTerrain) {
        super(countryCode, countryName, countryArea);
        this.countryTerrain = countryTerrain;
    }

    public String getCountryTerrain() {
        return countryTerrain;
    }

    public void setCountryTerrain(String countryTerrain) {
        this.countryTerrain = countryTerrain;
    }

    @Override
    public void display() {
        System.out.printf("%-10s%-25s%-20.0f%-25s\n", getCountryCode(), getCountryName(), getCountryArea(), countryTerrain);
    }

    @Override
    public int compareTo(Country t) {
        return this.getCountryName().compareTo (t.getCountryName());
    }
}

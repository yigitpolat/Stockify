package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by berku on 8.12.2017.
 */
public class BrandManager {
    private ArrayList<Brand> brands = new ArrayList<>();
    private Stock stock;

    public BrandManager(Stock stock) {
        this.stock = stock;
        updateBrands();
    }

    public ArrayList<Brand> getBrands() {
        return brands;
    }

    public Brand getBrandWithID(int id) {
        updateBrands();
        for (Brand brand : brands) {
            if (id == brand.getId())
                return brand;
        }
        return null;
    }

    public Brand getBrandWithName(String name) {
        updateBrands();
        for (Brand brand : brands) {
            if (name.equals(brand.getName()))
                return brand;
        }
        return null;
    }

    public void addBrand(String brandName) throws SQLException {
        String query = "INSERT INTO brand (name) VALUES" +
                " ( '" + brandName + "')";
        stock.getDatabaseManager().executeUpdate(query);
        updateBrands();
    }

    public void updateBrands() {
        String query = "SELECT * FROM brand";
        ResultSet rs = stock.getDatabaseManager().executeQuery(query);
        updateBrandsFromResultSet(rs);
    }

    private void updateBrandsFromResultSet(ResultSet rs) {
        ArrayList<Brand> updatedBrands = new ArrayList<>();
        Brand brand = null;
        try {
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                brand = new Brand(id, name);
                updatedBrands.add(brand);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        brands = updatedBrands;
    }

}

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
        brands.add(new Brand(1, "brand"));
        brands.add(new Brand(2, "brand2"));
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
        Statement statement = stock.getDB().getConnection().createStatement();
        statement.executeUpdate(query);
        updateBrands();
    }

    public void updateBrands() {
        ArrayList<Brand> updatedBrands = new ArrayList<>();
        String query = "SELECT * FROM brand";
        try{
            Statement statement = stock.getDB().getConnection().createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()){
                updatedBrands.add(getBrandFromResultSet(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        brands = updatedBrands;
    }

    private Brand getBrandFromResultSet(ResultSet rs) {
        Brand brand = null;
        try{
            int id = rs.getInt("id");
            String name = rs.getString("name");
            brand = new Brand(id,name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return brand;
    }

}

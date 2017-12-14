package Model;

import java.util.ArrayList;

/**
 * Created by berku on 8.12.2017.
 */
public class BrandManager {
    private ArrayList<Brand> brands = new ArrayList<>();

    public BrandManager() {
        brands.add(new Brand(1, "brand"));
        brands.add(new Brand(2, "brand2"));
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

    public void updateBrands() {
        // TODO: updateBrands process
    }

}

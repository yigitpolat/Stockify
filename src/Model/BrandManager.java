package Model;

import java.util.ArrayList;

/**
 * Created by berku on 8.12.2017.
 */
public class BrandManager {
    private ArrayList<Brand> brands;

    public BrandManager() {
        updateBrands();
    }

    public ArrayList<Brand> getBrands() {
        return brands;
    }

    public Brand getBrandWithID(int id) {
        updateBrands();
        // TODO: get Brand from the updated brands.
        return new Brand(id, "test");
    }

    public void updateBrands() {
        // TODO: updateBrands process
    }

}

import model.ArvustusCategory;
import model.Database;
import model.Raamat;
import model.ZhanrCategory;

import java.sql.SQLException;

public class TestDatabase {
    public static void main(String[] args) throws SQLException {
        System.out.println("Running database test");

        Database db = new Database();
        try {
            db.connect();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        db.addraamat(new Raamat("Mõmmi aabits",
                "Heljo0000 Mänd",
                "1111",
                ZhanrCategory.Kriminull,
                ArvustusCategory.Väga_hea));

        db.addraamat(new Raamat("Kukeaabits",
                "Enooooookk Raud",
                "0000",
                ZhanrCategory.Lasteraamat,
                ArvustusCategory.Väga_halb));

        db.save();
        db.load();


        db.disconnect();

    }
}

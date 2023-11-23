import by.kirylarol.JDBC;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

public class JDBC_Test {
    private static final String ADRESS = "jdbc:postgresql://localhost:5432/web6";
    private static final String LOGIN="postgres";
    private static final String PASSWORD="root";
    private static final String TABLE_NAME="programmers";

    @Test
    void testClass() {
        try {
            new JDBC(ADRESS,LOGIN,PASSWORD,TABLE_NAME);
        }
        catch(SQLException e) {
            e.printStackTrace();
            fail("Failed to connect. SQLException.");
        }
    }


    @Test
    void testCreate() {
        try {
            JDBC db = new JDBC(ADRESS,LOGIN,PASSWORD,TABLE_NAME);
            db.createProgrammer(1, "Kiryxa", "Hrodna", "Intern");
            db.createProgrammer(2, "Vladik", "St.Petersburg", "Middle");
            db.createProgrammer(3, "Vova", "Moscow", "Senior");
        } catch (SQLException e) {
            e.printStackTrace();
            fail("Failed to create new programmer. SQLException");
        }
    }

    @Test
    void testDelete() {
        try {
            JDBC db = new JDBC(ADRESS,LOGIN,PASSWORD,TABLE_NAME);
            db.deleteProgrammer(1);
        } catch (SQLException e) {
            e.printStackTrace();
            fail("Failed to delete programmer. SQLException");
        }
    }

    @Test
    void testRead() {
        ResultSet rs=null;
        try {
            JDBC db = new JDBC(ADRESS,LOGIN,PASSWORD,TABLE_NAME);
            rs=db.readTable();
        } catch (SQLException e) {
            e.printStackTrace();
            fail("Failed to read database. SQLException");
        }
        assertNotNull(rs);
    }

    @Ignore
    @Test
    void truncateTable() {
        try {
            JDBC db = new JDBC(ADRESS,LOGIN,PASSWORD,TABLE_NAME);
            db.clear();
        } catch (SQLException e) {
            e.printStackTrace();
            fail("Failed to truncate table. SQLException");
        }
    }

    @Test
    void testUpdate() {
        try {
            JDBC db = new JDBC(ADRESS,LOGIN,PASSWORD,TABLE_NAME);
            db.updateProgrammer(2, "Petya", "St.Petersburg", "Junior");
        } catch (SQLException e) {
            e.printStackTrace();
            fail("Failed to update database. SQLException");
        }
    }







}

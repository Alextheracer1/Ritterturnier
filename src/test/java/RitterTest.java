import com.github.alextheracer1.ritterturnier.Members.Knappe;
import com.github.alextheracer1.ritterturnier.Members.Ritter;
import com.github.alextheracer1.ritterturnier.Weapons.Keule;
import com.github.alextheracer1.ritterturnier.Weapons.Lanze;
import com.github.alextheracer1.ritterturnier.Weapons.Schwert;
import com.github.alextheracer1.ritterturnier.Weapons.Weapon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RitterTest {

    Ritter ritter;
    Knappe knappe;
    Weapon weapon;
    Schwert schwert;
    Keule keule;
    Lanze lanze;


    @BeforeEach
    void setUp() {
        ritter = new Ritter("Sepp", "124567", "Der Seppige", 1);
        knappe = new Knappe("Knappe", "12345", 12, 1);
        keule = new Keule("Keule");
        schwert = new Schwert("Schwert");
        lanze = new Lanze("Lanze");
    }

    @Test
    public void testRitter() {
        assertEquals("Sepp", ritter.getName(), "Name sollte der Name von dem Ritter Sepp sein");
        assertEquals(1, ritter.getId(), "Id sollte 1 sein, da nur 1 Ritter zurzeit erstellt ist");
    }

    @Test
    public void setWeapon() {
        ritter.setWeapon(schwert);
        assertEquals("Schwert", ritter.getWeaponCategory());
        ritter.setWeapon(lanze);
        assertEquals("Lanze", ritter.getWeaponCategory());
        ritter.setWeapon(keule);
        assertEquals("Keule", ritter.getWeaponCategory());

    }

    @Test
    public void testKnappe() {
        assertEquals("Knappe", knappe.getName(), "Name von Knappe sollte Knappe sein");
    }

    @Test
    public void addKnappeToRitter() {
        ritter.setKnappe(knappe);
        assertEquals("Knappe", ritter.getKnappeName());
    }
}

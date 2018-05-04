package dlc.tp;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Reader<E>
{
    private String arch;

    public Reader(String nom)
    {
        arch = nom;
    }

    public E read() {

        E objeto;

        try {
            FileInputStream istream = new FileInputStream(arch);
            ObjectInputStream p = new ObjectInputStream(istream);
            objeto = (E) p.readObject();
            p.close();
            istream.close();

        }

        catch (Exception e) {
            System.out.println("Error wachi, fijate el read "+e);
            objeto = null;
        }

        return objeto;
    }
}


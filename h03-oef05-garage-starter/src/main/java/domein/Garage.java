package domein;

import persistentie.AutoMapper;

import java.util.List;

public class Garage {

    private final List<Auto> autos;

    public Garage() {
        autos = new AutoMapper().geefLijstVanAutos();
    }

    public List<Auto> getAutos() {
        return autos;
    }

    public void sorteerOpNummerplaat() {
        // Natuurlijke ordering

    }

    public void sorteerOpMerk() {
        // Met anonieme innerklasse

    }

    public void sorteerOpMerkEnModel() {
        // Met method reference

    }

    public void sorteerOpAantalOnderhoudsbeurtenAflopend() {
        // Met lambda

    }

}
package domein;

import java.util.Objects;

public class Container implements Comparable<Container> {

    private String eigenaar;
    private int volume;
    private int massa;
    private final int serienummer;

    public Container(String eigenaar, int volume, int massa, int serienummer) {
        setEigenaar(eigenaar);
        setVolume(volume);
        setMassa(massa);
        controleerSerialNumber(serienummer);
        this.serienummer = serienummer;
    }

    private void setEigenaar(String eigenaar) {
        if (eigenaar == null || eigenaar.isEmpty()) {
            throw new IllegalArgumentException("Er moet een eigenaar opgegeven worden.");
        }
        this.eigenaar = eigenaar;
    }

    private void setVolume(int volume) {
        if (volume <= 0) {
            throw new IllegalArgumentException("Geen geldig volume opgegeven.");
        }
        this.volume = volume;
    }

    private void setMassa(int massa) {
        if (massa <= 0) {
            throw new IllegalArgumentException("Geen geldige massa opgegeven.");
        }
        this.massa = massa;
    }

    public String getEigenaar() {
        return eigenaar;
    }

    public int getVolume() {
        return volume;
    }

    public int getMassa() {
        return massa;
    }

    public int getSerienummer() {
        return serienummer;
    }

    private void controleerSerialNumber(int serienummer) {
        if (serienummer <= 0) {
            throw new IllegalArgumentException("Ongeldig serienummer!");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Container container = (Container) o;
        return serienummer == container.serienummer;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(serienummer);
    }

    public int compareTo(Container c) {
        return Integer.compare(this.serienummer, c.serienummer);
    }
}
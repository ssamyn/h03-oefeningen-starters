package domein;

import java.util.Comparator;

public class ContainerVolumeEnEigenaarComparator extends ContainerEigenaarComparator {
    @Override
    public int compare(Container c1, Container c2) {
        return Comparator.comparingInt(Container::getVolume)
                .thenComparing(new ContainerEigenaarComparator())
                .compare(c1, c2);
    }
}
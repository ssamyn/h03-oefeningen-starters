package domein;

import persistentie.ContainerMapper;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class ContainerRepository {
    private ContainerMapper mapper;
    private List<Container> containers;

    public ContainerRepository() {
        mapper = new ContainerMapper();
        containers = mapper.getContainers();
    }

    public Collection<Container> getContainers() {
        return containers;
    }

    public Collection<Container> geefAlleContainersGesorteerdOpSerienummerDalend() {
        // TO DO
        return containers;
    }

    public Collection<Container> geefAlleContainersGesorteerdOpMassa() {
        // TO DO
        containers.sort(new ContainerMassaComparator());
        return containers;
    }

    public Collection<Container> geefAlleContainersGesorteerdOpEigenaar() {
        // TO DO
        containers.sort(new ContainerEigenaarComparator());
        return containers;
    }

    public Collection<Container> geefAlleContainersGesorteerdOpVolumeEnEigenaar() {
        containers.sort(new ContainerVolumeEnEigenaarComparator());
        return containers;
    }

    public void voegContainerToe(Container c) {
        if (containers.contains(c))
            throw new IllegalArgumentException(
                    String.format("Container met serienummer %d bestaat reeds", c.getSerienummer()));
        mapper.voegContainerToe(c);
        containers = mapper.getContainers();
    }

}
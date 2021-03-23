package repository.json;

import Model.Region;
import repository.RegionRepository;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

public class JsonRegionRepositoryImpl implements RegionRepository {

    private File file = new File("regions.json");
    private Reader reader = new FileReaderRegion();
    private Writer writer = new FileWriterRegion();

    @Override
    public Region getByld(Long id) {
        List<Region> regions = reader.read(file);

        for(Region region: regions){
            if(region.getId() == id){
                return region;
            }
        }
        return null;
    }

    @Override
    public List<Region> getAll() {
        List<Region> regions = reader.read(file);
        return regions;
    }

    @Override
    public Region save(Region region) {
        long newRegionId;

        List<Region> regions = reader.read(file);

        if(regions.size() == 0){
            newRegionId = 1;
        } else {
            newRegionId = regions.get(regions.size() - 1).getId() + 1;
        }
        region.setId(newRegionId);
        regions.add(region);

        writer.write(regions, file);

        return region;
    }

    @Override
    public Region update(Region region) {
        List<Region> regions = reader.read(file);

        List<Region> regionUpdate = regions.stream().map(n -> {if(n.getId() == region.getId()){
            n.setName(region.getName());
        }
            return n;
        }).collect(Collectors.toList());
        Region newRegion = regionUpdate.stream().filter(n -> n.getId() == region.getId()).findFirst().
                orElse(null);

        writer.write(regionUpdate, file);

        return newRegion;
    }

    @Override
    public void deleteByld(Long id) {

        List<Region> regions = reader.read(file);

        List<Region> regionUpdate = regions.stream().map(n -> {if(n.getId() == id){
            regions.remove(n);}
            return n;}).collect(Collectors.toList());

        writer.write(regionUpdate, file);
    }
}

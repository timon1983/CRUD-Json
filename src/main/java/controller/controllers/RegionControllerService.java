package controller.controllers;

import Model.Post;
import Model.Region;
import controller.RegionController;
import repository.GenericReposiroty;
import repository.json.JsonRegionRepositoryImpl;

import java.util.List;

public class RegionControllerService implements RegionController {

    private GenericReposiroty regionRepository = new JsonRegionRepositoryImpl();


    @Override
    public Region checkSave(String name) {
        Region region = new Region(0L, name);
        return (Region) regionRepository.save(region);
    }

    @Override
    public Region checkGetByld(Long id) {
        return (Region) regionRepository.getByld(id);
    }

    @Override
    public void checkGetAll() {
        List<Region> allRegions = regionRepository.getAll();
        if (allRegions == null) {
            System.out.println("The list of posts is empty");
        } else {
            allRegions.stream().forEach(x -> System.out.println(x));
        }
    }

    @Override
    public Region checkUpdate(Long id, String name) {
        Region region = new Region(id, name);
        return (Region) regionRepository.update(region);
    }

    @Override
    public void checkDeleteByld(Long id) {
        regionRepository.deleteByld(id);
    }
}

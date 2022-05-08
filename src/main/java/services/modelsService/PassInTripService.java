package services.modelsService;

import models.PassInTrip;
import repasotorys.Methods;
import repasotorys.RepoPassInTrip;

import java.util.List;

public class PassInTripService implements Methods<PassInTrip> {

    private final RepoPassInTrip repoPassInTrip = new RepoPassInTrip();

    @Override
    public void create(PassInTrip passInTrip) {
        repoPassInTrip.create(passInTrip);
    }

    @Override
    public PassInTrip read(Long id) {
        return repoPassInTrip.read(id);
    }

    @Override
    public void update(Long id, PassInTrip passInTrip) {
        repoPassInTrip.update(id, passInTrip);
    }

    @Override
    public void delete(Long id) {
        repoPassInTrip.delete(id);
    }

    @Override
    public List<PassInTrip> readAll() {
        return repoPassInTrip.readAll();
    }
}

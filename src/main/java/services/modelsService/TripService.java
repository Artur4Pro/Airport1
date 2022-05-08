package services.modelsService;

import models.Trip;
import repasotorys.Methods;
import repasotorys.RepoTrip;

import java.util.List;

public class TripService implements Methods<Trip> {

    private final RepoTrip repoTrip = new RepoTrip();

    @Override
    public void create(Trip trip) {
        repoTrip.create(trip);
    }

    @Override
    public Trip read(Long id) {
        return repoTrip.read(id);
    }

    @Override
    public void update(Long id, Trip trip) {
        repoTrip.update(id, trip);
    }

    @Override
    public void delete(Long id) {
        repoTrip.delete(id);
    }

    @Override
    public List<Trip> readAll() {
        return repoTrip.readAll();
    }
}

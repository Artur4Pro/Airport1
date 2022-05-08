package services.modelsService;

import models.Passenger;
import repasotorys.Methods;
import repasotorys.RepoPassenger;

import java.util.List;

public class PassengerService implements Methods<Passenger> {

    private final RepoPassenger repoPassenger = new RepoPassenger();

    @Override
    public void create(Passenger passenger) {
        repoPassenger.create(passenger);
    }

    @Override
    public Passenger read(Long id) {
        return repoPassenger.read(id);
    }

    @Override
    public void update(Long id, Passenger passenger) {
        repoPassenger.update(id, passenger);
    }

    @Override
    public void delete(Long id) {
        repoPassenger.delete(id);
    }

    @Override
    public List<Passenger> readAll() {
        return repoPassenger.readAll();
    }
}

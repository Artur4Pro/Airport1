package services.modelsService;

import models.Address;
import repasotorys.Methods;
import repasotorys.RepoAddress;

import java.util.List;

public class AddressService implements Methods<Address> {
    private final RepoAddress repoAddress = new RepoAddress();


    @Override
    public void create(Address address) {
        repoAddress.create(address);
    }

    @Override
    public Address read(Long id) {
        return repoAddress.read(id);
    }

    @Override
    public void update(Long id, Address address) {
        repoAddress.update(id, address);
    }

    @Override
    public void delete(Long id) {
        repoAddress.delete(id);
    }

    @Override
    public List<Address> readAll() {
        return repoAddress.readAll();
    }
}

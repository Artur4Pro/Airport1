package services.modelsService;

import models.Company;
import repasotorys.Methods;
import repasotorys.RepoAddress;
import repasotorys.RepoCompany;

import java.util.List;

public class CompanyService implements Methods<Company> {

    private final RepoCompany repoCompany = new RepoCompany();

    @Override
    public void create(Company company) {
        repoCompany.create(company);
    }

    @Override
    public Company read(Long id) {
        return repoCompany.read(id);
    }

    @Override
    public void update(Long id, Company company) {
        repoCompany.update(id, company);
    }

    @Override
    public void delete(Long id) {
        repoCompany.delete(id);
    }

    @Override
    public List<Company> readAll() {
        return repoCompany.readAll();
    }
}

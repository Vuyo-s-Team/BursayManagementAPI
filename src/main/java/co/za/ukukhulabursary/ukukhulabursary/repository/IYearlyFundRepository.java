package co.za.ukukhulabursary.ukukhulabursary.repository;

import co.za.ukukhulabursary.ukukhulabursary.model.BBDYearlyFund;

import java.util.List;
import java.util.Optional;

public interface IYearlyFundRepository {
    public List<BBDYearlyFund> findAll();
    public Optional<BBDYearlyFund> findById(long id);
}

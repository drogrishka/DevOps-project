package mk.ukim.finki.wpvezbi.service;

import mk.ukim.finki.wpvezbi.model.Manufacturer;

import java.util.List;
import java.util.Optional;

public interface ManufacturerService {

    List<Manufacturer> findAll();
    Optional<Manufacturer> findById(long id);
    Optional<Manufacturer> save(String name, String address);
    void deleteById(Long id);

}

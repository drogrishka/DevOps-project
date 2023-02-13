package mk.ukim.finki.wpvezbi.repository.jpa;

import mk.ukim.finki.wpvezbi.model.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManufacturerRepository extends JpaRepository<Manufacturer,Long> {

}

package mk.ukim.finki.wpvezbi.repository.jpa;

import mk.ukim.finki.wpvezbi.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> { //<Entity, ID>
    //ima gotovi metodi kako findAll...
    //@Query(value="sql")
    List<Category> findAllByNameLike(String text);
    void deleteByName(String name);
}

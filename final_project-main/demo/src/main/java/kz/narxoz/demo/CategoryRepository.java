package kz.narxoz.demo;

import kz.narxoz.demo.model.CategoryEntity;
import kz.narxoz.demo.model.ProgramEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
}

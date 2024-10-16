package app.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import app.app.entity.Brand;
import app.app.entity.Car;

public interface CarRepository extends JpaRepository<Car, Long> {
	
	public List<Car> findByName(final String name);

	public List<Car> findByBrand(final Brand brand);
	
	@Query("from Car c where c.year > :year")
	public List<Car> findOverYear(final int year);
}

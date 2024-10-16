package app.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.app.entity.Brand;
import app.app.entity.Car;
import app.app.repository.CarRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class CarService {

	@Autowired
	private CarRepository carRepository;
	
	public String save(final Car car) {
		this.carRepository.save(car);
		return "Carro salvo com sucesso";
	}
	
	public String update(final Car car, final Long id) {
		car.setId(id);
		this.carRepository.save(car);
		return "Carro atualizado com sucesso";
	}
	
	public String delete(final Long id) {
		carRepository.deleteById(id);
		return "Carro removido com sucesso";
	}
	
	public List<Car> findAll() {
		final List<Car> list = carRepository.findAll();
		return list;
	}
	
	public Car findById(final Long id) {
		final Car car = this.carRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Carro com id: " + id + "não encontrado"));
		return car;
	}
	
	public List<Car> findByName(final String name) {
		return this.carRepository.findByName(name);
	}
	
	public List<Car> findByBrand(final Long id) {
		Brand brand = new Brand();
		brand.setId(id);
		
		return this.carRepository.findByBrand(brand);
	}
	
	public List<Car> findOverYear(final int year) {
		return this.carRepository.findOverYear(year);
	}
}

package app.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.app.entity.Car;
import app.app.service.CarService;

@RestController
@RequestMapping("/car")
public class CarController {

	@Autowired
	private CarService carService;
	
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody final Car car) {
		try {
			return new ResponseEntity<>(this.carService.save(car), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>("erro para salvar carro", HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<String> update(@RequestBody final Car car, @PathVariable("id") final Long id) {
		try {
			return new ResponseEntity<>(this.carService.update(car, id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("erro para atualizar carro", HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") final Long id) {
		try {
			return new ResponseEntity<>(this.carService.delete(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("erro para deletar carro", HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<List<Car>> findAll() {
		try {
			return new ResponseEntity<>(this.carService.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Car> findById(@PathVariable("id") final Long id) {
		try {
			return new ResponseEntity<>(this.carService.findById(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping("/findByName")
	public ResponseEntity<List<Car>> findByName(@RequestParam final String name) {
		try {
			return new ResponseEntity<>(this.carService.findByName(name), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping("/findByBrand")
	public ResponseEntity<List<Car>> findByBrand(@RequestParam final Long brandId) {
		try {
			return new ResponseEntity<>(this.carService.findByBrand(brandId), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping("/findOverYear")
	public ResponseEntity<List<Car>> findOverYear(@RequestParam final int year) {
		try {
			return new ResponseEntity<>(this.carService.findOverYear(year), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		}
	}
	
}

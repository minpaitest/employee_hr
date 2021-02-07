package com.emphr_hr.controller;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.emphr_hr.entity.Employee;
import com.emphr_hr.repository.EmployeeRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
public class EmployeeController {
	@Autowired
	private EmployeeRepository employeeRepository;

	private Path filePath2;
	private DataInputStream reader = null;
	private Path imagePath;
	private DataInputStream imageReader = null;

	@PostMapping("/employee/register/{employee_id}")
	public ResponseEntity<Void> createEmployee(@PathVariable String employee_id, @RequestBody Employee employee)
			throws IOException {
		if (reader != null) {
			DataOutputStream writer = null;
			try {
				writer = new DataOutputStream(new FileOutputStream(filePath2.toFile()));
				byte[] buf = new byte[1024];
				int ret = 0;
				while ((ret = reader.read(buf)) >= 0) {
					writer.write(buf);
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (imageReader != null) {
				DataOutputStream writer2 = null;
				try {
					writer2 = new DataOutputStream(new FileOutputStream(imagePath.toFile()));
					byte[] buf = new byte[1024];
					int ret = 0;
					while ((ret = imageReader.read(buf)) >= 0) {
						writer2.write(buf);
					}
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		if (imagePath != null) {
			employee.setEmployee_profile(imagePath.toString());

		}
		// employee.setEmployee_profile(imagePath.toString());
		if (filePath2 != null) {
			employee.setFile_path(filePath2.toString());

		}
		employeeRepository.save(employee_id, employee);

		// Location
		// Get current resource url
		/// {id}
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{employee_id}")
				.buildAndExpand(employee.getEmployee_id()).toUri();

		return ResponseEntity.created(uri).build();

		// return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping("/upload-file")
	public ResponseEntity<Void> upload(@RequestHeader(name = "Origin", required = false) String origin,
			@RequestParam("file") MultipartFile file, @RequestParam("fileName") String fileName) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Access-Control-Allow-Origin", origin);
		if (file != null) {
			filePath2 = FileSystems.getDefault().getPath("C:\\Users\\user\\com.vue.emphr_hr\\public\\uploaded",
					fileName);
			try {
				reader = new DataInputStream(file.getInputStream());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping("/upload-image")
	public ResponseEntity<Void> uploadImage(@RequestHeader(name = "Origin", required = false) String origin,
			@RequestParam("file") MultipartFile file, @RequestParam("fileName") String fileName) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Access-Control-Allow-Origin", origin);
		if (file != null) {
			imagePath = FileSystems.getDefault().getPath("C:\\Users\\user\\com.vue.emphr_hr\\public\\uploaded",
					fileName);
			try {
				imageReader = new DataInputStream(file.getInputStream());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/employee/{employee_id}")
	public Employee getEmployee(@PathVariable String employee_id) {
		return employeeRepository.findByemployeeId(employee_id);

	}

	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/employeelists")
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@DeleteMapping("/employeelists/{employee_id}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable String employee_id) {

		employeeRepository.deleteById(employee_id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/searchemployeelists/{employee_id}")
	public List<Employee> searchEmployee(@PathVariable String employee_id) {

		return employeeRepository.findByEmployeeId(employee_id);
	}

}

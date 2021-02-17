package com.biss.controller.rest;

import java.util.List;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.RestController;

import com.biss.model.Student;
import com.biss.service.IStudentService;

@RestController
@RequestMapping("/rest/std")
public class StudentRestController {
	@Autowired
	private IStudentService ser;

	/**
	 * 1. This method takes Student object
	 * as input from JSON/XML using
	 * @RequestBody and returns
	 * ResponseEntity<T>.
	 * call service.saveStudent(ob)
	 */
	@PostMapping("/save")
	public ResponseEntity<String> saveStudent(@RequestBody Student std){
		ResponseEntity<String> resp=null;
		try {
			if(std!=null) {
				Integer id=ser.saveStudent(std);
				resp=new ResponseEntity<String>(id+" saved",HttpStatus.OK);
			}else {
				resp=new ResponseEntity<String>("No Data found",HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			resp=new ResponseEntity<String>("Can't Saved Data",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return resp;
	}
	/***
	 * 2. This method reads data from DB
	 * using findAll() and returns
	 * List<Student> if data exist
	 * or String (not exist)
	 * as ResponseEntity using annotation
	 * @ResponseBody
	 */
	@GetMapping("/all")
	public ResponseEntity<?> getAllStudent(){
		ResponseEntity<?> resp=null;
		try {
			List<Student> list=ser.getAllStudent();
			if(list!=null && !list.isEmpty()) {
				resp=new ResponseEntity<List<Student>>(list,HttpStatus.OK);
			}else {
				resp=new ResponseEntity<String>("No Data found",HttpStatus.OK);			
			}

		} catch (Exception e) {
			resp=new ResponseEntity<String>("Unable to Fetch Record",HttpStatus.INTERNAL_SERVER_ERROR);			
		}
		return resp;
	}
	/**
	 * 3. Read PathVariable id (as input)
	 * use service layer to find one object
	 * based on Id. Return Student if exist
	 * else String (error message) as
	 * ResponseEntity<?>
	 */
	@GetMapping("/one/{id}")
	public ResponseEntity<?> getOneStudent(
			@PathVariable Integer id)
	{
		ResponseEntity<?> resp=null;
		try {
			Optional<Student> opt=ser.getOneStudent(id);
			if(opt.isPresent())
				resp=new
				ResponseEntity<Student>(opt.get(),HttpStatus.OK);
			else
				resp=new ResponseEntity<String>("No Data Found",HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			resp=new ResponseEntity<String>("Unable to Fetch Data",HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return resp;
	}
	/**
	 * 4. Read pathVariable id
	 * check row exist or not
	 * if exist call service delete
	 * else return String error msg
	 */
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<String> deleteStudent(
			@PathVariable Integer id)
	{
		ResponseEntity<String> resp=null;
		try {
			boolean exist=ser.isExist(id);
			if(exist) {
				ser.deleteStudent(id);
				resp=new ResponseEntity<String>(id+"-removed",HttpStatus.OK);
			}else {
				resp=new ResponseEntity<String>(id+"-Not Exist",HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			resp=new ResponseEntity<String>("Unable to"+
					" Delete",HttpStatus.INTERNAL_SERVER_ERROR);
					e.printStackTrace();
		}
		return resp;
	}
	/**
	 * 5. Read Input as JSON/XML using
	 * @RequestBody , check id exist or not
	 * if exist call service save method
	 * Return ResponseeEntity
	 */
	@PutMapping("/update")
	public ResponseEntity<String> updateStudent(
			@RequestBody Student student)
	{
		ResponseEntity<String> resp=null;
		try {
			boolean exist=ser.isExist(student.getStdId());
			if(exist) {
				ser.saveStudent(student);
				resp=new
						ResponseEntity<String>(student.getStdId()+"-Updated",HttpStatus.OK);
			}else {
				resp=new
						ResponseEntity<String>(student.getStdId()+"-Not "+
								"Exist",HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			resp=new ResponseEntity<String>("Unable to Update",HttpStatus.INTERNAL_SERVER_ERROR);
					e.printStackTrace();
		}
		return resp;
	}
}

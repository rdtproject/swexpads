package pl.webcache.swexpads.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.webcache.swexpads.domain.Add;
import pl.webcache.swexpads.services.AddService;
import pl.webcache.swexpads.services.MapValidationErrorService;

@RestController
@RequestMapping("/api/project")
public class AddController {

	@Autowired
	private AddService addService;

	@Autowired
	private MapValidationErrorService errorService;

	@PostMapping("")
	public ResponseEntity<?> createNewProject(@Valid @RequestBody Add add, BindingResult result) {

		ResponseEntity<?> errorMap = errorService.mapValidationService(result);
		if (errorMap != null) return errorMap;
		
		Add savedAdd = addService.saveOrUpdateAdd(add);
		return new ResponseEntity<Add>(savedAdd, HttpStatus.CREATED);
	}

}

package pl.webcache.swexpads.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.webcache.swexpads.domain.Add;
import pl.webcache.swexpads.services.AddService;
import pl.webcache.swexpads.services.MapValidationErrorService;

@RestController
@RequestMapping("/api/project")
@CrossOrigin
public class AddController {

	@Autowired
	private AddService addService;

	@Autowired
	private MapValidationErrorService errorService;

	@PostMapping("")
	public ResponseEntity<?> createNewProject(@Valid @RequestBody Add add, BindingResult result) {
		ResponseEntity<?> errorMap = errorService.mapValidationService(result);
		if (errorMap != null)
			return errorMap;

		Add savedAdd = addService.saveOrUpdateAdd(add);
		return new ResponseEntity<Add>(savedAdd, HttpStatus.CREATED);
	}

	@GetMapping("/{addId}")
	public ResponseEntity<?> getProjectById(@PathVariable String addId) {
		Add add = addService.findAddByIdentifier(addId.toUpperCase());
		return new ResponseEntity<Add>(add, HttpStatus.OK);
	}

	@GetMapping("/all")
	public Iterable<Add> getAllAdds() {
		return addService.findAllAdds();
	}

	@DeleteMapping("/{addId}")
	public ResponseEntity<?> deleteAdd(@PathVariable String addId) {
		addService.deleteAddByIdentifier(addId.toUpperCase());
		return new ResponseEntity<String>(
				String.format("Project with Identifier %s has been deleted successfully", addId), HttpStatus.OK);
	}

}

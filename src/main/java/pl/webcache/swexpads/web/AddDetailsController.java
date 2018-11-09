package pl.webcache.swexpads.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.webcache.swexpads.domain.AddItem;
import pl.webcache.swexpads.services.AddItemService;
import pl.webcache.swexpads.services.MapValidationErrorService;

@RestController
@RequestMapping("/api/backlog")
@CrossOrigin
public class AddDetailsController {

	@Autowired
	private AddItemService adItemService;

	@Autowired
	private MapValidationErrorService mapValidationErrorService;

	@PostMapping("/{ad_details_id}")
	public ResponseEntity<?> addAddItemToAddDetails(@Valid @RequestBody AddItem addItem, BindingResult result,
			@PathVariable String ad_details_id) {

		ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationService(result);
		if (errorMap != null)
			return errorMap;

		AddItem addItem2 = adItemService.addAdItem(ad_details_id, addItem);

		return new ResponseEntity<AddItem>(addItem2, HttpStatus.CREATED);
	}

	@GetMapping("/{ad_details_id}")
	public Iterable<AddItem> getAdDetails(@PathVariable String ad_details_id) {
		return adItemService.findAdDetailsById(ad_details_id);
	}
}

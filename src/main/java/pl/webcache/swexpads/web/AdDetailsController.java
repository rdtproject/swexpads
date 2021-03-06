package pl.webcache.swexpads.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.webcache.swexpads.domain.AdItem;
import pl.webcache.swexpads.services.AdItemService;
import pl.webcache.swexpads.services.MapValidationErrorService;

@RestController
@RequestMapping("/api/backlog")
@CrossOrigin
public class AdDetailsController {

	@Autowired
	private AdItemService adItemService;

	@Autowired
	private MapValidationErrorService mapValidationErrorService;

	@PostMapping("/{ad_details_id}")
	public ResponseEntity<?> addAdItemToAdDetails(@Valid @RequestBody AdItem addItem, BindingResult result,
			@PathVariable String ad_details_id) {

		ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationService(result);
		if (errorMap != null)
			return errorMap;

		AdItem adItem2 = adItemService.adAdItem(ad_details_id, addItem);

		return new ResponseEntity<AdItem>(adItem2, HttpStatus.CREATED);
	}

	@GetMapping("/{ad_details_id}")
	public Iterable<AdItem> getAdDetails(@PathVariable String ad_details_id) {
		return adItemService.findAdDetailsById(ad_details_id);
	}

	@GetMapping("/{ad_details_id}/{ad_item_id}")
	public ResponseEntity<?> getProjectTask(@PathVariable String ad_details_id, @PathVariable String ad_item_id) {
		AdItem adItem = adItemService.findByAdSequence(ad_details_id, ad_item_id);
		return new ResponseEntity<AdItem>(adItem, HttpStatus.OK);
	}

	@PatchMapping("/{ad_details_id}/{ad_item_id}")
	public ResponseEntity<?> updateAdItem(@Valid @RequestBody AdItem adItem, BindingResult result,
			@PathVariable String ad_details_id, @PathVariable String ad_item_id) {
		ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationService(result);
		if (errorMap != null) {
			return errorMap;
		}

		AdItem updatedItem = adItemService.updateByAdSequence(adItem, ad_details_id, ad_item_id);

		return new ResponseEntity<AdItem>(updatedItem, HttpStatus.OK);
	}

	@DeleteMapping("/{ad_details_id}/{ad_item_id}")
	public ResponseEntity<?> deleteAdItem(@PathVariable String ad_details_id, @PathVariable String ad_item_id) {
		adItemService.deleteAdItemByAdSequence(ad_details_id, ad_item_id);
		return new ResponseEntity<String>(String.format("Ad item %s was deleted successfully.", ad_item_id),
				HttpStatus.OK);
	}
}

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

import pl.webcache.swexpads.domain.Ad;
import pl.webcache.swexpads.services.AdService;
import pl.webcache.swexpads.services.MapValidationErrorService;

@RestController
@RequestMapping("/api/project")
@CrossOrigin
public class AdController {

	@Autowired
	private AdService adService;

	@Autowired
	private MapValidationErrorService errorService;

	@PostMapping("")
	public ResponseEntity<?> createNewProject(@Valid @RequestBody Ad ad, BindingResult result) {
		ResponseEntity<?> errorMap = errorService.mapValidationService(result);
		if (errorMap != null)
			return errorMap;

		Ad savedAdd = adService.saveOrUpdateAd(ad);
		return new ResponseEntity<Ad>(savedAdd, HttpStatus.CREATED);
	}

	@GetMapping("/{adId}")
	public ResponseEntity<?> getProjectById(@PathVariable String adId) {
		Ad add = adService.findAdByIdentifier(adId.toUpperCase());
		return new ResponseEntity<Ad>(add, HttpStatus.OK);
	}

	@GetMapping("/all")
	public Iterable<Ad> getAllAds() {
		return adService.findAllAds();
	}

	@DeleteMapping("/{adId}")
	public ResponseEntity<?> deleteAd(@PathVariable String adId) {
		adService.deleteAddByIdentifier(adId.toUpperCase());
		return new ResponseEntity<String>(
				String.format("Project with Identifier %s has been deleted successfully", adId), HttpStatus.OK);
	}

}

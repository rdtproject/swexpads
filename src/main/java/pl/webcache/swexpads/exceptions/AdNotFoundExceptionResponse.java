package pl.webcache.swexpads.exceptions;

public class AdNotFoundExceptionResponse {

	private String adNotFound;

	public AdNotFoundExceptionResponse(String adNotFound) {
		this.adNotFound = adNotFound;
	}

	public String getAdNotFound() {
		return adNotFound;
	}

	public void setAdNotFound(String adNotFound) {
		this.adNotFound = adNotFound;
	}

}

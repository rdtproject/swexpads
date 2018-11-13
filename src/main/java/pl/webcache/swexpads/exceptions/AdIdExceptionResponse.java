package pl.webcache.swexpads.exceptions;

public class AdIdExceptionResponse {
	private String adIdentifier;

	public AdIdExceptionResponse(String adIdentifier) {
		this.adIdentifier = adIdentifier;
	}

	public String getAdIdentifier() {
		return adIdentifier;
	}

	public void setAdIdentifier(String adIdentifier) {
		this.adIdentifier = adIdentifier;
	}

}

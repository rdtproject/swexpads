package pl.webcache.swexpads.exceptions;

public class AdIdExceptionResponse {
	private String addIdentifier;

	public AdIdExceptionResponse(String addIdentifier) {
		this.addIdentifier = addIdentifier;
	}

	public String getAddIdentifier() {
		return addIdentifier;
	}

	public void setAddIdentifier(String addIdentifier) {
		this.addIdentifier = addIdentifier;
	}

}

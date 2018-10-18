package pl.webcache.swexpads.exceptions;

public class AddIdExceptionResponse {
	private String addIdentifier;

	public AddIdExceptionResponse(String addIdentifier) {
		this.addIdentifier = addIdentifier;
	}

	public String getAddIdentifier() {
		return addIdentifier;
	}

	public void setAddIdentifier(String addIdentifier) {
		this.addIdentifier = addIdentifier;
	}

}

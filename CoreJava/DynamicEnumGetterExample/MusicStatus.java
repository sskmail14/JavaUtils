import java.util.List;

public class MusicStatus {
	
	
	
	public MusicStatus(List<String> status, Boolean isSuccessfull) {
		super();
		this.status = status;
		this.isSuccessfull = isSuccessfull;
	}

	private List<String> status;

	public List<String> getStatus() {
		return status;
	}

	public void setStatus(List<String> status) {
		this.status = status;
	}

	public Boolean getIsSuccessfull() {
		return isSuccessfull;
	}

	public void setIsSuccessfull(Boolean isSuccessfull) {
		this.isSuccessfull = isSuccessfull;
	}

	Boolean isSuccessfull;
}

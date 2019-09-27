package vo;

public class ReceptionViewsIplogListVO {
	
	private  String currentPage = "1";
	
	private  String beginDate;
	
	private  String endDate;
	
	private  String state = "-1";

	public String getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(String currentPage) {
		this.currentPage = currentPage;
	}

	public String getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "ReceptionViewsIplogListVO [currentPage=" + currentPage + ", beginDate=" + beginDate + ", endDate="
				+ endDate + ", state=" + state + "]";
	}
	
	

}

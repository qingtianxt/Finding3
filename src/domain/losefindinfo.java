package domain;

public class losefindinfo {
	private int number;
	private String user;
	private String address;
	private String category;
	private String datetime;
	private String image;
	private String information;
	private String phone;
	private String releasetime;
	private String shorttitle;
	private String place;
	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getShorttitle() {
		return shorttitle;
	}

	public void setShorttitle(String shorttitle) {
		this.shorttitle = shorttitle;
	}

	public losefindinfo(){
		
	}
	
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDatetime() {
		return datetime;
	}
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getInformation() {
		return information;
	}
	public void setInformation(String information) {
		this.information = information;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getReleasetime() {
		return releasetime;
	}
	public void setReleasetime(String releasetime) {
		this.releasetime = releasetime;
	}

	@Override
	public String toString() {
		return "losefindinfo [number=" + number + ", user=" + user + ", address=" + address + ", category=" + category
				+ ", datetime=" + datetime + ", image=" + image + ", information=" + information + ", phone=" + phone
				+ ", releasetime=" + releasetime + ", shorttitle=" + shorttitle + ", place=" + place + "]";
	}
	
	
	
}

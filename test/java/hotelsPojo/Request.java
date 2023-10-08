package hotelsPojo;

import java.util.List;

public class Request {
private HotelList hotelList;

private String checkindate;
private String checkoutdate;
private int duration;
private String agencyCountry;
private String guestCountry;
private Pax pax;
private String ratetype;
private String responseTime;
private String bookingDate;
private int roomcount;
private String dateRecency;
public HotelList getHotelList() {
	return hotelList;
}
public void setHotelList(HotelList hotelList) {
	this.hotelList = hotelList;
}
public String getCheckindate() {
	return checkindate;
}
public void setCheckindate(String checkindate) {
	this.checkindate = checkindate;
}
public String getCheckoutdate() {
	return checkoutdate;
}
public void setCheckoutdate(String checkoutdate) {
	this.checkoutdate = checkoutdate;
}
public int getDuration() {
	return duration;
}
public void setDuration(int duration) {
	this.duration = duration;
}
public String getAgencyCountry() {
	return agencyCountry;
}
public void setAgencyCountry(String agencyCountry) {
	this.agencyCountry = agencyCountry;
}
public String getGuestCountry() {
	return guestCountry;
}
public void setGuestCountry(String guestCountry) {
	this.guestCountry = guestCountry;
}
public Pax getPax() {
	return pax;
}
public void setPax(Pax pax) {
	this.pax = pax;
}
public String getRatetype() {
	return ratetype;
}
public void setRatetype(String ratetype) {
	this.ratetype = ratetype;
}
public String getResponseTime() {
	return responseTime;
}
public void setResponseTime(String responseTime) {
	this.responseTime = responseTime;
}
public String getBookingDate() {
	return bookingDate;
}
public void setBookingDate(String bookingDate) {
	this.bookingDate = bookingDate;
}
public int getRoomcount() {
	return roomcount;
}
public void setRoomcount(int roomcount) {
	this.roomcount = roomcount;
}
public String getDateRecency() {
	return dateRecency;
}
public void setDateRecency(String dateRecency) {
	this.dateRecency = dateRecency;
}



}

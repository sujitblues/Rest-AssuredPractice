package studentPojo;

import java.util.List;

public class Courses {
	private List<WebAutomationPojo> WebAutomation;
	private List<APIPojo> api;
	private List<mobilePojo> mobile;
	public List<WebAutomationPojo> getWebAutomation() {
		return WebAutomation;
	}
	public void setWebAutomation(List<WebAutomationPojo> webAutomation) {
		WebAutomation = webAutomation;
	}
	public List<APIPojo> getApi() {
		return api;
	}
	public void setApi(List<APIPojo> api) {
		this.api = api;
	}
	public List<mobilePojo> getMobile() {
		return mobile;
	}
	public void setMobile(List<mobilePojo> mobile) {
		this.mobile = mobile;
	}
	

}

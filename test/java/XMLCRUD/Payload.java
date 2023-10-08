package XMLCRUD;

public class Payload {
	   String xmlPayload = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\r\n"
       		+ "<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\r\n"
       		+ "  <soap:Body>\r\n"
       		+ "    <Add xmlns=\"http://tempuri.org/\">\r\n"
       		+ "      <intA>45</intA>\r\n"
       		+ "      <intB>45</intB>\r\n"
       		+ "    </Add>\r\n"
       		+ "  </soap:Body>\r\n"
       		+ "</soap:Envelope>";
		String jsonPayload = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\r\n"
				+ "<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\r\n"
				+ "  <soap:Body>\r\n"
				+ "    <Add xmlns=\"http://tempuri.org/\">\r\n"
				+ "      <intA>90</intA>\r\n"
				+ "      <intB>45</intB>\r\n"
				+ "    </Add>\r\n"
				+ "  </soap:Body>\r\n"
				+ "</soap:Envelope>";
		

}

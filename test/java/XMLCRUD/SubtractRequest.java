package XMLCRUD;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "Envelope", namespace = "http://schemas.xmlsoap.org/soap/envelope/")
@XmlAccessorType(XmlAccessType.FIELD)
public class SubtractRequest {

    @XmlElement(name = "Body", namespace = "http://schemas.xmlsoap.org/soap/envelope/")
    private Body body;

    public SubtractRequest() {
        this.body = new Body();
    }

    public void setIntA(int intA) {
        this.body.subtract.setIntA(intA);
    }

    public void setIntB(int intB) {
        this.body.subtract.setIntB(intB);
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "Body", namespace = "http://schemas.xmlsoap.org/soap/envelope/")
    public static class Body {

        @XmlElement(name = "Subtract", namespace = "http://tempuri.org/")
        private Subtract subtract;

        public Body() {
            this.subtract = new Subtract();
        }

        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "Subtract", namespace = "http://tempuri.org/")
        public static class Subtract {

            @XmlElement(name = "intA", namespace = "http://tempuri.org/")
            private int intA;

            @XmlElement(name = "intB", namespace = "http://tempuri.org/")
            private int intB;

            public void setIntA(int intA) {
                this.intA = intA;
            }

            public void setIntB(int intB) {
                this.intB = intB;
            }
        }
    }
}

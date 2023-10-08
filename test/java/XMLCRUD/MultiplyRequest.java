package XMLCRUD;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "Envelope", namespace = "http://schemas.xmlsoap.org/soap/envelope/")
@XmlAccessorType(XmlAccessType.FIELD)
public class MultiplyRequest {

    @XmlElement(name = "Body", namespace = "http://schemas.xmlsoap.org/soap/envelope/")
    private Body body;

    public MultiplyRequest() {
        this.body = new Body();
    }

    public void setIntA(int intA) {
        this.body.multiply.setIntA(intA);
    }

    public void setIntB(int intB) {
        this.body.multiply.setIntB(intB);
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "Body", namespace = "http://schemas.xmlsoap.org/soap/envelope/")
    public static class Body {

        @XmlElement(name = "Multiply", namespace = "http://tempuri.org/")
        private Multiply multiply;

        public Body() {
            this.multiply = new Multiply();
        }

        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "Multiply", namespace = "http://tempuri.org/")
        public static class Multiply {

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

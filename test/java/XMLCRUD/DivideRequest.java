package XMLCRUD;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "Envelope", namespace = "http://schemas.xmlsoap.org/soap/envelope/")
@XmlAccessorType(XmlAccessType.FIELD)
public class DivideRequest {

    @XmlElement(name = "Body", namespace = "http://schemas.xmlsoap.org/soap/envelope/")
    private Body body;

    public DivideRequest() {
        this.body = new Body();
    }

    public void setIntA(int intA) {
        this.body.divide.setIntA(intA);
    }

    public void setIntB(int intB) {
        this.body.divide.setIntB(intB);
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "Body", namespace = "http://schemas.xmlsoap.org/soap/envelope/")
    public static class Body {

        @XmlElement(name = "Divide", namespace = "http://tempuri.org/")
        private Divide divide;

        public Body() {
            this.divide = new Divide();
        }

        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "Divide", namespace = "http://tempuri.org/")
        public static class Divide {

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


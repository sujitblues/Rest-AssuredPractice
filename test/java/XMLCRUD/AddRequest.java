package XMLCRUD;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


import javax.xml.bind.annotation.*;

@XmlRootElement(name = "Envelope", namespace = "http://schemas.xmlsoap.org/soap/envelope/")
@XmlAccessorType(XmlAccessType.FIELD)
public class AddRequest {

    @XmlElement(name = "Body", namespace = "http://schemas.xmlsoap.org/soap/envelope/")
    private Body body;

    public AddRequest() {
        this.body = new Body();
    }

    public void setIntA(int intA) {
        this.body.add.setIntA(intA);
    }

    public void setIntB(int intB) {
        this.body.add.setIntB(intB);
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "Body", namespace = "http://schemas.xmlsoap.org/soap/envelope/")
    public static class Body {

        @XmlElement(name = "Add", namespace = "http://tempuri.org/")
        private Add add;

        public Body() {
            this.add = new Add();
        }

        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "Add", namespace = "http://tempuri.org/")
        public static class Add {

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

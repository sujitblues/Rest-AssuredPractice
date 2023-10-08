package MarshallAndUnMarshall;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="person")
@XmlType(propOrder= {"userName","userEmailId","userPhoneNo","userCode","skills","goals"})
public class Person implements Serializable{

}

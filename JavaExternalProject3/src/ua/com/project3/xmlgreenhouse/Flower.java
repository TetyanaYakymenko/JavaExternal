package ua.com.project3.xmlgreenhouse;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Student", propOrder = {
 "name",
 "telephone",
 "address"
})
public class Flower {
	
}

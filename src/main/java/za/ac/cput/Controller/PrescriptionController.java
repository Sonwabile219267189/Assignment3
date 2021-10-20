/**
 * PrescriptionController.java
 * Author: Sonwabile Gxoyiya
 */

package za.ac.cput.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.Entity.Prescription;
import za.ac.cput.Factory.PrescriptionFactory;

@RestController
@RequestMapping("/prescription")
public class PrescriptionController {

    @RequestMapping(value = "/prescription", method = RequestMethod.POST)

    //create a prescription oobject
    public String create(Prescription prescription){

        return "Prescription";

    }

}

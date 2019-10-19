package mum.edu.swe.hcmcpatientsmgmtsystem.domain.validators;

import mum.edu.swe.hcmcpatientsmgmtsystem.domain.Patient;
import mum.edu.swe.hcmcpatientsmgmtsystem.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class UniquePatientNumberValidator implements ConstraintValidator<UniquePatientNumber, String> {

    @Autowired
    private PatientService patientService;

    public UniquePatientNumberValidator() { }

    public UniquePatientNumberValidator(PatientService patientService) {
        this.patientService = patientService;
    }

    @Override
    public void initialize(UniquePatientNumber constraintAnnotation) {

    }

    @Override
    public boolean isValid(String patientNumber, ConstraintValidatorContext context) {
        boolean valid;
        if(patientService != null) {
            valid = (patientNumber != null && !patientService.findByPatientNumber(patientNumber).isPresent());
        } else {
            valid = true;
        }

        return valid;
    }

}

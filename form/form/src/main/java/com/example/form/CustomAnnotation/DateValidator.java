package com.example.form.CustomAnnotation;

import com.example.form.entity.LeaveDetails;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.BeanWrapperImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateValidator implements ConstraintValidator<DateValidation , LeaveDetails> {

    @Override
    public void initialize(DateValidation constraintAnnotation) {

       }

    @Override
    public boolean isValid(LeaveDetails value, ConstraintValidatorContext context) {
        Date start_date=value.getFrom_date();
        Date to_date=value.getTo_date();
        if(to_date.before(start_date)){
            return false;

        }
        else
            return true;

    }

}

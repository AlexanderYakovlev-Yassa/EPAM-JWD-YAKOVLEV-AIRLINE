package by.epam.jwd.yakovlev.airline.validator;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.epam.jwd.yakovlev.airline.exception.ValidatorException;

public interface Validator {
	
	void check( Optional<Object> entityOptional) throws ValidatorException;
	
	default boolean isPatternMatches(Pattern pattern, String word) {

        if (word == null) {
            return false;
        }

        Matcher matcher = pattern.matcher(word);

        return matcher.matches();
    }

}

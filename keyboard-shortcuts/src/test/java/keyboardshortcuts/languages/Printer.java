package keyboardshortcuts.languages;

import keyboardshortcuts.Place;
import org.lambda.query.Queryable;

public interface Printer {
    void writeFile(Queryable<Place> methods);

    void startAt(Place place);
}

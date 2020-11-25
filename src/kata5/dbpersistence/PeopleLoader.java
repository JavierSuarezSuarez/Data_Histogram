
package kata5.dbpersistence;

import kata5.model.Person;
import java.util.List;

public interface PeopleLoader {
    public List<Person> load();
}


package kata5.main;

import kata5.dbpersistence.SqlitePeopleLoader;
import kata5.dbpersistence.PeopleLoader;
import kata5.model.Person;
import kata5.model.Histogram;
import kata5.view.HistogramDisplay;
import kata5.view.SwingHistogramDisplay;
import java.sql.SQLException;

public class Kata5 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        PeopleLoader peopleLoader = new SqlitePeopleLoader();
        Histogram<String> histogram = new Histogram();
        for(Person person : peopleLoader.load()){
            histogram.increment(person.getEmailDomain());
        }
        HistogramDisplay histogramDisplay = new SwingHistogramDisplay("Histograma", histogram);
        histogramDisplay.execute();
    }
    
}



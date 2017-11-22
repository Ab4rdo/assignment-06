package comparators;

import person.Person;

import java.text.Collator;
import java.util.Comparator;

public final class NameComparator implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        Collator col = Collator.getInstance(o1.getNation().getLocale());
        int first = col.compare(o1.getFirstName(), o2.getFirstName());
        if(first==0) {
            return col.compare(o1.getSurname(), o2.getSurname());
        }
        return first;
    }

}

package extension;

import comparators.NameComparator;
import enums.Nation;
import person.Person;

import java.text.Collator;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class PersonExtension<T extends Person> {

    final private Set<T> set;
    final private List<T> sortedByLocale;

    public PersonExtension(Collection<T> collection) {
        set = collection.stream().collect(Collectors.toSet());
        sortedByLocale = set.stream().sorted().collect(Collectors.toList());
    }

    public List<T> getSortedByLocaleList() {
        return sortedByLocale;
    }

    public List<T> getSortedByNation(Nation n) {
        Comparator<Person> comparator = new NameComparator();
        Collator nationCol = Collator.getInstance(n.getLocale());
        nationCol.setStrength(Collator.PRIMARY);
        List<T> list = sortedByLocale.stream()
                .filter(person->person.getNation().equals(n))
                .sorted(comparator)
                .collect(Collectors.toList());

        return list;
    }


}

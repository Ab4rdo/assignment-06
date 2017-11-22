package extension;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class UniversityExtension<T> {

    private final Set<T> set;

    public UniversityExtension(Collection<T> collection) {
        set = collection.stream()
                .collect(Collectors.toSet());
    }

    public List<T> getList() {
        List<T> list = set.stream()
                .collect(Collectors.toList());
        return list;
    }


}

package proj.skillfactory.comparators;

import proj.skillfactory.objects.University;

public class UnivComparatorByYearOfFoundation implements ComparatorUniver {

    @Override
    public int compare(University o1, University o2) {
        return Integer.compare(o1.getYearOfFoundation(), o2.getYearOfFoundation());

    }
}

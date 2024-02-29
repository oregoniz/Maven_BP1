package org.example.comparators;

import org.apache.commons.lang3.StringUtils;
import org.example.objects.University;

import java.util.Comparator;

public abstract interface ComparatorUniver extends Comparator<University> {
    class UnivComparatorById implements ComparatorUniver {

        @Override
        public int compare(University o1, University o2) {
            return StringUtils.compare(o1.getId(), o2.getId());
        }
    }

    public static class UnivComparatorByMainProfile implements ComparatorUniver {

        @Override
        public int compare(University o1, University o2) {
            return StringUtils.compare(o1.getMainProfile().name(), o2.getMainProfile().name());
        }
    }

    public static class UnivComparatorByName implements ComparatorUniver {

        @Override
        public int compare(University o1, University o2) {
            return StringUtils.compare(o1.getFullName(), o2.getFullName());
        }
    }

    public static class UnivComparatorByShortName implements ComparatorUniver {

        @Override
        public int compare(University o1, University o2) {
            return StringUtils.compare(o1.getShortName(), o2.getShortName());
        }
    }

    public static class UnivComparatorByYearOfFoundation implements ComparatorUniver {

        @Override
        public int compare(University o1, University o2) {
            return Integer.compare(o1.getYearOfFoundation(), o2.getYearOfFoundation());

        }
    }
}


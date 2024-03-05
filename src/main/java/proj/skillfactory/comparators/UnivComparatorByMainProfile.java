package proj.skillfactory.comparators;

import org.apache.commons.lang3.StringUtils;
import proj.skillfactory.objects.University;

public class UnivComparatorByMainProfile implements ComparatorUniver {

    @Override
    public int compare(University o1, University o2) {
        return StringUtils.compare(o1.getMainProfile().name(), o2.getMainProfile().name());
    }
}

package proj.skillfactory.comparators;

import org.apache.commons.lang3.StringUtils;
import proj.skillfactory.objects.University;

public class UnivComparatorById implements ComparatorUniver {

    @Override
    public int compare(University o1, University o2) {
        return StringUtils.compare(o1.getId(), o2.getId());
    }
}

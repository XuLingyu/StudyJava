package a_interview.designpattern.structuralmode.filter;

import java.util.List;

/**
 * @Author:xuly
 * @Date: 2019/12/17 13:49
 * @Description:
 */
public interface Criteria {
    public List<Person> meetCriteria(List<Person> persons);
}

package a_interview.designpattern.structuralmode.filter;
import java.util.ArrayList;
import java.util.List;
/**
 * @Author:xuly
 * @Date: 2019/12/17 13:49
 * @Description:
 */
public class CriteriaSingle implements Criteria {
    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> singlePersons = new ArrayList<Person>();
        for (Person person : persons) {
            if(person.getMaritalStatus().equalsIgnoreCase("SINGLE")){
                singlePersons.add(person);
            }
        }
        return singlePersons;
    }
}

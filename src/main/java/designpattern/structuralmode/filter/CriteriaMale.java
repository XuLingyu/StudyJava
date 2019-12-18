package designpattern.structuralmode.filter;
import java.util.ArrayList;
import java.util.List;
/**
 * @Author:xuly
 * @Date: 2019/12/17 13:49
 * @Description:
 */
public class CriteriaMale implements Criteria {

    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> malePersons = new ArrayList<Person>();
        for (Person person : persons) {
            if(person.getGender().equalsIgnoreCase("MALE")){
                malePersons.add(person);
            }
        }
        return malePersons;
    }
}

package designpattern.structuralmode.filter;
import java.util.ArrayList;
import java.util.List;
/**
 * @Author:xuly
 * @Date: 2019/12/17 13:52
 * @Description:
 */
public class CriteriaFemale implements Criteria {

    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> femalePersons = new ArrayList<Person>();
        for (Person person : persons) {
            if(person.getGender().equalsIgnoreCase("FEMALE")){
                femalePersons.add(person);
            }
        }
        return femalePersons;
    }
}

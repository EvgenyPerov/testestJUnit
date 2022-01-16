package Services;

import Entities.EnumSex;
import Entities.Man;
import Entities.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Service {
     private ArrayList<Person> personList;
     private int id=0;


    public Service(){
        personList = new ArrayList<>();
    }

    public Person createPerson(String name, int old, EnumSex sex) {
        id++;
        if (name != null && !name.isEmpty() && old > 0 && sex != null) {
//        if (!(name instanceof String) || old<1)  {
//            System.out.println("Ошибка, не верные данные");

            Person person = new Man(id, name, old, sex);
            personList.add(person);
            return person;
        } else return null;
    }

    public ArrayList<Person> getPersonList(){
        return personList;
    }

    public ArrayList<Person> getSexPersonList(EnumSex sex){
        List<Person> sexpersonList = getPersonList().stream().
                filter(person -> person.getSex().equals(sex)).
                collect(Collectors.toList());
        return (ArrayList<Person>) sexpersonList;
    }

    public int getSize(){
        return personList.size();
    }

    public int getSizeSex(EnumSex sex){
        return getSexPersonList(sex).size();
    }

    public int getSumOld(){
        int summ = getPersonList().stream().mapToInt(Person::getOld).sum();
        return summ;
    }

    public int getSexSumOld(EnumSex sex){
        int summ = getSexPersonList(sex).stream().mapToInt(Person::getOld).sum();
        return summ;
    }

    public int getAverageOld(){
        return getSumOld()/getSize();
    }

    public int getSexAverageOld(EnumSex sex){
        return getSexSumOld(sex)/getSizeSex(sex);
    }

}

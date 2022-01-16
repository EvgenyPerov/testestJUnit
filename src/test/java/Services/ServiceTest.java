package Services;

import Entities.EnumSex;
import Entities.Man;
import Entities.Person;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class ServiceTest {
    Service service = new Service();
    Person person11;
    Person person12;
    Person person13;
    Person person14;
    Person person15;
    ArrayList<Person> listExpect;
    Person userNotAdd;
    Person userNotAdd1;


    @Before
    public void setUp() throws Exception {
        Person person1 = service.createPerson("Jey", 39, EnumSex.MALE);
        Person person2 = service.createPerson("Dolly", 30, EnumSex.FEMALE);
        Person person3 = service.createPerson("Ron", 33, EnumSex.MALE);
//        Person person4 = service.createPerson("Germiona", 18, EnumSex.FEMALE);
//        Person person5 = service.createPerson("Garry", 40, EnumSex.MALE);
        Person userNotAdd = service.createPerson("",0, null);
        Person userNotAdd1 = service.createPerson(null,0, null);


        person11 = new Man(1,"Jey",39, EnumSex.MALE);
        person12 = new Man(2,"Dolly",30, EnumSex.FEMALE);
        person13 = new Man(3,"Ron",33, EnumSex.MALE);
        person14 = new Man(4,"Germiona",18, EnumSex.FEMALE);
        person15 = new Man(5,"Garry",40, EnumSex.MALE);
        userNotAdd= new Man(4,"",0, null);
        userNotAdd1= new Man(5,null,0, null);

        listExpect =  new ArrayList<>();
    }


 //   @Test
    public void createPerson() {
    }

    @Test
    public void getPersonList() {

        listExpect.add(person11);
        listExpect.add(person12);
        listExpect.add(person13);
        listExpect.add(person14);
        listExpect.add(person15);

        ArrayList<Person> personListOriginal = service.getPersonList();

        Assert.assertEquals(listExpect, personListOriginal);
    }

    @Test
    public void getPersonList_not_null() {
        ArrayList<Person> personListOriginal = service.getPersonList();
        Assert.assertNotNull(personListOriginal);
    }

    @Test
    public void getSexPersonList_MALE() {
        listExpect.add(person11);
        listExpect.add(person13);
        listExpect.add(person15);

        ArrayList<Person> SexPersonListOriginal = service.getSexPersonList(EnumSex.MALE);

        Assert.assertEquals(listExpect, SexPersonListOriginal);
    }

    @Test
    public void getSexPersonList_MALE_Not_Null() {
        ArrayList<Person> SexPersonListOriginal = service.getSexPersonList(EnumSex.MALE);
        Assert.assertNotNull(SexPersonListOriginal);
    }

    @Test
    public void getSexPersonList_FEMALE() {
        listExpect.add(person12);
        listExpect.add(person14);

        ArrayList<Person> SexPersonListOriginal = service.getSexPersonList(EnumSex.FEMALE);

        Assert.assertEquals(listExpect, SexPersonListOriginal);
    }

    @Test
    public void getSexPersonList_FEMALE_Not_Null() {
        ArrayList<Person> SexPersonListOriginal = service.getSexPersonList(EnumSex.FEMALE);
        Assert.assertNotNull(SexPersonListOriginal);
    }

    @Test
    public void getSize() {
        listExpect.add(person11);
        listExpect.add(person12);
        listExpect.add(person13);
        listExpect.add(person14);
        listExpect.add(person15);

        Assert.assertEquals(listExpect.size(), service.getSize());

    }

    @Test
    public void getSizeSex_MALE() {
        listExpect.add(person11);
//        listExpect.add(person12);
        listExpect.add(person13);
//        listExpect.add(person14);
        listExpect.add(person15);

        Assert.assertEquals(listExpect.size(), service.getSizeSex(EnumSex.MALE));
    }

    @Test
    public void getSizeSex_FEMALE() {
//        listExpect.add(person11);
        listExpect.add(person12);
//        listExpect.add(person13);
        listExpect.add(person14);
//        listExpect.add(person15);

        Assert.assertEquals(listExpect.size(), service.getSizeSex(EnumSex.FEMALE));
    }

    @Test
    public void getSumOld() {
        Assert.assertEquals(160, service.getSumOld());
    }

    @Test
    public void getSexSumOld() {
        Assert.assertEquals(48, service.getSexSumOld(EnumSex.FEMALE));
    }

    @Test
    public void getAverageOld() {
        Assert.assertEquals(32, service.getAverageOld());
    }

    @Test
    public void getSexAverageOld() {
        Assert.assertEquals(37, service.getSexAverageOld(EnumSex.MALE));
    }

    @Test
    public void newPerson_EMPTY_NAME() {

        for (Person user : service.getPersonList()){
            if (user.getName() != null && user.getName().isEmpty()) {
                Assert.fail("Попытка создания пользователя с пустым именем");
            }
        }
    }

    @Test
    public void newUser_AGE_ZERO() {
        for (Person user : service.getPersonList()) {
            if (user.getOld() <= 0) {
                Assert.fail("Попытка создания пользователя c не допустимым возрастом");
            }
        }
    }

    @Test
    public void newUser_SEX_NO_NULL() {
        for (Person user : service.getPersonList()) {
            if (user.getSex() == null) {
                Assert.fail("Попытка создания пользователя с указанием пола = null");
            }
        }
    }
}
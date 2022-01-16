import Entities.EnumSex;
import Entities.Person;
import Services.Service;

public class Main {
    public static void main(String[] args) {
        Service service = new Service();
        Person person1 = service.createPerson("Jey",39, EnumSex.MALE);
        Person person2 = service.createPerson("Dolly",30, EnumSex.FEMALE);
        Person person3 = service.createPerson("Ron",33, EnumSex.MALE);
        Person person4 = service.createPerson("Germiona",18, EnumSex.FEMALE);
        Person person5 = service.createPerson("Garry",40, EnumSex.MALE);

        System.out.println("Все пользователи:");
        service.getPersonList().stream().forEach(System.out::println);

        System.out.println("Все пользователи: MALE");
        service.getSexPersonList(EnumSex.MALE).forEach(System.out::println);

        System.out.println("Все пользователи: FEMALE");
        service.getSexPersonList(EnumSex.FEMALE).forEach(System.out::println);

        System.out.println("================================================");
        System.out.println("       всех пользователей: " + service.getSize());

        System.out.println("  всех пользователей MALE: " + service.getSizeSex(EnumSex.MALE));

        System.out.println("всех пользователей FEMALE: " + service.getSizeSex(EnumSex.FEMALE));

        System.out.println("================================================");

        System.out.println("       общий возраст всех пользователей: " + service.getSumOld());

        System.out.println("  общий возраст всех пользователей MALE: " + service.getSexSumOld(EnumSex.MALE));

        System.out.println("общий возраст всех пользователей FEMALE: " + service.getSexSumOld(EnumSex.FEMALE));

        System.out.println("================================================");

        System.out.println("       средний возраст всех пользователей: " + service.getAverageOld());

        System.out.println("  средний возраст всех пользователей MALE: " + service.getSexAverageOld(EnumSex.MALE));

        System.out.println("средний возраст всех пользователей FEMALE: " + service.getSexAverageOld(EnumSex.FEMALE));

        System.out.println("================================================");

    }
}

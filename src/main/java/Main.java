import config.HabibEntityMapping;
import model.*;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        HabibEntityMapping habibEntityMapping = new HabibEntityMapping();

        List<HabibTest> habibTestList = List.of(new HabibTest(true, "A", 1D), new HabibTest(true, "A", 12D), new HabibTest(true, "B", 2D));
        Map<String, HabibTest> habibTestMap = new HashMap<String, HabibTest>(2);
        habibTestMap.put("Z", new HabibTest(true, "C", 3D));
        habibTestMap.put("Y", new HabibTest(true, "D", 4D));
        Set<HabibTest> habibTestSet = new HashSet<HabibTest>(3);
        habibTestSet.add(new HabibTest(true, "E", 5D));
        habibTestSet.add(new HabibTest(true, "F", 6D));
        habibTestSet.add(new HabibTest(true, "F", 7D));

        HabibColl habibColl = new HabibColl("Habib", "elahi", habibTestList, habibTestMap, habibTestSet);
        habibEntityMapping.saveObject(habibColl);
        System.out.println(habibColl.toString());


        HabibTest habibTest = new HabibTest();
        habibTest.setName("computer");
        habibTest.setSalary(56.4D);
        habibTest.setType(true);
        habibEntityMapping.saveObject(habibTest);
        System.out.println(habibTest.toString());


        HabibEmbeddableTestPK habibEmbeddableTestPK = new HabibEmbeddableTestPK();
        habibEmbeddableTestPK.setCode("test");
        habibEmbeddableTestPK.setId(habibTest.getId());

        HabibEmbeddableTest test = new HabibEmbeddableTest();
        test.setId(habibEmbeddableTestPK);
        test.setName("test");
        test.setCreationDate(new Date());
        habibEntityMapping.saveObject(test);
        System.out.println(test.toString());

        HabibPerson person = new HabibPerson();
        person.setName("Habib");

        HabibStudent student = new HabibStudent();
        student.setAvg(10);
        student.setPerson(person);

        student.setTest(habibTest);

        List<HabibCourse> courseList = new ArrayList<>();
        HabibCourse habibCourse = new HabibCourse();
        habibCourse.setName("math");

        HabibCourse habibCourse1 = new HabibCourse();
        habibCourse1.setName("math1");
        courseList.add(habibCourse);
        courseList.add(habibCourse1);

        student.setCourseList(courseList);
        habibEntityMapping.saveObject(person);
        habibEntityMapping.saveObject(student);
        System.out.println(student);

        HabibCache habibCache = new HabibCache();
        habibCache.setName("Habib");
        habibEntityMapping.saveObject(habibCache);
        System.out.println(habibCache.toString());
        Employee employee = new Employee();
        employee.setName("Habib");
        habibEntityMapping.saveObject(employee);
        Executive executive = new Executive();
        executive.setRole("manager");
        executive.setName(employee.getName());
        executive.setSalary(1234);
        habibEntityMapping.saveObject(executive);

        Employee employee1 = (Employee) habibEntityMapping.getObjectWithId(employee, 20);
        System.out.println(employee1.toString());

        List<Executive> executiveList = habibEntityMapping.getObjectList(executive);
        executiveList.forEach(n -> System.out.println(n.toString()));


    }
}

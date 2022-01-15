# jfaker-simple
  
Simple data generator  
  
```Java
        Jfaker jfaker = Jfaker.create();

        Person person = jfaker.person();
        System.out.println(person);
        System.out.println(person.getFullName());

        Address address = jfaker.address();
        System.out.println(address);

        Company company = jfaker.company();
        System.out.println(company);

        String text = jfaker.text().alphabetic(5);
        System.out.println(text);

        String textWithNums = jfaker.text().alphaNumeric(12);
        System.out.println(textWithNums);

        String words = jfaker.text().words(3);
        System.out.println(words);
```
Will produce something like this:  
```
Person(firstName=Hadley, lastName=Figueroa, age=51, gender=FEMALE, address=Address(state=OK, city=Seattle, address=18474 550th Hwy, zipCode=43302))
Hadley Figueroa
Address(state=NY, city=Indianapolis, address=18474 550th Hwy, zipCode=30233)
Company(name=Protective Life Corporation, domain=Telecom, website=investor.se)
kgtbi
fd6l4uqqJnRx
property crop raise
```

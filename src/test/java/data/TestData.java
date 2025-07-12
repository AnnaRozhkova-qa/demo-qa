package data;

import com.github.javafaker.Faker;

import java.util.Locale;

import static java.lang.String.format;

public class TestData {

   public static Faker faker = new Faker(new Locale("eng"));

   public static String firstName = faker.name().firstName(), // Emory
           lastName = faker.name().lastName(),
           userEmail = faker.internet().emailAddress(),
           userGender = faker.demographic().sex(),
           userNumber = faker.phoneNumber().subscriberNumber(10),
           userDay = format("%02d", faker.number().numberBetween(1, 9)),
           userMonth = faker.options().option("January", "February", "March", "April",
                   "May", "June", "July", "August", "September", "October", "November", "December"),
           userYear = format("%s", faker.number().numberBetween(1900, 2025)),
           userSubject = faker.options().option("Accounting", "Maths", "Arts", "English", "Physics", "Chemistry",
                   "Computer Science", "Economics", "Social Studies", "History", "Civics",
                   "Commerce", "Hindi", "Biology"),
           userHobbies = faker.options().option("Reading", "Sports", "Music"),
           userPicture = "test.png",
           userAddress = faker.address().fullAddress(),
           userState = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan"),
           userCity = getCity(userState);


   public static String getCity(String userState) {
      return switch (userState) {
         case "NCR" -> faker.options().option("Delhi", "Gurgaon", "Noida");
         case "Uttar Pradesh" -> faker.options().option("Agra", "Lucknow", "Merrut");
         case "Haryana" -> faker.options().option("Karnal", "Panipat");
         case "Rajasthan" -> faker.options().option("Jaipur", "Jaiselmer");
         default -> null;
      };
   }
}
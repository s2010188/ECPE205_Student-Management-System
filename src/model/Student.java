package model;

/**
 * Data model representing a Student.
 * 
 * ASSIGNED TO: Student 1 (Data Model Owner)
 * 
 * TODO for Student 1:
 * - Add more fields as needed (e.g., email, course, yearLevel, contactNumber)
 * - Add validation logic (e.g., age must be positive, name not empty)
 * - Add a toString() method for display purposes
 * - Add a method to return data as an Object[] array for table display
 */
public class Student {
  private String id;
  private String name;
  private int age;
  private String email;
  private String course;
  private int yearLevel;
  private int contactNumber;

    public int getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(int contactNumber) {
        this.contactNumber = contactNumber;
    }

    public int getYearLevel() {
        return yearLevel;
    }

    public void setYearLevel(int yearLevel) {
        this.yearLevel = yearLevel;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Student(String id, String name, int age) {
    this.id = id;
    this.name = name;
    this.age = age;
  }

  // --- Getters ---
  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  // --- Setters ---
  public void setId(String id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setAge(int age) {
    this.age = age;
  }



  @Override
  public String toString() {
    return id + " - " + name + " (Age: " + age + ")";
  }

  /**
   * Returns student data as an Object array, useful for JTable rows.
   */
  public Object[] toTableRow() {
    return new Object[] { id, name, age, email, course, yearLevel, contactNumber};
  }
}

public class Problem2 {
    public static void main(String[] args) {
        Course COSC2429 = new Course("COSC2429", "Intro to Programming", 58);
        Course COSC2081 = new Course("COSC2081", "Programming 1", 58);

        COSC2429.display();
        COSC2081.display();

        COSC2081.showPrerequisite();

        COSC2081.addPrerequisite(COSC2081);
        COSC2081.addPrerequisite(COSC2429);

        COSC2081.showPrerequisite();
    }
}

class Course {
    String code;
    String name;
    int credits;
    private Course prerequisite[] = new Course[3];

    Course(String code, String name, int credits) {
        this.code = code;
        this.name = name;
        this.credits = credits;
    }

    // print the course's information
    public void display() {
        System.out.printf("\nCourse code: %s\nCourse name: %s\nNumber of credits: %d\n", code, name, credits);
    }

    // print the presiquisites of the course
    public void showPrerequisite() {
        // check if there is prerequisite
        if (prerequisite[0] != null) {
            System.out.println("\nPrerequisites:");
            // loop through and print all the prerequisites
            for (int i = 0; i < prerequisite.length; i++) {
                if (prerequisite[i] != null) {
                    prerequisite[i].display();
                    continue;
                }
            }
            // if there are no prerequisites
        } else {
            System.out.printf("\nNo prerequisites\n");
        }
    }

    // add a prerequisite to a course
    public void addPrerequisite(Course preCourse) {
        // index of the new prerequisite
        int index = 0;
        // check if the new prerequisite is different from the current course
        if (preCourse.code != this.code) {
            // loop throught all the prerequisites of the current course
            for (int i = 0; i < this.prerequisite.length; i++) {
                // check if the current course has no prerequisite
                if (this.prerequisite[i] == null) {
                    // add the new course to the prerequisite array of the current course
                    this.prerequisite[i] = preCourse;
                    break;
                }
                // if there are prerequisites in the array, check if the new course is different
                if (this.prerequisite[i].code != preCourse.code) {
                    // increase the index to add new course next to prerequisites
                    index = i + 1;
                }
            }
            // check if there is less then 3 prerequisites
            if (index < 3) {
                this.prerequisite[index] = preCourse;
            }
        }
    }
}
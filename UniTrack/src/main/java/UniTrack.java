import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class UniTrack {

    

    private static int universalNum = 0;
    private static HashMap<String, String> userAndPass = new HashMap<>(); // Ensure data safety
    private static int numProfiles = 0;
    private static URL resourceUrl;
    private static List<Runnable> exitTasks = new ArrayList<>();
    private static HashMap<String ,User> userList = new HashMap<>();
    private static University[] Universities;
    private static String[] Courses;

    public static void main(String[] args) throws IOException, InterruptedException {
        setCourses(readCourses());
        setUniversities(readUniversities());
        if (getNumProfiles() == 0) {
            ChoiceScreen screen = new ChoiceScreen();
            screen.setVisible(true);
            screen.toFront();
        } 
        else {
            profileSelectScreen screen = new profileSelectScreen();
            screen.setVisible(true);
            screen.toFront();
        }
    }

    public static HashMap<String, String> getUserAndPass() {
        return userAndPass;
    }
    
    public static String[] readCourses() throws IOException {
        InputStream is = UniTrack.class.getClassLoader().getResourceAsStream("university_info.txt");
        if (is == null) {
            throw new IOException("Resource not found: university_info.txt");
        }

        try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            String firstLine = br.readLine();
            if (firstLine != null) {
                return firstLine.split(",");
            }
        }

        return new String[0];
    }

    public static University[] readUniversities() throws IOException {
        InputStream is = UniTrack.class.getClassLoader().getResourceAsStream("university_info.txt");
        if (is == null) {
            throw new IOException("Resource not found: university_info.txt");
        }

        ArrayList<University> universities = new ArrayList<>();
        ArrayList<Program> programs = new ArrayList<>();
        University currentUniversity = null;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            String line;
            br.readLine(); // Skip the first line containing courses
            while ((line = br.readLine()) != null) {
                if (line.startsWith("#")) {
                    if (currentUniversity != null) {
                        currentUniversity = new University(currentUniversity.getName(), programs.toArray(new Program[0]));
                        universities.add(currentUniversity);
                        programs = new ArrayList<>();
                    }
                    currentUniversity = new University(line.substring(1), null);
                } else if (line.startsWith("-") && currentUniversity != null) {
                    String[] parts = line.substring(1).split(",");
                    String programName = parts[0];
                    double requiredGrade = Double.parseDouble(parts[1]);
                    String[] requiredCourses = Arrays.copyOfRange(parts, 2, parts.length);
                    programs.add(new Program(programName, requiredGrade, requiredCourses));
                }
            }
            if (currentUniversity != null) {
                currentUniversity = new University(currentUniversity.getName(), programs.toArray(new Program[0]));
                universities.add(currentUniversity);
            }
        }

        return universities.toArray(new University[0]);
    }
    
    public static void addTask(Runnable task) {
        exitTasks.add(task);
    }

    public static void endProgram() {
        for (Runnable task : exitTasks) {
            try {
                task.run();
            } catch (Exception ex) {
                Logger.getLogger(UniTrack.class.getName()).log(Level.SEVERE, "Error executing exit task", ex);
            }
        }
        System.exit(0);
    }

    public static void saveCreds() {
        for(User u: userList.values()){
            String fileName = u.getUsername() + ".txt";

            // Get user's Documents directory
            String documentsDir = System.getProperty("user.home") + "/Documents";

            // Directory where UniTrack Users folder will be created
            File uniTrackUsersDir = new File(documentsDir, "UniTrack Users");

            // Create the UniTrack Users directory if it doesn't exist
            if (!uniTrackUsersDir.exists()) {
                if (!uniTrackUsersDir.mkdirs()) {
                    return;
                }
            }

            // File path for credentials file
            File credentialsFile = new File(uniTrackUsersDir, fileName);

            try (FileWriter writer = new FileWriter(credentialsFile)) {
                // Write credentials to file
                writer.write(u.getUsername() + " | " + u.getPassword() + "\n");
                System.out.println("W");
            } catch (IOException e) {
                Logger.getLogger(UniTrack.class.getName()).log(Level.SEVERE, "Error writing credentials", e);
                System.out.println("L");
            }
        }
    }
    
    public static void saveCourses(){
        
    }
    /**
     * @return the universalNum
     */
    public static int getUniversalNum() {
        return universalNum;
    }

    /**
     * @param aUniversalNum the universalNum to set
     */
    public static void setUniversalNum(int aUniversalNum) {
        universalNum = aUniversalNum;
    }

    /**
     * @param aUserAndPass the userAndPass to set
     */
    public static void setUserAndPass(HashMap<String, String> aUserAndPass) {
        userAndPass = aUserAndPass;
    }

    /**
     * @return the numProfiles
     */
    public static int getNumProfiles() {
        return numProfiles;
    }

    /**
     * @param aNumProfiles the numProfiles to set
     */
    public static void setNumProfiles(int aNumProfiles) {
        numProfiles = aNumProfiles;
    }

    /**
     * @return the resourceUrl
     */
    public static URL getResourceUrl() {
        return resourceUrl;
    }

    /**
     * @param aResourceUrl the resourceUrl to set
     */
    public static void setResourceUrl(URL aResourceUrl) {
        resourceUrl = aResourceUrl;
    }
    /**
     * @return the userList
     */
    public static HashMap<String ,User> getUserList() {
        return userList;
    }

    /**
     * @param aUserList the userList to set
     */
    public static void setUserList(HashMap<String ,User> aUserList) {
        userList = aUserList;
    }
    
    /**
     * @return the Universities
     */
    public static University[] getUniversities() {
        return Universities;
    }
    
    public static String[] getUniversityNames(){
        String[] names = new String[Universities.length];
        for(int x=0; x<Universities.length; x++){
            names[x]=Universities[x].getName();
        }
        return names;
    }
    
    public static University getUniversity(String n){
        for(University u:Universities){
            if(u.getName().equals(n)) return u;
        }
        return null;
    }

    /**
     * @param aUniversities the Universities to set
     */
    public static void setUniversities(University[] aUniversities) {
        Universities = aUniversities;
    }

    /**
     * @return the Courses
     */
    public static String[] getCourses() {
        return Courses;
    }

    /**
     * @param aCourses the Courses to set
     */
    public static void setCourses(String[] aCourses) {
        Courses = aCourses;
    }
}

import java.util.*;
import java.time.LocalTime;
class User
{
    int id;
    String name;
    String email;
    public User(int id, String name, String email)
    {
        this.id = id;
        this.name = name;
        this.email = email;
    }
}
public class Chatbot 
{
    static HashMap<String, String[]> hm = new HashMap<>();
    static HashMap<String, String> eng_comp_hm = new HashMap<>();
    static HashMap<String, String> eng_it_hm = new HashMap<>();
    static List<User> userlist = new ArrayList<>();
    static int idIndex = 1;

    static void initializeHM()
    {
        String[] greet = {"Hello", "Hii", "Hello.. Welcome..!", "hello, nice to see you"};
        hm.put("greet", greet); 
        
        hm.put("institute", new String[]{"Engineering", "Pharmacy", "Management", "Technology, Polytechnic(B.Tech, Diploma)", "Information Technology(C-DAC-ATC)"});

        String[] eng_dept = {"Computer", "Information Technology", "Electrical", "Civil", "Electronics & Telecommunication", "Mechanical", "Artificial Intelligence & Data Science"};
        hm.put("eng_dept", eng_dept);

        hm.put("pharmacy_cource", new String[]{"Bachelor of Pharmacy", "Pharma D", "Diploma in Pharmacy", "Master of Pharmacy"});

        hm.put("management_cource", new String[]{"Master of Business Administration(MBA)", "Ph.D in MBA"});

        hm.put("technology_cource", new String[]{"B. Tech in Civil Engineering", "B. Tech in Computer Science and Design Engineering", "B. Tech in Automation and Robotics", "Diploma in Civil Engineering", "Diploma in Computer Engineering", "Diploma in Electrical Engineering", "Diploma in Information Technology", "Diploma in Mechanical Engineering"});

        hm.put("it_cource", new String[]{"PG-DAC", "PRE-CAT"});

        // Initialize Hashmap for cource
        eng_comp_hm.put("Department", "Computer Engineering");
        eng_comp_hm.put("Accrediated by", "National Board of Accrediation(NBA)");
        eng_comp_hm.put("DTE Choice Code", "515124510");
        eng_comp_hm.put("Intake", "120");
        eng_comp_hm.put("Total fees", "4 Lakh");
        eng_comp_hm.put("H.O.D.", "Dr. M. U. Kharat");
        
        
        eng_it_hm.put("Department", "Information Technology Engineering");
        eng_it_hm.put("DTE Choice Code", "515124610");
        eng_it_hm.put("Total fees", "4 Lakh");
        eng_it_hm.put("Intake", "60");
        eng_it_hm.put("H.O.D.", "Dr. S. V. Ghumaste");

    }
    public static void main(String[] args) 
    {
        initializeHM();

        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        System.out.println("\t!-----Welcome to MET-----!\n");
        boolean proceed = false;
        
        User user = new User(0, "", "");
        do
        {
            if(proceed == false)
            {

                System.out.println("\nBot >> Please Enter following information\n");
                System.out.print("\tEnter Name : ");
                String name = sc.nextLine();
                System.out.print("\tEnter Email Id : ");
                String email = sc.nextLine();

                if(name.isEmpty())
                {
                    System.out.println("\n\tPlease provide name");
                    continue;
                }
                if(email.contains("@") && email.contains(".") && email.indexOf("@") > 0 && email.indexOf("@") < email.length()-1 && email.indexOf(".") > 0 && email.lastIndexOf(".") < email.length()-1 && email.indexOf("@") < email.lastIndexOf(".") && !name.isEmpty())
                {
                    user = new User(idIndex++, name, email);
                    userlist.add(user);
                    proceed = true;

                    int index = random.nextInt(hm.get("greet").length);
                    System.out.print("\nBot >> " + hm.get("greet")[index] + " " + user.name);
                    LocalTime time = LocalTime.now();
                    int hr = time.getHour();
                    if(hr >= 6 && hr <= 12)
                    {
                        System.out.print(", Good Morning..!\n");
                    }
                    else if (hr >=12 && hr <= 18)
                    {
                        System.out.print(", Good afternoon..!\n");
                    }
                    else {
                        System.out.print(", Good evening..!\n");
                    }
                    System.out.println("\t How I can help you?");
                }
                else{
                    System.out.println("\tInvalid Email Id");
                }
            }

            if(proceed == true)
            {
                System.out.print("You >> ");
                String input = sc.nextLine().toLowerCase();
                if(input.contains("hi") || input.contains("hii") || input.contains("hello") || input.contains("hey") || input.contains("morning") || input.contains("afternoot") || input.contains("evening"))
                {
                    int index = random.nextInt(hm.get("greet").length);
                    System.out.print("Bot >> " + hm.get("greet")[index] + " " + user.name);

                    // greet respected to time
                    LocalTime time = LocalTime.now();
                    int hr = time.getHour();
                    if(hr >= 6 && hr <= 12)
                    {
                        System.out.print(", Good Morning..!\n");
                    }
                    else if (hr >=12 && hr <= 18)
                    {
                        System.out.print(", Good afternoon..!\n");
                    }
                    else {
                        System.out.print(", Good evening..!\n");
                    }
                    System.out.println("\t How I can help you?");
                }
                else if(input.contains("about")|| input.contains("details") && input.contains("met"))
                {
                    System.out.println("Bot >> \n");
                    System.out.println("\tMET Bhujbal Knowledge City");
                    System.out.println("\t\tAs sharp as you can get");
                    System.out.println("\tLocation : Adgaon, National Highway 3, Nashik, Maharashtra 422003");
                    System.out.println("\t------Institutes------");
                    String[] arr = hm.get("institute");
                    for(int i = 0; i < arr.length; i++)
                    {
                        System.out.println("\t\t" + (i + 1) + " Institute of " + arr[i]);
                    }
                    
                    System.out.println("\n\tContact : 0253-2303515 / 9881100099, enquiries@bkc.met.edu");
                    System.out.println("\n\tFor more details visit : https://metbhujbalknowledgecity.ac.in/");
                    System.out.println("\n\tFor Fees Details : https://collegedunia.com/college/57415-met-bhujbal-knowledge-city-nashik/courses-fees\n");

                }
                else if(input.contains("computer") && !input.contains("diploma"))
                {
                    System.out.println("Bot >>");
                    System.out.println("\tDepartment : Computer Engineering");
                    System.out.println("\tAccrediated by : National Board of Accrediation(NBA)");
                    System.out.println("\tDTE Choice Code : 515124510");
                    System.out.println("\tIntake : 120");
                    System.out.println("\tTotal fees : 4 Lakh");
                    System.out.println("\tH.O.D. : Dr. M. U. Kharat");

                    System.out.println();
                }
                else if(input.contains("information technology") && !input.contains("diploma"))
                {
                    System.out.println("Bot >>");
                    System.out.println("\tDepartment : Information Technology Engineering");
                    System.out.println("\tAccrediated by : National Board of Accrediation(NBA)");
                    System.out.println("\tDTE Choice Code : 515124510");
                    System.out.println("\tIntake : 60");
                    System.out.println("\tTotal fees : 4 Lakh");
                    System.out.println("\tH.O.D. : Dr. S. V. Ghumaste");

                    System.out.println();
                }
                else if(input.contains("engineer") && !input.contains("computer")&& !input.contains("information")&& !input.contains("civil")&& !input.contains("mechnaical")&& !input.contains("electr")&& !input.contains("artificial"))
                {
                    System.out.println("Bot >> \n\tEnginnering Departments in MET");
                    String[] arr = hm.get("eng_dept");
                    for(int i = 0; i < arr.length; i++)
                    {
                        System.out.println("\t\t" + (i + 1) + " " + arr[i] + " Enginnering");
                    }
                    System.out.println("\n\tFor more details visit : https://metbhujbalknowledgecity.ac.in/metengg/");
                }
                else if(input.contains("pharmacy"))
                {
                    System.out.println("Bot >> \n\tPharmacy Cources in MET");
                    String[] arr = hm.get("pharmacy_cource");
                    for(int i = 0; i < arr.length; i++)
                    {
                        System.out.println("\t\t" + (i + 1) + " " + arr[i]);
                    }
                    System.out.println("\n\tFor more details visit : https://metbhujbalknowledgecity.ac.in/metpharm/");
                }
                else if(input.contains("management"))
                {
                    System.out.println("Bot >> \n\tManagement Cources in MET");
                    String[] arr = hm.get("management_cource");
                    for(int i = 0; i < arr.length; i++)
                    {
                        System.out.println("\t\t" + (i + 1) + " " + arr[i]);
                    }
                    System.out.println("\n\tFor more details visit : https://metbhujbalknowledgecity.ac.in/metmba/");
                }
                else if(input.contains("technology") || input.contains("polytechnic"))
                {
                    System.out.println("Bot >> \n\tTechnology and Ploytechnic Cources");
                    String[] arr = hm.get("technology_cource");
                    for(int i = 0; i < arr.length; i++)
                    {
                        System.out.println("\t\t" + (i + 1) + " " + arr[i]);
                    }
                    System.out.println("\n\tFor more details visit : https://metbhujbalknowledgecity.ac.in/metpoly/");
                }
                else if(input.contains("information technology"))
                {
                    System.out.println("Bot >> \n\tInformation Technology(C-DAC-ATC) Cources");
                    String[] arr = hm.get("it_cource");
                    for(int i = 0; i < arr.length; i++)
                    {
                        System.out.println("\t\t" + (i + 1) + " " + arr[i]);
                    }
                    System.out.println("\n\tFor more details visit : https://metbhujbalknowledgecity.ac.in/metiit/");
                }
                else if(input.contains("institute") && !input.contains("engineer") && !input.contains("pharmacy") && !input.contains("management") && !input.contains("technology"))
                {
                    System.out.println("Bot >> \n\tInstitues in MET");
                    String[] arr = hm.get("institute");
                    for(int i = 0; i < arr.length; i++)
                    {
                        System.out.println("\t\t" + (i + 1) + " Institute of " + arr[i]);
                    }
                }
                else if(input.contains("exit") || input.contains("bye") || input.contains("quite"))
                {
                    System.out.println("Bot >> Thank you...! Have a nice day..");
                    break;
                }
                else if((input.contains("add") || input.contains("new")) && input.contains("user"))
                {
                    proceed = false;
                }
                else if((input.contains("show") || input.contains("display")) && input.contains("user"))
                {
                    System.out.println("Bot >> All Users");
                    for(User u : userlist)
                    {
                        System.out.println("\n\tId : " + u.id);
                        System.out.println("\tName : " + u.name);
                        System.out.println("\tEmail : " + u.email);
                    }
                }
                else
                {
                    System.out.println("Bot >> Incomplete input..! Provide more detail");
                    System.out.println("\tHow I can help you?");
                }
            }   
        }
        while(true);  
        sc.close();
    }    
}

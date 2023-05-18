import java.util.*;
public class MedicalExpertSytem 
{
    static HashMap<String, String[]> disease = new HashMap<>();
    static HashMap<String, String[]> remedies = new HashMap<>();
    static HashMap<String, String[]> hospital = new HashMap<>();
    static HashMap<String, String[]> facilities = new HashMap<>();

    static void initializeHM()
    {
        disease.put("Common Cold", new String[] {"sore throat", "runny nose", "cough", "fever"});
        disease.put("Flu", new String[] {"fever", "body aches", "headache", "cough"});
        disease.put("Stomach Flu", new String[] {"diarrhea", "vomiting", "abdominal cramps", "fever"});
        disease.put("Migraine", new String[] {"headache", "nausea", "sensitivity to light and sound"});
        disease.put("Asthma", new String[] {"wheezing", "shortness of breath", "coughing", "chest tightness"});
        disease.put("Diabetes", new String[] {"frequent urination", "increased thirst", "blurred vision", "fatigue"});
        disease.put("Hypertension", new String[] {"high blood pressure", "headache", "chest pain"});
        disease.put( "Pneumonia", new String[] {"cough", "fever", "difficulty breathing", "chest pain"});

        remedies.put("Common Cold", new String[] {"Rest", "Hydration", "Over-the-counter medications for symptoms"});
        remedies.put("Flu", new String[] {"Rest", "Hydration", "Antiviral medications"});
        remedies.put("Stomach Flu", new String[] {"Rest", "Hydration", "Oral rehydration solutions", "Antidiarrheal medications"});
        remedies.put("Migraine", new String[] {"Rest in dark room", "Pain relievers", "Triptans"});
        remedies.put("Asthma", new String[] {"Inhaled corticosteroids", "Bronchodilators", "Lifestyle changes"});
        remedies.put("Diabetes", new String[] {"Blood sugar monitoring", "Insulin therapy", "Lifestyle changes"});
        remedies.put("Hypertension", new String[] {"Lifestyle changes", "Medications", "Regular blood pressure monitoring"});
        remedies.put( "Pneumonia", new String[] {"Antibiotics", "Rest", "Hydration", "Pain relievers"});


        hospital.put("Common Cold", new String[] {"Apolo", "Silver"});
        hospital.put("Flu", new String[] {"Lokmanya", "Shyadri"});
        hospital.put("Stomach Flu", new String[] {"Sahyadri"});
        hospital.put("Migraine", new String[] {"Lokseva"});
        hospital.put("Asthma", new String[] {"Rakshak", "Sanjivani", "Apolo"});
        hospital.put("Diabetes", new String[] {"Sanjivani"});
        hospital.put("Hypertension", new String[] {"GuruKrupa", "Lokseva"});
        hospital.put( "Pneumonia", new String[] {"Atharva", "GuruKrupa"});

        facilities.put("Apolo", new String[] {"8765432514", "Health Checkups", "Allopathy & Homeopathy", "ECG Services", "Cardiogy", "X-Ray"});
        facilities.put("Silver", new String[] {"8765432514", "Physiotherapy", "ECG Services", "Dental facility"});
        facilities.put("Lokmanya", new String[] {"8765432514", "Dental facility", "ECG Services", "Dialysis Centers"});
        facilities.put("Sahyadri", new String[] {"8765432514", "Physiotherapy", "ECG Services"});
        facilities.put("Lokseva", new String[] {"8765432514", "Orthopedic", "Dialysis Centers", "Blood banks"});
        facilities.put("Rakshak", new String[] {"8765432514", "Cardiogy", "Orthopedic"});
        facilities.put("Sanjivani", new String[] {"8765432514", "Allopathy & Homeopathy", "Cardiogy", "Citiscan", "Dialysis Centers"});
        facilities.put( "GuruKrupa", new String[] {"8765432514", "ECG Services", "GuruKrupa"});
        facilities.put( "Atharva", new String[] {"8765432514", "Orthopedic", "ECG Services"});
    }
    public static void main(String[] args) 
    {
        initializeHM();
        Scanner sc = new Scanner(System.in);
        System.out.println("-------Medical Expert System-------");
        System.out.print("Enter Symptoms sepearated by commas: ");
        String[] input = sc.nextLine().toLowerCase().split(",");
        
        boolean flag = true, flag2 = false;
        for (Map.Entry<String, String[]> entry : disease.entrySet()) 
        {
            String[] symptoms = entry.getValue();
            for(int i = 0; i < symptoms.length; i++)
            {
                flag = false;
                for(int j = 0; j < input.length; j++)
                {
                    if(symptoms[i].equals(input[j].trim()))
                    {
                        flag = true;
                    }
                }

                if(flag == false)
                {
                    break;
                }
            }
            if(flag == true)
            {
                flag2 = true;
                System.out.println("Disease : " + entry.getKey());

                String[] remedy = remedies.get(entry.getKey());
                System.out.println("\tLocal Remedies : ");
                for(int i = 0; i < remedy.length; i++)
                {
                    System.out.println("\t\t" + (i+1) + ". " + remedy[i]);
                }

                String[] hps = hospital.get(entry.getKey());
                for(int i = 0; i < hps.length; i++)
                {
                    System.out.println("\tSuugested Hospital : " + hps[i] + "\n\tFacilities Available :");
                    String[] facility = facilities.get(hps[i]);
                    for(int j = 1; j < facility.length; j++)
                    {
                        System.out.println("\t\t" + (j+1) + ". " + facility[j]);
                    }
                    System.out.println("\t\t Contact : " + facility[0]);
                }
            }
        }
        if(flag2 == false)
        {
            System.out.println("\n\tDisable to detect disease. Please visit suggested hospitals\n");
                {
                    int i = 1;
                    for(Map.Entry<String, String[]> e : facilities.entrySet())
                    {
                        System.out.println("\t" + (i++) +" " + e.getKey());
                    }
                }
        }
        sc.close();
    }
}

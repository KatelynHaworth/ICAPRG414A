package au.id.haworth.ICAPRG414A;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.TreeMap;

/**
 * This class handles the creation and storage
 * of Job objects
 *
 * @author Liam Haworthj
 * @version 1.0
 */
public class JobRegister {

    private static final TreeMap<Integer, Job> idToJobMap = new TreeMap<>();

    /**
     * Generates a new Job objects and stores it in the register
     *
     * @param name The jobs Client's first name
     * @param surname The jobs Client's last name
     * @param address The address of the Job
     * @param suburb The suburb of the Job
     * @param postcode The postcode of the Job
     * @param date The date of when the job is meant to be done
     * @param hoursWorked The hours spent working on the job
     * @param jobDetails Any details about the job
     * @param completed If the job is completed
     * @param price The cost of the job for the client
     * @param paid Has the client paid
     *
     * @throws IllegalArgumentException
     *
     * @return int
     */
    public static int newJob(String name, String surname,
                             String address, String suburb, int postcode,
                             Date date, int hoursWorked, String jobDetails, boolean completed,
                             int price, boolean paid) throws IllegalArgumentException {
        try {
            int nextJobId = idToJobMap.size();

            Job newJob = new Job(nextJobId, name, surname, address, suburb, postcode, date, hoursWorked, jobDetails, completed, price, paid);
            idToJobMap.put(nextJobId, newJob);

            return nextJobId;
        }
        catch(IllegalArgumentException ex) {
            throw ex;
        }
        catch(Exception ex) {
            throw new RuntimeException("A unknown error occurred when creating a new Job object", ex);
        }
    }

    /**
     * Updates an existing job with new details
     *
     * @param jobID ID the Job
     * @param name The jobs Client's first name
     * @param surname The jobs Client's last name
     * @param address The address of the Job
     * @param suburb The suburb of the Job
     * @param postcode The postcode of the Job
     * @param date The date of when the job is meant to be done
     * @param hoursWorked The hours spent working on the job
     * @param jobDetails Any details about the job
     * @param completed If the job is completed
     * @param price The cost of the job for the client
     * @param paid Has the client paid
     *
     * @throws IllegalArgumentException
     */
    public static void updateJob(int jobID, String name, String surname,
                                 String address, String suburb, int postcode,
                                 Date date, int hoursWorked, String jobDetails, boolean completed,
                                 int price, boolean paid) throws IllegalArgumentException {
        try {
            Job updatedJob = new Job(jobID, name, surname, address, suburb, postcode, date, hoursWorked, jobDetails, completed, price, paid);
            idToJobMap.remove(jobID);
            idToJobMap.put(jobID, updatedJob);
        } catch (IllegalArgumentException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new RuntimeException("A unknown error occurred when creating a new Job object", ex);
        }
    }

    /**
     * Returns an array of all Jobs registered
     * in the register
     *
     * @return Collection
     */
    public static Collection<Job> getJobList() {
        return idToJobMap.values();
    }

    /**
     * Looks in the register for a Job with the provided ID
     * and returns it when it exists
     *
     * @param jobID The ID of the Job
     * @return Job
     */
    public static Job getJob(int jobID) {
        return idToJobMap.get(jobID);
    }

    /**
     * Removes a Job from the register and returns it if it existed
     *
     * @param jobID The ID of the Job
     * @return Job
     */
    public static Job removeJobFromRegister(int jobID) {
        return idToJobMap.remove(jobID);
    }

    public static void saveJobsToFile(File selectedFile) {
        if(!selectedFile.getName().endsWith(".jobs"))
            selectedFile = new File(selectedFile.getParentFile(), selectedFile.getName() + ".jobs");

        Gson gson = new Gson();
        Object[] jobsArray = idToJobMap.values().toArray();

        String jsonArray = gson.toJson(jobsArray);

        try {
            BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(selectedFile));
            outputStream.write(jsonArray.getBytes("UTF-8"));
            outputStream.flush();
            outputStream.close();
        }
        catch(IOException ex) {
            throw new RuntimeException("Failed to save data file!", ex);
        }
    }

    public static void loadJobsFromFile(File selectedFile) {
        try {
            byte[] jsonArrayData = new byte[(int) selectedFile.length()];
            BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(selectedFile));

            if(inputStream.read(jsonArrayData) != jsonArrayData.length)
                throw new IOException("Failed to read all data from file!");

            inputStream.close();

            Gson gson = new Gson();
            String jsonArray = new String(jsonArrayData);

            Object[] jobsArray = gson.fromJson(jsonArray, Object[].class);

            for(Object jobObject : jobsArray) {
                LinkedTreeMap jobData = (LinkedTreeMap) jobObject;

                SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy hh:mm:ss a");
                Date date = dateFormat.parse((String) jobData.get("date"));

                Job job = new Job(((Double) jobData.get("jobID")).intValue(),
                                  (String) jobData.get("name"), (String) jobData.get("surname"), (String) jobData.get("address"), (String) jobData.get("suburb"), ((Double) jobData.get("postcode")).intValue(),
                                  date, ((Double) jobData.get("hoursWorked")).intValue(), (String) jobData.get("jobDetails"), (boolean) jobData.get("completed"), ((Double) jobData.get("price")).intValue(), (boolean) jobData.get("paid"));

                idToJobMap.put(job.getJobID(), job);
            }
        }
        catch(IOException ex) {
            throw new RuntimeException("Failed to read data file!", ex);
        }
        catch(ParseException ex) {
            throw new RuntimeException("Failed to build date object from data file data", ex);
        }
    }
}

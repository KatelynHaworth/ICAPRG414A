package au.id.haworth.liam.ICAPRG414A;

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
}

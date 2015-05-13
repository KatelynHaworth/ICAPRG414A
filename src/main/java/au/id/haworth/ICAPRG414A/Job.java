package au.id.haworth.ICAPRG414A;

import java.util.Date;

/**
 * This class is a data handler for Job
 * information storage
 *
 * @author Liam Haworth
 * @version 1.0
 */
public class Job {

    /**
     * The ID Number of the Job
     */
    private final int jobID;

    /**
     * First Name of Client
     */
    private String name;

    /**
     * Last Name of Client
     */
    private String surname;

    /**
     * The address of the client at which the jon shall happen
     */
    private String address;

    /**
     * The suburb of the client
     */
    private String suburb;

    /**
     * The postcode of the client
     */
    private int postcode;

    /**
     * The date of when the job was done
     */
    private Date date;

    /**
     * The hours spent working on the job
     */
    private int hoursWorked;

    /**
     * Any details to do with the job
     */
    private String jobDetails;

    /**
     * The job is completed
     */
    private boolean completed;

    /**
     * The price of the job for the client
     */
    private int price;

    /**
     * Has the client paid for the work done
     */
    private boolean paid;

    /**
     * Constructs a new Job object with the information provided through arguments
     *
     * @param jobID ID the Job
     * @param name The jobs Client's first name
     * @param surname The jobs Client's last name
     * @param address The address of the Job
     * @param suburb The suburb of the Job
     * @param postcode The postcode of the Job
     *
     * @throws IllegalArgumentException
     */
    public Job(int jobID,
               String name, String surname,
               String address, String suburb, int postcode)

            throws IllegalArgumentException {

        if(jobID < 0)
            throw new IllegalArgumentException("Job ID cannot be less than 0");

        if(postcode < 3000 || postcode > 3999)
            throw new IllegalArgumentException("The postcode of a Job must be a valid Melbourne postcode");

        this.jobID = jobID;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.suburb = suburb;
        this.postcode = postcode;
    }

    /**
     * Constructs a new Job object with the information provided through arguments
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
    public Job(int jobID,
               String name, String surname,
               String address, String suburb, int postcode,
               Date date, int hoursWorked, String jobDetails, boolean completed,
               int price, boolean paid)

            throws IllegalArgumentException{

        if(name == null || name.equals("") || surname == null || surname.equals(""))
            throw new IllegalArgumentException("First and surname fields can not be empty or null");
        
        if(address == null || address.equals("")) 
            throw new IllegalArgumentException("Address can not be empty ot null");
        
        if(suburb == null || suburb.equals(""))
            throw new IllegalArgumentException("Suburb can not be empty or null");
        
        if(jobDetails == null || jobDetails.equals(""))
            throw new IllegalArgumentException("A job must contain details (field is either empty or null)");
        
        if(jobID < 0)
            throw new IllegalArgumentException("Job ID cannot be less than 0");

        if(postcode < 3000 || postcode > 3999)
            throw new IllegalArgumentException("The postcode of a Job must be a valid Melbourne postcode");

        if(hoursWorked < 0)
            throw new IllegalArgumentException("The hours worked on a job cannot be less than 0");

        if(price < 0)
            throw new IllegalArgumentException("The cost of a job cannot be less than 0");

        if(completed && !paid)
            throw new IllegalArgumentException("A job cannot be set as \"completed\" if it hasn't been set as \"paid\"");

        this.jobID = jobID;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.suburb = suburb;
        this.postcode = postcode;
        this.date = date;
        this.hoursWorked = hoursWorked;
        this.jobDetails = jobDetails;
        this.completed = completed;
        this.price = price;
        this.paid = paid;
    }

    /**
     * Gets the ID of the Job
     *
     * @return int
     */
    public int getJobID() {
        return jobID;
    }

    /**
     * Returns the Client name for this Job
     *
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the Client's name for this Job
     *
     * @param name The Client's first name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the Client's surname for this Job
     *
     * @return String
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Sets the Client's surname for this Job
     *
     * @param surname The Client's surname
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * Gets the address for this Job
     *
     * @return String
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the address for this Job
     *
     * @param address The address for this Job
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets the suburb for this Job
     *
     * @return String
     */
    public String getSuburb() {
        return suburb;
    }

    /**
     * Sets the suburb for this Job
     *
     * @param suburb The suburb for this Job
     */
    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    /**
     * Gets the postcode for this Job
     *
     * @return int
     */
    public int getPostcode() {
        return postcode;
    }

    /**
     * Sets the postcode of this Job
     *
     * @param postcode The postcode of this job
     */
    public void setPostcode(int postcode) {
        this.postcode = postcode;
    }

    /**
     * Gets the date this Job is meant to be completed
     *
     * @return Date
     */
    public Date getDate() {
        return date;
    }

    /**
     * Sets the date this Job is meant to be completed
     *
     * @param date The date this Job needs to be completed
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Gets the hours worked on this Job so far
     *
     * @return int
     */
    public int getHoursWorked() {
        return hoursWorked;
    }

    /**
     * Sets the hours worked on this Job
     *
     * @param hoursWorked The hours worked
     */
    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    /**
     * Gets the details about this Job
     *
     * @return String
     */
    public String getJobDetails() {
        return jobDetails;
    }

    /**
     * Sets the details about this Job
     *
     * @param jobDetails Job details
     */
    public void setJobDetails(String jobDetails) {
        this.jobDetails = jobDetails;
    }

    /**
     * Returns if the job has been completed
     *
     * @return boolean
     */
    public boolean isCompleted() {
        return completed;
    }

    /**
     * Sets if the job has been completed
     *
     * @param completed Job completed
     */
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    /**
     * Returns the price of this Job the client needs to pay
     *
     * @return int
     */
    public int getPrice() {
        return price;
    }

    /**
     * Sets the price for this Job
     *
     * @param price The value of work spent on this Job
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * Returns if the client has paid for this Job
     *
     * @return boolean
     */
    public boolean isPaid() {
        return paid;
    }

    /**
     * Sets if the client has paid for this Job
     *
     * @param paid Has paid
     */
    public void setPaid(boolean paid) {
        this.paid = paid;
    }
}

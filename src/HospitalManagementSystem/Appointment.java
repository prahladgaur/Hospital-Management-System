package HospitalManagementSystem;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Appointment {
    private Connection connection;

    public Appointment(Connection connection){
        this.connection = connection;
    }

    public void viewAppointment(){
        String query = "select * from appointment";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("Appointment: ");
            System.out.println("+------------+--------------------+------------------+");
            System.out.println("| PatientId  | DoctorId           | Date             |");
            System.out.println("+------------+--------------------+------------------+");
            while(resultSet.next()){
                int patient = resultSet.getInt("patient_id");
                int doctor = resultSet.getInt("doctor_id");
                Date date = resultSet.getDate("appointment_date");
                System.out.printf("| %-10s | %-18s | %-16s |\n", patient, doctor, date);
                System.out.println("+------------+--------------------+------------------+");
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

}

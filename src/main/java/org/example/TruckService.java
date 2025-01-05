package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TruckService {
    //it is TruckService class like kya kya functionalities provide karungaa mai apne project ko ..it is not like Truck ki service...lol :)
    //take the methods like addTruck,getTruckById,updateTruck,getAllTrucks,deleteTruck for tge functionalities of Truckservice
    public void addTruck(Truck truck)
    {
        String sql ="insert into truck (name,model,capacity,driverName) values (?,?,?,?)";
        try
        {
            Connection connection = ConnectionDetails.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,truck.getName());
            preparedStatement.setString(2,truck.getModel());
            preparedStatement.setInt(3,truck.getCapacity());
            preparedStatement.setString(4,truck.getDriverName());

            int update = preparedStatement.executeUpdate();
            System.out.println("Row inserted: "+update);

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public Truck getTruckById(int id)
    {
        String sql = "select * from truck where id = ?";
        Truck truck = new Truck();
        try
        {
            Connection connection = ConnectionDetails.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery(); // executeQuery kyu kyuki yahaa pe fetch kar rahe hai data

            if(resultSet.next())
            {
                truck.setId(resultSet.getInt("id"));
                truck.setName(resultSet.getString("name"));
                truck.setModel(resultSet.getString("model"));
                truck.setCapacity(resultSet.getInt("capacity"));
                truck.setDriverName(resultSet.getString("driverName"));
            }
        }
        catch(SQLException e)
        {
            throw new RuntimeException(e);
        }
        return truck;
    }

    public void updateTruck(Truck truck)
    {
        String sql = "update truck set name = ?, model = ?, capacity = ?, driverName = ? where id = ?";
        try
        {
            Connection connection = ConnectionDetails.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,truck.getName());
            preparedStatement.setString(2,truck.getModel());
            preparedStatement.setInt(3,truck.getCapacity());
            preparedStatement.setString(4,truck.getDriverName());
            preparedStatement.setInt(5,truck.getId());

            int update = preparedStatement.executeUpdate();
            System.out.println("Row updated: "+update);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public List<Truck> getAllTrucks()
    {
        String sql = "select * from truck";
        List<Truck> trucks = new ArrayList<Truck>();
        try {
            Connection connection = ConnectionDetails.getConnection();
            Statement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next())
            {
                Truck truck = new Truck();
                truck.setId(resultSet.getInt("id"));
                truck.setName(resultSet.getString("name"));
                truck.setModel(resultSet.getString("model"));
                truck.setCapacity(resultSet.getInt("capacity"));
                truck.setDriverName(resultSet.getString("driverName"));
                trucks.add(truck);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return trucks;
    }

    public void deleteTruck(int id)
    {
        String deleteQuery = "delete from truck where id = ?";
        try{
            Connection connection = ConnectionDetails.getConnection();
            PreparedStatement preparedstatement = connection.prepareStatement(deleteQuery);
            preparedstatement.setInt(1,id);
            int update= preparedstatement.executeUpdate();
            System.out.println("Row deleted: "+update);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}

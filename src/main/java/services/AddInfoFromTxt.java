package services;

import models.*;
import repasotorys.RepoCompany;
import repasotorys.RepoPassInTrip;
import repasotorys.RepoPassenger;
import repasotorys.RepoTrip;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.sql.Time;

public class AddInfoFromTxt {
    BufferedReader bufferedReader;

    public void addPassenger() {

        RepoPassenger repoPassenger = new RepoPassenger();
        String[] read = new String[4];
        String s = "";
        try {
            bufferedReader = new BufferedReader(new FileReader("src\\main\\resources\\passengers.txt"));
            s = bufferedReader.readLine();

            while (true) {
                s = bufferedReader.readLine();
                if (s == null)
                    break;
                read = s.split(",");
                repoPassenger.create(new Passenger(read[0], read[1], (new Address(read[2], read[3]))));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void addCompany() {

        RepoCompany repoCompany = new RepoCompany();
        String[] read;
        String s = "";
        String[] dt;
        try {
            bufferedReader = new BufferedReader(new FileReader("src\\\\main\\\\resources\\\\companies.txt"));
            bufferedReader.readLine();
            while (true) {
                s = bufferedReader.readLine();
                if (s == null)
                    break;
                read = s.split(",");
                dt = read[1].split("/");
                repoCompany.create(new Company(read[0], Date.valueOf(dt[2] + "-" + dt[0] + "-" + dt[1])));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addTrip() {
        RepoTrip repoTrip = new RepoTrip();
        RepoCompany repoCompany = new RepoCompany();
        String[] read;
        String s = "";
        try {
            bufferedReader = new BufferedReader(new FileReader("src\\\\main\\\\resources\\\\trips.txt"));
            while (true) {
                s = bufferedReader.readLine();
                if (s == null)
                    break;
                read = s.split(",");
                String time_out = read[5].split(" ")[1].substring(0, 8);
                String time_in = read[6].split(" ")[1].substring(0, 8);
                repoTrip.create(new Trip(Long.parseLong(read[0]), read[2],
                        read[3], read[4], Time.valueOf(time_out), Time.valueOf(time_in), repoCompany.read(Long.valueOf(read[1]))));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void passInTrip() {
        RepoPassInTrip repoPassInTrip = new RepoPassInTrip();

        String[] read;
        String s = "";
        try {
            bufferedReader = new BufferedReader(new FileReader("src\\\\main\\\\resources\\\\pass_in_trip.txt"));
            bufferedReader.readLine();
            while (true) {
                s = bufferedReader.readLine();
                if (s == null)
                    break;
                read = s.split(",");
                repoPassInTrip.create(new PassInTrip(new PassInTrip.PassInTripId(Long.valueOf(read[0]), Long.valueOf(read[1]), Date.valueOf(read[2].split(" ")[0])), read[3]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

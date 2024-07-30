package com.example.flightstatus;

import java.util.List;

public class AviationApiResponse {
    private List<Data> data;

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    public static class Data {
        private String flight_iata;
        private String flight_status;
        private Departure departure;

        public String getFlight_iata() {
            return flight_iata;
        }

        public void setFlight_iata(String flight_iata) {
            this.flight_iata = flight_iata;
        }

        public String getFlight_status() {
            return flight_status;
        }

        public void setFlight_status(String flight_status) {
            this.flight_status = flight_status;
        }

        public Departure getDeparture() {
            return departure;
        }

        public void setDeparture(Departure departure) {
            this.departure = departure;
        }

        public static class Departure {
            private String timezone;

            public String getTimezone() {
                return timezone;
            }

            public void setTimezone(String timezone) {
                this.timezone = timezone;
            }
        }
    }
}

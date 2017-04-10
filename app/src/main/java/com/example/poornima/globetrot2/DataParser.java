package com.example.poornima.globetrot2;

import java.util.List;

/**
 * Created by mohit on 4/7/2017.
 */

public class DataParser {

    private List<ResultsBean> results;

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        /**
         * geometry : {"location":{"lat":22.7224715,"lng":75.8796431},"viewport":{"northeast":{"lat":22.7238204802915,"lng":75.8809920802915},"southwest":{"lat":22.72112251970849,"lng":75.8782941197085}}}
         * icon : https://maps.gstatic.com/mapfiles/place_api/icons/restaurant-71.png
         * id : 549808c5a87492affc86a14469fdf3e09a8b8455
         * name : Four Seasons Restaurant
         * opening_hours : {"open_now":true,"weekday_text":[]}
         * photos : [{"height":640,"html_attributions":["<a href=\"https://maps.google.com/maps/contrib/114012218349913301967/photos\">Four Seasons Restaurant<\/a>"],"photo_reference":"CoQBdwAAANKYzdFygdoOeM3DNIuanLcjeyvUI7T-hL-w09oLkIeoDB4M61TaC1-PJ8uqigwO3_cBIhMtH8iRI8qX1PWU8PDJ-bp-HPzflKMT0d1nqvWH061CiTFdezUmYCqwYkyMsU5NUzwON9i07fr3rZA_6zyN0FDqqGyJkuGMookeltLeEhBRal6mkq5HrlND183zfkVnGhRQbBWSbjOcy83LO-JKEZEC7RROkA","width":640}]
         * place_id : ChIJOc3c_z79YjkRXpIVWTgNG5A
         * rating : 4.2
         * reference : CmRSAAAAcZd1d4LCj5l4SEBe8clVd61uYdVCsxOq66iNXVBzmkKwDvSM4jzEzC8wovGhixehDhgDoNKkao-JO2yiDSGgAStsUSU1SJcDeLKNDm48nxEtTH4J7NuzPw9-QgzxXM1eEhDZzd3OxObLLosr2w2Rgm8EGhTSxXQ7Cu-4XsAcsqqVF4x62djg2g
         * scope : GOOGLE
         * types : ["restaurant","food","point_of_interest","establishment"]
         * vicinity : 401-402, Shiv Om Complex, M.G. Road, Indore
         */

        private GeometryBean geometry;
        private String name;
        private double rating;
        private List<PhotosBean> photos;

        public GeometryBean getGeometry() {
            return geometry;
        }

        public void setGeometry(GeometryBean geometry) {
            this.geometry = geometry;
        }


        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }



        public double getRating() {
            return rating;
        }

        public void setRating(double rating) {
            this.rating = rating;
        }



        public List<PhotosBean> getPhotos() {
            return photos;
        }

        public void setPhotos(List<PhotosBean> photos) {
            this.photos = photos;
        }

        public static class GeometryBean {
            /**
             * location : {"lat":22.7224715,"lng":75.8796431}
             * viewport : {"northeast":{"lat":22.7238204802915,"lng":75.8809920802915},"southwest":{"lat":22.72112251970849,"lng":75.8782941197085}}
             */

            private LocationBean location;

            public LocationBean getLocation() {
                return location;
            }

            public void setLocation(LocationBean location) {
                this.location = location;
            }

            public static class LocationBean {
                /**
                 * lat : 22.7224715
                 * lng : 75.8796431
                 */

                private double lat;
                private double lng;

                public double getLat() {
                    return lat;
                }

                public void setLat(double lat) {
                    this.lat = lat;
                }

                public double getLng() {
                    return lng;
                }

                public void setLng(double lng) {
                    this.lng = lng;
                }
            }

        }


        public static class PhotosBean {

            private String photo_reference;

            public String getPhoto_reference() {
                return photo_reference;
            }

            public void setPhoto_reference(String photo_reference) {
                this.photo_reference = photo_reference;
            }
            }
        }
    }


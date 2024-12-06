const BASE_URL_API= "http://localhost:8000/api/v1/autosoorten";

const app = new Vue({
    el: '#main',

    data: {
        result: "",
        responseAvailable: false,
        responseAvailableCreation: false,
        responseAvailableSearch: false,
        autosoortData: {
            id: 0,
            naam: "naam",
            merk: "merk",
            huidigVoorraadniveau: "1",
            minimumpeiler: "1",
            maximumpeiler: "10",
            naamToBeFound: "naam"
        }
    },
    methods: {
        fetchAPIData( ) {
            this.responseAvailable = false;
            this.responseAvailableCreation = false;
            this.responseAvailableSearch = false

            fetch(BASE_URL_API, {
                "method": "GET",
                "headers": {
                }
            })
                .then(response => {
                    if(response.ok){
                        return response.json()
                    } else{
                        alert("Server returned " + response.status + " : " + response.statusText);
                    }
                })
                .then(response => {
                    this.result = response;
                    this.responseAvailable = true;
                })
                .catch(err => {
                    console.log(err);
                });
        },
        submitForm( ) {
            this.responseAvailable = false;
            this.responseAvailableCreation = false;
            this.responseAvailableSearch = false

            fetch(BASE_URL_API, {
                "method": "POST",
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                },
                "body": JSON.stringify(this.autosoortData),
            })
                .then(response => {
                    if(response.ok){
                        return response.json()
                    } else{
                        alert("Server returned " + response.status + " : " + response.statusText);
                    }
                })
                .then(response => {
                    this.result = response;
                    this.responseAvailableCreation = true;
                })
                .catch(err => {
                    console.log(err);
                });
        },
        searchForm( ) {
            this.responseAvailable = false;
            this.responseAvailableCreation = false;
            this.responseAvailableSearch = false

            fetch(BASE_URL_API+'/'+this.autosoortData.naamToBeFound, {
                "method": "GET",
                "headers": {
                }
            })
                .then(response => {
                    if(response.ok){
                        return response.json()
                    } else {
                        alert("Server returned " + response.status + " : " + response.statusText);
                    }
                })
                .then(response => {
                    this.result = response;
                    this.responseAvailableSearch = true;
                })
                .catch(err => {
                    console.log(err);
                });
        },
        deleteAllAutosoorten() {
            this.responseAvailable = false;
            this.responseAvailableCreation = false;
            this.responseAvailableSearch = false

            fetch(BASE_URL_API, {"method": "DELETE"})
                .then(response => {
                    this.result = response;
                    this.responseAvailable = true;
                })
                .catch(err => {
                    console.log(err);
                });
        }
    }
})
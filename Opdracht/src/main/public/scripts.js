const BASE_URL_API= "http://localhost:8000/api/v1/autosoorten";

function navigateTo(page) {
    window.location.href = page;
}

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
            huidigVoorraadniveau: 1,
            minimumpeiler: "1",
            maximumpeiler: "10",
            naamToBeFound: "naam"
        },
        // Facturen
        resultFacturen: "",
        responseFacturen: false,
        factuurData: {
            id: 0,
            nummer: "",
        },

        // Medewerkers
        resultMedewerkers: "",
        responseMedewerkers: false,
        medewerkerData: {
            id: 0,
            voornaam: "",
            achternaam: "",
            email: "",
            telefoonnummer: "",
            functie: ""
        },

        // Verkopen
        resultVerkopen: "",
        responseVerkopen: false,
        verkoopData: {
            autosoortId: "",
            factuurId: "",
            medewerkerId: ""
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
        },// Facturen
        fetchFacturen() {
            fetch(BASE_URL_FACTUREN).then(res => res.json())
                .then(data => { this.resultFacturen = data; this.responseFacturen = true; });
        },
        addFactuur() {
            fetch(BASE_URL_FACTUREN, {
                method: "POST",
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(this.factuurData)
            }).then(() => alert("Factuur toegevoegd!"));
        },
        deleteFacturen() {
            fetch(BASE_URL_FACTUREN, { method: "DELETE" })
                .then(() => alert("Alle facturen verwijderd!"));
        },

        // Medewerkers
        fetchMedewerkers() {
            fetch(BASE_URL_MEDEWERKERS).then(res => res.json())
                .then(data => { this.resultMedewerkers = data; this.responseMedewerkers = true; });
        },
        addMedewerker() {
            fetch(BASE_URL_MEDEWERKERS, {
                method: "POST",
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(this.medewerkerData)
            }).then(() => alert("Medewerker toegevoegd!"));
        },
        deleteMedewerkers() {
            fetch(BASE_URL_MEDEWERKERS, { method: "DELETE" })
                .then(() => alert("Alle medewerkers verwijderd!"));
        },

        // Verkopen
        addVerkoop() {
            fetch(BASE_URL_VERKOPEN, {
                method: "POST",
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(this.verkoopData)
            }).then(() => alert("Verkoop toegevoegd!"));
        }
    }
})